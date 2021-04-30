package com.example.controlefrota;

import java.util.ArrayList;
import java.util.List;

public class Singleton {
    private static Singleton instance;
    private List<String> lista;

    private Singleton(){
        lista  = new ArrayList<String>();
        /*lista.add("VIAGEM1");
        lista.add("VIAGEM2");
        lista.add("VIAGEM3");*/
    }

    public static Singleton getInstance(){
        if (instance == null){
            instance = new Singleton();
        }
        return instance;
    }

    public void addViagem(String nameViagem){
        lista.add(nameViagem);
    }

    public List<String> getViagens(){
        return lista;
    }
}
