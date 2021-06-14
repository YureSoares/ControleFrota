package com.example.controlefrota;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


public class CriaBanco extends SQLiteOpenHelper {
        public static final String NOME_BANCO = "controlefrota.db";
        public static final String VIAGEM = "VIAGEM";
        public static final String CARRO =  "CARRO";
        public static final String USUARIO = "USUARIO";
        private static int VERSAO = 1;

    public CriaBanco(Context context) {
        super(context, NOME_BANCO, null, VERSAO);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {

        String create_usuario = "CREATE TABLE " + USUARIO + "(" +
        "usu_id integer primary key autoincrement," +
        "usu_nome text," +
        "usu_email text," +
        "usu_login text," +
        "usu_senha text" +
        ")";

        db.execSQL(create_usuario);

        String create_carro = "CREATE TABLE " + CARRO + "(" +
                "car_id integer primary key autoincrement," +
                "car_placa text," +
                "car_modelo text," +
                "car_marca text," +
                "car_ano text," +
                "car_ativo text" +
                ")";

        db.execSQL(create_carro);

        String create_viagem = "CREATE TABLE " + VIAGEM + "(" +
                "vgm_id integer primary key autoincrement," +
                "usu_id integer," +
                "car_id integer," +
                "vgm_placa text," +
                "vgm_combustivel text," +
                "vgm_kmini text," +
                "vgm_kmend text," +
                "vgm_dtini text," +
                "vgm_dtend text," +
                "FOREIGN KEY(usu_id) references " + USUARIO + " (usu_id)," +
                "FOREIGN KEY(car_id) references " + CARRO + "(car_id) " +
                ")";

        db.execSQL(create_viagem);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {

        db.execSQL("DROP TABLE IF EXISTS " + USUARIO);
        db.execSQL("DROP TABLE IF EXISTS " + CARRO);
        db.execSQL("DROP TABLE IF EXISTS " + VIAGEM);
        VERSAO ++;
        onCreate(db);

    }
}
