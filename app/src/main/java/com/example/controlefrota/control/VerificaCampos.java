package com.example.controlefrota.control;


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

    public Boolean SenhaForte(String senha){
        Boolean forte;
        Boolean maisculo = false;
        Boolean numero = false;
        Boolean especial = false;

        for(int i = 0; i < senha.length(); i++){
            if(Character.isUpperCase(senha.charAt(i))){
                maisculo = true;
            }
            if(Character.isDigit(senha.charAt(i))){
                numero = true;
            }
            if(!Character.isLetterOrDigit(senha.charAt(i))){
                especial = true;
            }


        }
        if(senha.length() >= 6 && maisculo == true && numero == true && especial == true ){
            forte = true;
        } else {
            forte = false;
        }


        return forte;
    }
}
