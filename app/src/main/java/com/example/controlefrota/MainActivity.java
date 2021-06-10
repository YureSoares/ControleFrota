package com.example.controlefrota;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.controlefrota.control.VerificaCampos;
import com.example.controlefrota.model.Viagem;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {


    private Spinner sp_car;
    private Spinner sp_fuel;
    //private SeekBar sb_fuel;
    private TextView tv_km_start;
    private EditText et_km_start;
    private TextView tv_title_dt_start;
    private TextView tv_text_dt_start;
    private TextView tv_km_end;
    private EditText et_km_end;
    private Button btnIniciar;
    private Button btnHistorico;
    private boolean btnAtivo;
    private Date dtAtual;
    private SimpleDateFormat formataData;
    public Viagem viagem = new Viagem();
    private Map<String,String> map = new HashMap<String, String>();
    VerificaCampos vc = new VerificaCampos();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();

        eventoBtnIniciar();
        eventoBtnHistorico();

    }

    private void eventoBtnIniciar() {
        btnIniciar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // insertSingleton();
                if (btnAtivo == true) {
                    eventoAdicionaMap(et_km_start.getText().toString(), "KM Inicio");
                    if(vc.VerificasCamposVazios(map) != "N") {
                        Toast.makeText(MainActivity.this, vc.VerificasCamposVazios(map) + " está vazio!", Toast.LENGTH_SHORT).show();
                    } else {
                        eventoIniciarViagem();
                        btnAtivo = false;
                    }

                } else {
                    eventoAdicionaMap(et_km_end.getText().toString(),"KM Fim");
                    if(vc.VerificasCamposVazios(map) != "N") {
                        Toast.makeText(MainActivity.this, vc.VerificasCamposVazios(map) + " está vazio!", Toast.LENGTH_SHORT).show();
                    } else if (Integer.parseInt(et_km_end.getText().toString()) < Integer.parseInt(et_km_start.getText().toString())) {
                        Toast.makeText(MainActivity.this, "KM final menor que KM inicial!", Toast.LENGTH_SHORT).show();
                    } else {
                        insertSingleton();
                        eventoLimparViagem();
                        btnAtivo = true;
                        Toast.makeText(MainActivity.this, "Viagem salva no historico!", Toast.LENGTH_SHORT).show();
                    }
                }

            }
        });
    }

    private void eventoLimparViagem() {
        et_km_start.setEnabled(true);
        et_km_start.getText().clear();
        tv_title_dt_start.setVisibility(View.GONE);
        tv_text_dt_start.setVisibility(View.GONE);
        tv_text_dt_start.setText("");
        tv_km_end.setVisibility(View.GONE);
        et_km_end.getText().clear();
        et_km_end.setVisibility(View.GONE);
        btnIniciar.setBackgroundColor(getResources().getColor(R.color.orange));
        btnIniciar.setText("Iniciar");

    }

    private void eventoIniciarViagem(){
        et_km_start.setEnabled(false);
        et_km_end.setEnabled(true);
        btnIniciar.setBackgroundColor(getResources().getColor(R.color.red));
        btnIniciar.setText("Finalizar");
        tv_text_dt_start.setText(formataData.format(dtAtual));
        et_km_end.setBackgroundColor(getResources().getColor(R.color.light_gray));
        tv_title_dt_start.setVisibility(View.VISIBLE);
        tv_text_dt_start.setVisibility(View.VISIBLE);
        tv_km_end.setVisibility(View.VISIBLE);
        et_km_end.setVisibility(View.VISIBLE);
    }

    private void eventoBtnHistorico() {
        btnHistorico.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent it = new Intent(MainActivity.this, HistoricoViagens.class);
                startActivity(it);
                finish();
            }
        });
    }

    private String DataAtual(){
        dtAtual = new Date();
        formataData = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
        return String.valueOf(formataData.format(dtAtual)) ;
    }

    private void eventoAdicionaMap(String campo, String nome){
        map.put(nome,campo);
    }


    private void insertSingleton() {
        viagem.setPlaca(sp_car.getSelectedItem().toString());
        viagem.setDtInicio(tv_text_dt_start.getText().toString());
        viagem.setDtEnd(DataAtual());
        viagem.setKmInicio(et_km_start.getText().toString());
        viagem.setKmEnd(et_km_end.getText().toString());
        viagem.setCombustivel(sp_fuel.getSelectedItem().toString());

        Singleton.getInstance().addViagem(viagem);

    }


    private void init() {
        sp_car = findViewById(R.id.sp_car);
        //sb_fuel = findViewById(R.id.sb_fuel);
        sp_fuel = findViewById(R.id.sp_fuel);
        tv_km_start = findViewById(R.id.tv_km_start);
        et_km_start = findViewById(R.id.et_km_start);
        tv_title_dt_start = findViewById(R.id.tv_title_dt_start);
        tv_text_dt_start = findViewById(R.id.tv_text_dt_start);
        tv_km_end = findViewById(R.id.tv_km_end);
        et_km_end = findViewById(R.id.et_km_end);
        btnIniciar = findViewById(R.id.btnIniciar);
        btnHistorico = findViewById(R.id.btn_historico);
        btnHistorico = findViewById(R.id.btn_historico);
        dtAtual = new Date();
        formataData = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
        tv_title_dt_start.setVisibility(View.GONE);
        tv_text_dt_start.setVisibility(View.GONE);
        tv_km_end.setVisibility(View.GONE);
        et_km_end.setVisibility(View.GONE);
        btnAtivo = true;
    }


}