package com.example.rebobine04.Model;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Funcionarios {
    private String nome;
    private String email;
    private String senha;

    public Funcionarios(){

    }

    public Funcionarios(String nome, String email, String senha) {
        this.nome = nome;
        this.email = email;
        this.senha = senha;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public void salvarFuncionario(){
        FirebaseAuth auth = FirebaseAuth.getInstance();
        String userFuncionario = auth.getCurrentUser().getUid();
        DatabaseReference reference = FirebaseDatabase.getInstance().getReference("funcionario");
        reference.child(userFuncionario).setValue(this);
    }
}








