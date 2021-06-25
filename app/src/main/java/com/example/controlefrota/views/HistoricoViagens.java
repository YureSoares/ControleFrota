package com.example.controlefrota.views;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.controlefrota.R;
import com.example.controlefrota.Singleton;
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
                it.putExtra("placa", ListViagem.get(i).getPLACA().toString());
                it.putExtra("dtinicio", ListViagem.get(i).getDTINI().toString());
                it.putExtra("kminicio", ListViagem.get(i).getKMINI().toString());
                it.putExtra("dtend", ListViagem.get(i).getDTEND().toString());
                it.putExtra("kmend", ListViagem.get(i).getKMEND().toString());
                it.putExtra("combustivel", ListViagem.get(i).getCOMBUSTIVEL().toString());


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