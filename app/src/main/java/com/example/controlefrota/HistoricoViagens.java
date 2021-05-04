package com.example.controlefrota;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.controlefrota.model.Viagem;

import java.util.List;


public class HistoricoViagens extends AppCompatActivity {

    private ListView LvHist;
    private List<Viagem> viagem;
    private ArrayAdapter<Viagem> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.historico_viagens);

        init();
        
    }

    private void init(){
        LvHist = findViewById(R.id.lv_hist);
        viagem =  Singleton.getInstance().getViagens();
        adapter = new ArrayAdapter<Viagem>(this, android.R.layout.simple_list_item_1,viagem);
        LvHist.setAdapter(adapter);
    }
}