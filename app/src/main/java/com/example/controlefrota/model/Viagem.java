package com.example.controlefrota.model;

public class Viagem {
    private String ID;
    private String USUARIO;
    private String CARRO;
    private String PLACA;
    private String COMBUSTIVEL;
    private String KMINI;
    private String KMEND;
    private String DTINI;
    private String DTEND;

    public String getID() {
        return ID;
    }

    public void setID(String id) {
        this.ID = id;
    }

    public String getUSUARIO() {
        return USUARIO;
    }

    public void setUSUARIO(String usuario) {
        this.USUARIO = usuario;
    }

    public String getCARRO() {
        return CARRO;
    }

    public void setCARRO(String carro) {
        this.CARRO = carro;
    }

    public String getPLACA() {
        return PLACA;
    }

    public void setPLACA(String placa) {
        this.PLACA = placa;
    }

    public String getCOMBUSTIVEL() {
        return COMBUSTIVEL;
    }

    public void setCOMBUSTIVEL(String combustivel) {
        this.COMBUSTIVEL = combustivel;
    }

    public String getKMINI() {
        return KMINI;
    }

    public void setKMINI(String kmInicio) {
        this.KMINI = kmInicio;
    }

    public String getKMEND() {
        return KMEND;
    }

    public void setKMEND(String kmEnd) {
        this.KMEND = kmEnd;
    }

    public String getDTINI() {
        return DTINI;
    }

    public void setDTINI(String dtInicio) {
        this.DTINI = dtInicio;
    }

    public String getDTEND() {
        return DTEND;
    }

    public void setDTEND(String dtEnd) {
        this.DTEND = dtEnd;
    }

    public String toString(){
        return "Placa: " + PLACA + " Data Inicio: "  + DTINI  + " Data Fim: " + DTEND  + " Combustivel: " +  COMBUSTIVEL + " KM Inicio: " + KMINI +  " KM Fim: " + KMEND;
    }
}
