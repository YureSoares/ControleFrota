package com.example.controlefrota.model;

public class Viagem {
    private String placa;
    private String combustivel;
    private String kmInicio;
    private String dtInicio;
    private String kmEnd;
    private String dtEnd;

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getCombustivel() {
        return combustivel;
    }

    public void setCombustivel(String combustivel) {
        this.combustivel = combustivel;
    }

    public String getKmInicio() {
        return kmInicio;
    }

    public void setKmInicio(String kmInicio) {
        this.kmInicio = kmInicio;
    }

    public String getDtInicio() {
        return dtInicio;
    }

    public void setDtInicio(String dtInicio) {
        this.dtInicio = dtInicio;
    }

    public String getKmEnd() {
        return kmEnd;
    }

    public void setKmEnd(String kmEnd) {
        this.kmEnd = kmEnd;
    }

    public String getDtEnd() {
        return dtEnd;
    }

    public void setDtEnd(String dtEnd) {
        this.dtEnd = dtEnd;
    }

    public String toString(){
        return "Placa: " + placa + " Data Inicio: "  + dtInicio  + " Data Fim: " + dtEnd  + " Combustivel: " +  combustivel + " KM Inicio: " + kmInicio +  " KM Fim: " + kmEnd;
    }
}
