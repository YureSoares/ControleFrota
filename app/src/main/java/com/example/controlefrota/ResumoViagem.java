package com.example.controlefrota;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class ResumoViagem extends AppCompatActivity {

    private TextView tvPlaca;
    private TextView tvKmIni;
    private TextView tvDtIni;
    private TextView tvKmEnd;
    private TextView tvDtEnd;
    private TextView combustivel;
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.resumo_viagem);


        init();

        insertParametros();
    }

    private void insertParametros(){

        tvPlaca.setText(intent.getSerializableExtra("placa").toString());
        tvKmIni.setText(intent.getSerializableExtra("kminicio").toString());
        tvDtIni.setText(intent.getSerializableExtra("dtinicio").toString());
        tvKmEnd.setText(intent.getSerializableExtra("kmend").toString());
        tvDtEnd.setText(intent.getSerializableExtra("dtend").toString());
        combustivel.setText(intent.getSerializableExtra("combustivel").toString());



    }

    private void init(){
        intent = getIntent();
        tvPlaca = findViewById(R.id.tv_resumoviagem_placa);
        tvKmIni = findViewById(R.id.tv_resumoviagem_kminicio);
        tvDtIni = findViewById(R.id.tv_resumoviagem_dtinicio);
        tvKmEnd = findViewById(R.id.tv_resumoviagem_kmfim);
        tvDtEnd = findViewById(R.id.tv_resumoviagem_dtfim);
        combustivel = findViewById(R.id.tv_resumoviagem_combustivel);

    }
}