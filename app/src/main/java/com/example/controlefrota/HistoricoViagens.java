package com.example.controlefrota;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.example.controlefrota.model.Viagem;

import java.util.List;


public class HistoricoViagens extends AppCompatActivity {

    private ListView LvHist;
    private List<Viagem> ListViagem;
    private AdapterHistoricoViagens adapter;
    MainActivity main =  new MainActivity();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.historico_viagens);

        init();
        eventoListViewHistorico();
        
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();

        Intent it = new Intent(HistoricoViagens.this, MainActivity.class);
        startActivity(it);
        finish();
    }

    private void eventoListViewHistorico(){
        LvHist.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView <?> adapterView, View view, int i, long l) {
                Intent it = new Intent(HistoricoViagens.this, ResumoViagem.class);
                it.putExtra("placa", ListViagem.get(i).getPlaca().toString());
                it.putExtra("dtinicio", ListViagem.get(i).getDtInicio().toString());
                it.putExtra("kminicio", ListViagem.get(i).getKmInicio().toString());
                it.putExtra("dtend", ListViagem.get(i).getDtEnd().toString());
                it.putExtra("kmend", ListViagem.get(i).getKmEnd().toString());
                it.putExtra("combustivel", ListViagem.get(i).getCombustivel().toString());


                startActivity(it);
               // finish();
            }
        });
    }


    private void init(){
        LvHist = findViewById(R.id.lv_hist);
        ListViagem =  Singleton.getInstance().getViagens();
        adapter = new AdapterHistoricoViagens(ListViagem, this);
        LvHist.setAdapter(adapter);

    }
}