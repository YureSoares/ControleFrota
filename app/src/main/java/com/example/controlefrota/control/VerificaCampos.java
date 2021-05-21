package com.example.controlefrota.control;

import java.util.Iterator;
import java.util.Map;

public class VerificaCampos {



    public String VerificasCamposVazios( Map<String ,String> campos) {
        String CampoVazio = "N";

        for (Map.Entry<String,String> i : campos.entrySet()) {
            if (i.getValue().isEmpty()){
                CampoVazio = i.getKey();
                break;
            }
        }

        return CampoVazio;
    }
}
