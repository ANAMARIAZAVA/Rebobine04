package com.example.rebobine04.ActivityClasses;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.rebobine04.Model.Funcionarios;
import com.example.rebobine04.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class cadastrofuncionario extends AppCompatActivity {

    private EditText nomeRegister;
    private EditText emailRegister;
    private EditText senhaRegister;;
    private Button btCadastrar;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_cadastrofuncionario);

        mAuth = FirebaseAuth.getInstance();
        iniciarID();

        btCadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Funcionarios funcionarios = new Funcionarios();

                funcionarios.setNome (nomeRegister.getText().toString());
                funcionarios.setEmail(emailRegister.getText().toString());
                String registrarSenha = senhaRegister.getText().toString();

                if(!TextUtils.isEmpty(funcionarios.getNome()) || !TextUtils.isEmpty(funcionarios.getEmail()) || TextUtils.isEmpty(registrarSenha)){
                    mAuth.createUserWithEmailAndPassword(funcionarios.getEmail(), registrarSenha).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()){
                                funcionarios.salvarFuncionario();
                                mudarTela();
                            } else {
                                String error = task.getException().getMessage();
                                Toast.makeText(cadastrofuncionario.this, ""+error, Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
                }
            }
        });

    }

    private void iniciarID(){
        nomeRegister = findViewById(R.id.nomeRegister);
        emailRegister = findViewById(R.id.emailRegister);
        senhaRegister = findViewById(R.id.senhaRegister);
        btCadastrar = findViewById(R.id.btCadastrar);
    }

    private void mudarTela() {
        Intent intent = new Intent(cadastrofuncionario.this, MainActivity.class);
        startActivity(intent);
        finish();
    }
}