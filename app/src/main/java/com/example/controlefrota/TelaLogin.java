package com.example.controlefrota;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class TelaLogin extends AppCompatActivity {

    private TextView tvUser;
    private EditText etUser;
    private TextView tvPass;
    private EditText etPass;
    private Button btnEntrar;
    private Button btnCadastro;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tela_login);

        init();
        eventoBtnEntrar();
        eventoBtnCadastro();
    }

    private void eventoBtnEntrar(){
        btnEntrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it = new Intent(TelaLogin.this, MainActivity.class);
                startActivity(it);
            }
        });

    }

    private void eventoBtnCadastro(){
        btnCadastro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it = new Intent(TelaLogin.this, TelaCadastro.class);
                startActivity(it);
            }
        });

    }

    private void init(){
          tvUser = findViewById(R.id.telalogin_tvuser);
          etUser = findViewById(R.id.telalogin_etuser);
          tvPass = findViewById(R.id.telalogin_tvpass);
          etPass = findViewById(R.id.telalogin_etpass);
          btnEntrar = findViewById(R.id.telalogin_btnentrar);
          btnCadastro = findViewById(R.id.telalogin_btncadastro);
    }
}