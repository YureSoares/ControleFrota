package com.example.controlefrota;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;


public class HistoricoViagens extends AppCompatActivity {

    private ListView LvHist;
    private String[] historicos;
    private ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.historico_viagens);

        init();





        
    }

    private void init(){
        LvHist = findViewById(R.id.lv_hist);
        historicos = new String[] {"VIAGEM1","VIAGEM2","VIAGEM3"};
        adapter = new ArrayAdapter<String>(this, android.R.layout.activity_list_item,historicos);
        LvHist.setAdapter(adapter);
    }
}