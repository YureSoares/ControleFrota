package com.example.controlefrota.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.controlefrota.CriaBanco;
import com.example.controlefrota.model.Usuario;

public class usuarioDAO {

    private SQLiteDatabase db;

    private String ID = "usu_id";
    private String NOME = "usu_nome";
    private String EMAIL = "usu_email";
    private String LOGIN = "usu_login";
    private String SENHA = "usu_senha";

    private CriaBanco banco;
    public usuarioDAO(Context context){
        banco = new CriaBanco(context);
    }

    public Usuario cursorValues(Cursor c) {

        Usuario usuario = new Usuario();

        usuario.setID(c.getString(c.getColumnIndex(ID)));
        usuario.setNOME(c.getString(c.getColumnIndex(NOME)));
        usuario.setEMAIL(c.getString(c.getColumnIndex(EMAIL)));
        usuario.setLOGIN(c.getString(c.getColumnIndex(LOGIN)));
        usuario.setSENHA(c.getString(c.getColumnIndex(SENHA)));

        return usuario;
    }

        public ContentValues toValues(Usuario usuario) {

        ContentValues cv = new ContentValues();

        cv.put(ID,    usuario.getID());
        cv.put(NOME,  usuario.getNOME());
        cv.put(EMAIL, usuario.getEMAIL());
        cv.put(LOGIN, usuario.getLOGIN());
        cv.put(SENHA, usuario.getSENHA());

        return cv;
    }

    public boolean insertValues(Usuario usu) {
        boolean inserted = false;
        db = banco.getWritableDatabase();

        try {

            long a = db.insert(CriaBanco.USUARIO,null,toValues(usu));

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
