package com.example.controlefrota.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.controlefrota.CriaBanco;
import com.example.controlefrota.model.Viagem;

public class viagemDAO {

    private SQLiteDatabase db;
    private CriaBanco banco;

    private String ID = "vgm_id";
    private String USUARIO = "usu_id";
    private String CARRO = "car_id";
    private String PLACA = "vgm_placa";
    private String COMBUSTIVEL = "vgm_combustivel";
    private String KMINI = "vgm_kmini";
    private String KMEND = "vgm_kmend";
    private String DTINI = "vgm_dtini";
    private String DTEND = "vgm_dtend";

    public viagemDAO(Context context){
        banco = new CriaBanco(context);
    }

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

    public ContentValues toValues(Viagem viagem) {

        ContentValues cv = new ContentValues();

        cv.put(ID, viagem.getID());
        cv.put(USUARIO,  viagem.getUSUARIO());
        cv.put(CARRO, viagem.getCARRO());
        cv.put(PLACA, viagem.getPLACA());
        cv.put(COMBUSTIVEL, viagem.getCOMBUSTIVEL());
        cv.put(KMINI, viagem.getKMINI());
        cv.put(KMEND, viagem.getKMEND());
        cv.put(DTINI, viagem.getDTINI());
        cv.put(DTEND, viagem.getDTEND());

        return cv;
    }

    public boolean insertValues(Viagem viagem) {
        boolean inserted = false;
        db = banco.getWritableDatabase();

        try {

            long a = db.insert(CriaBanco.VIAGEM,null,toValues(viagem));

            if (a == 1)

                inserted = true;

            else

                inserted = false;

        }catch (Exception e) {

            inserted = false;
            e.printStackTrace();

        } finally {
            db.close();
        }

        return inserted;
    }

}
