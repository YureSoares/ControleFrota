package com.example.controlefrota.model;

public class Carro {

    private String ID;
    private String PLACA;
    private String MODELO;
    private String MARCA;
    private String ANO;
    private String ATIVO;

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getPLACA() {
        return PLACA;
    }

    public void setPLACA(String PLACA) {
        this.PLACA = PLACA;
    }

    public String getMODELO() {
        return MODELO;
    }

    public void setMODELO(String MODELO) {
        this.MODELO = MODELO;
    }

    public String getMARCA() {
        return MARCA;
    }

    public void setMARCA(String MARCA) {
        this.MARCA = MARCA;
    }

    public String getANO() {
        return ANO;
    }

    public void setANO(String ANO) {
        this.ANO = ANO;
    }

    public String getATIVO() {
        return ATIVO;
    }

    public void setATIVO(String ATIVO) {
        this.ATIVO = ATIVO;
    }
}
