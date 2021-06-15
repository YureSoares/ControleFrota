package com.example.controlefrota.dao;

import android.database.Cursor;

import com.example.controlefrota.model.Carro;

public class carroDAO {

    private String ID = "car_id";
    private String PLACA = "car_nome";
    private String MODELO = "car_modelo";
    private String MARCA = "car_marca";
    private String ANO = "car_ano";
    private String ATIVO = "car_ativo";

    public Carro cursorValues(Cursor c){

        Carro carro = new Carro();

        carro.setID(c.getString(c.getColumnIndex(ID)));
        carro.setPLACA(c.getString(c.getColumnIndex(PLACA)));
        carro.setMODELO(c.getString(c.getColumnIndex(MODELO)));
        carro.setMARCA(c.getString(c.getColumnIndex(MARCA)));
        carro.setANO(c.getString(c.getColumnIndex(ANO)));
        carro.setATIVO(c.getString(c.getColumnIndex(ATIVO)));

        return carro;
    }
}
