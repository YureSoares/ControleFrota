package com.example.controlefrota;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.List;


public class HistoricoViagens extends AppCompatActivity {

    private ListView LvHist;
    private List historicos;
    private ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.historico_viagens);

        init();
        
    }

    private void init(){
        LvHist = findViewById(R.id.lv_hist);
        historicos =  Singleton.getInstance().getViagens();
        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,historicos);
        LvHist.setAdapter(adapter);
    }
}