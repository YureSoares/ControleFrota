package com.example.controlefrota.dao;

import android.content.ContentValues;
import android.database.Cursor;

import com.example.controlefrota.CriaBanco;
import com.example.controlefrota.model.Carro;
import com.example.controlefrota.model.Viagem;

public class viagemDAO {

    private String ID = "vgm_id";
    private String USUARIO = "usu_id";
    private String CARRO = "car_id";
    private String PLACA = "vgm_placa";
    private String COMBUSTIVEL = "vgm_combustivel";
    private String KMINI = "vgm_kmini";
    private String KMEND = "vgm_kmend";
    private String DTINI = "vgm_dtini";
    private String DTEND = "vgm_dtend";

    public Viagem cursorValues(Cursor c){

        Viagem viagem = new Viagem();

        viagem.setID(c.getString(c.getColumnIndex(ID)));
        viagem.setUSUARIO(c.getString(c.getColumnIndex(USUARIO)));
        viagem.setCARRO(c.getString(c.getColumnIndex(CARRO)));
        viagem.setPLACA(c.getString(c.getColumnIndex(PLACA)));
        viagem.setCOMBUSTIVEL(c.getString(c.getColumnIndex(COMBUSTIVEL)));
        viagem.setKMINI(c.getString(c.getColumnIndex(KMINI)));
        viagem.setKMEND(c.getString(c.getColumnIndex(KMEND)));
        viagem.setDTINI(c.getString(c.getColumnIndex(DTINI)));
        viagem.setDTEND(c.getString(c.getColumnIndex(DTEND)));

        return viagem;
    }

    /*public String insereUsuario(String nome, String email, String login, String senha){
        ContentValues valores;
        long resultado;

        db = banco.getWritableDatabase();
        valores = new ContentValues();
        valores.put("usu_nome",nome);
        valores.put("usu_email",email);
        valores.put("usu_login",login);
        valores.put("usu_senha",senha);

        resultado = db.insert(CriaBanco.USUARIO,null,valores);
        db.close();

        if(resultado == -1)
            return "Erro ao inserir registro";
        else
            return "Registro Inserido com sucesso";


    }*/

}
