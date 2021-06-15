package com.example.controlefrota.dao;

import android.database.Cursor;

import com.example.controlefrota.model.Usuario;

public class usuarioDAO {

    private String ID = "usu_id";
    private String NOME = "usu_nome";
    private String EMAIL = "usu_email";
    private String LOGIN = "usu_login";
    private String SENHA = "usu_senha";


    public Usuario cursorValues(Cursor c){

        Usuario usuario = new Usuario();

        usuario.setID(c.getString(c.getColumnIndex(ID)));
        usuario.setNOME(c.getString(c.getColumnIndex(NOME)));
        usuario.setEMAIL(c.getString(c.getColumnIndex(EMAIL)));
        usuario.setLOGIN(c.getString(c.getColumnIndex(LOGIN)));
        usuario.setSENHA(c.getString(c.getColumnIndex(SENHA)));

        return usuario;
    }



}
