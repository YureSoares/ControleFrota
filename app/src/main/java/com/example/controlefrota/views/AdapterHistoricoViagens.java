package com.example.controlefrota.views;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.controlefrota.R;
import com.example.controlefrota.model.Viagem;

import java.util.List;

public class AdapterHistoricoViagens extends BaseAdapter {

    private final List<Viagem> viagens;
    private final Activity act;

    public AdapterHistoricoViagens(List<Viagem> viagens, Activity act){
        this.viagens = viagens;
        this.act = act;
    }

    @Override
    public int getCount() {
        return viagens.size();
    }

    @Override
    public Object getItem(int position) {
        return viagens.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View view  = act.getLayoutInflater().inflate(R.layout.lista_viagens,parent, false);

        Viagem viagem = viagens.get(position);

        TextView placa = view.findViewById(R.id.tv_placa);
        TextView dataInicio = view.findViewById(R.id.tv_data_inicio);
        TextView dataFim = view.findViewById(R.id.tv_data_fim);

        placa.setText(viagem.getPLACA());
        dataInicio.setText(viagem.getDTINI());
        dataFim.setText(viagem.getDTEND());

        return view;
    }
}
