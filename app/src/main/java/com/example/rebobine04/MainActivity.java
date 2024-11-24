package com.example.rebobine04;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
 <!-- Definição das constante -->

    static private String KEY_NOME = "key.nome";
    static private String KEY_SENHA =" Key.senha";

    private String[] array = new String[]{"Arquivo1", "Arquivo 2", "Arquivo 3" , "Arquivo 4", "Arquivo 5"};
    private String arquivo;
    private EditText entrada, exibicao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.rotulotitulocadfunc), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        entrada = findViewById(R.id.edEntrada);
        exibicao = findViewById(R.id.edVisualiza);

         <!-- Método "salvarChave"  -->
            public void salvarChave (View view){
             SharedPreferences preferemces = getPreferences(MODE_PRIVATE);
             SharedPreferences.Editor editor = preferences.edit();
             editor.putString(KEU_NOME,((EditText)findViewById(R.id.edNome)).get)
    }


    }
}



    }




}