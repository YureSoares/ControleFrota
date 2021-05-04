package com.example.controlefrota;

import com.example.controlefrota.model.Viagem;

import java.util.ArrayList;
import java.util.List;

public class Singleton {
    private static Singleton instance;
    private List<Viagem> lista;

    private Singleton(){
        lista  = new ArrayList<Viagem>();
    }

    public static Singleton getInstance(){
        if (instance == null){
            instance = new Singleton();
        }
        return instance;
    }

    public void addViagem(Viagem nameViagem){
        lista.add(nameViagem);
    }

    public List<Viagem> getViagens(){
        return lista;
    }
}
