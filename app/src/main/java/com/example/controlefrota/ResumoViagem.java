package com.example.controlefrota;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class ResumoViagem extends AppCompatActivity {

    private TextView tvPlaca;
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.resumo_viagem);

        tvPlaca =(TextView)tvPlaca.findViewById(R.id.tv_resumo_viagem_placa);

        init();

        insertParametros();
    }

    private void insertParametros(){

       // tvPlaca.setText(intent.getSerializableExtra("placa").toString());

    }

    private void init(){
        //tvPlaca =(TextView)tvPlaca.findViewById(R.id.tv_resumo_viagem_placa);
        intent = getIntent();
    }
}