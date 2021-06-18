package com.example.controlefrota.control;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.CursorIndexOutOfBoundsException;
import android.database.sqlite.SQLiteDatabase;

import com.example.controlefrota.CriaBanco;

public class BancoController {

    private SQLiteDatabase db;
    private CriaBanco banco;

    public BancoController(Context context){
        banco = new CriaBanco(context);
    }

    public String insereUsuario(String nome, String email, String login, String senha){
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


    }

}

