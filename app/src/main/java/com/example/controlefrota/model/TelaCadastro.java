package com.example.controlefrota.model;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.controlefrota.MainActivity;
import com.example.controlefrota.R;
import com.example.controlefrota.TelaLogin;


public class TelaCadastro extends AppCompatActivity {

    private Button btnFinal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tela_cadastro);

        init();
        eventoBtnFinalizar();

    }

    private void eventoBtnFinalizar(){
        btnFinal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it = new Intent(TelaCadastro.this, TelaLogin.class);
                startActivity(it);
                finish();
            }
        });

    }

    private void init(){
        btnFinal = findViewById(R.id.telacadastro_btnfinal);
    };




}