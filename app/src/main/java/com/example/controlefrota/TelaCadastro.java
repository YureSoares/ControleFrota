package com.example.controlefrota;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.controlefrota.control.BancoController;
import com.example.controlefrota.control.VerificaCampos;
import com.example.controlefrota.dao.usuarioDAO;
import com.example.controlefrota.model.Usuario;

import java.util.HashMap;
import java.util.Map;


public class TelaCadastro extends AppCompatActivity {

    private Button btnFinal;
    private TextView tvMensagem;
    private EditText etNome;
    private EditText etEmail;
    private EditText etLogin;
    private EditText etSenha;
    private Map<String,String> map = new HashMap<String, String>();
    VerificaCampos vc = new VerificaCampos();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tela_cadastro);

        init();
        eventoBtnFinalizar();

    }

    private void eventoBtnFinalizar(){
        btnFinal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                eventoAdicionaMap();
                if(vc.VerificasCamposVazios(map) != "N") {
                    Toast.makeText(TelaCadastro.this, vc.VerificasCamposVazios(map) + " está vazio!", Toast.LENGTH_SHORT).show();
                } else if (!vc.SenhaForte(etSenha.getText().toString())){
                    tvMensagem.setVisibility(View.VISIBLE);
                }
                else{
                    Intent it = new Intent(TelaCadastro.this, TelaLogin.class);
                    startActivity(it);
                    finish();
                    InsereUsuario();
                    //InsereBanco();
                }
            }
        });

    }

    private void eventoAdicionaMap(){
       map.put("Nome",etNome.getText().toString());
       map.put("Email",etEmail.getText().toString());
       map.put("Login",etSenha.getText().toString());
       map.put("Senha",etSenha.getText().toString());


    }

    private void init(){
        btnFinal = findViewById(R.id.telacadastro_btnfinal);
        etNome = findViewById(R.id.telacadastro_etnome);
        etEmail = findViewById(R.id.telacadastro_etemail);
        etSenha = findViewById(R.id.telacadastro_etsenha);
        etLogin = findViewById(R.id.telacadastro_etlogin);
        tvMensagem = findViewById(R.id.telacadastro_tvmensagem);
        tvMensagem.setVisibility(View.GONE);
    };

    private void  InsereBanco(){
        BancoController crud = new BancoController(getBaseContext());

        String resultado;

        String nome  = etNome.getText().toString();
        String email = etEmail.getText().toString();
        String login = etLogin.getText().toString();
        String senha = etSenha.getText().toString();

        resultado = crud.insereUsuario(nome,email,login,senha);

        Toast.makeText(getApplicationContext(),resultado,Toast.LENGTH_LONG).show();
    }

    private void InsereUsuario(){

        Usuario usu = new Usuario();
        usuarioDAO udao = new usuarioDAO(getBaseContext());

        usu.setNOME(etNome.getText().toString());
        usu.setEMAIL(etEmail.getText().toString());
        usu.setLOGIN(etLogin.getText().toString());
        usu.setSENHA(etSenha.getText().toString());

       boolean inserted = udao.insertValues(usu);

   }

}