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

import java.text.SimpleDateFormat;
import java.util.Date;

public class MainActivity extends AppCompatActivity {


    private	ImageView img_logo;
    private TextView tv_car;
    private Spinner sp_car;
    private TextView tv_fuel;
    private SeekBar sb_fuel;
    private TextView tv_km_start;
    private EditText et_km_start;
    private TextView tv_title_dt_start;
    private TextView tv_text_dt_start;
    private TextView tv_km_end;
    private EditText et_km_end;
    private TextView tv_title_dt_end;
    private TextView tv_text_dt_end;
    private Button btnIniciar;
    private Button btnHistorico;
    private boolean btnAtivo;
    private Date dtAtual;
    private SimpleDateFormat formataData;
    private ArrayAdapter<CharSequence> listCar;

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

                        if (btnAtivo == true){
                            if(et_km_start.getText().toString().isEmpty()){
                                Toast.makeText(MainActivity.this,"Preencha KM Inicio!", Toast.LENGTH_SHORT).show();
                            }else {
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
                                btnAtivo = false;
                            }

                        } else {
                            if (et_km_end.getText().toString().isEmpty()) {
                                Toast.makeText(MainActivity.this, "Preencha KM Final!", Toast.LENGTH_SHORT).show();
                            } else if(Integer.parseInt(et_km_end.getText().toString()) <  Integer.parseInt(et_km_start.getText().toString())) {
                                Toast.makeText(MainActivity.this, "KM final menor que KM inicial!", Toast.LENGTH_SHORT).show();
                            }else {
                                dtAtual = new Date();
                                et_km_start.setEnabled(true);
                                et_km_end.setEnabled(false);
                                btnIniciar.setBackgroundColor(getResources().getColor(R.color.green));
                                btnIniciar.setText("Iniciar");
                                tv_text_dt_end.setText(formataData.format(dtAtual));
                                btnAtivo = true;
                                init();
                                insertSingleton();


                            }
                        }

            }
        });
    }

    private void eventoBtnHistorico() {
        btnHistorico.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
            Intent it = new Intent(MainActivity.this, HistoricoViagens.class);
            startActivity(it);
        }
    });
    }

    private void insertSingleton(){
        // historico = sp_car.get(Integer.valueOf(sp_car.getSelectedItemPosition()));
        // historico = sp_car.getSelectedItem();
        Singleton.getInstance().addViagem("Placa: "+  sp_car.getSelectedItem() +
                 "Inicio:"  + "Fim: " +  formataData.format(dtAtual) );

    }


    private void init() {
        img_logo = findViewById(R.id.img_logo);
        tv_car = findViewById(R.id.tv_car);
        sp_car = findViewById(R.id.sp_car);
        tv_fuel = findViewById(R.id.tv_fuel);
        sb_fuel = findViewById(R.id.sb_fuel);
        tv_km_start = findViewById(R.id.tv_km_start);
        et_km_start = findViewById(R.id.et_km_start);
        tv_title_dt_start = findViewById(R.id.tv_title_dt_start);
        tv_text_dt_start = findViewById(R.id.tv_text_dt_start);
        tv_km_end = findViewById(R.id.tv_km_end);
        et_km_end = findViewById(R.id.et_km_end);
        tv_title_dt_end = findViewById(R.id.tv_title_dt_end);
        tv_text_dt_end = findViewById(R.id.tv_text_dt_end);
        btnIniciar = findViewById(R.id.btnIniciar);
        btnHistorico = findViewById(R.id.btn_historico);
        dtAtual = new Date();
        formataData = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
        et_km_end.setEnabled(false);
        et_km_end.setBackgroundColor(getResources().getColor(R.color.white));
        tv_title_dt_start.setVisibility(View.INVISIBLE);
        tv_text_dt_start.setVisibility(View.INVISIBLE);
        tv_km_end.setVisibility(View.INVISIBLE);
        et_km_end.setVisibility(View.INVISIBLE);
        tv_text_dt_end.setVisibility(View.GONE);
        tv_title_dt_end.setVisibility(View.GONE);
        et_km_start.setText("");
        tv_text_dt_start.setText("");
        et_km_end.setText("");
        btnAtivo = true;
        btnHistorico.setVisibility(View.VISIBLE);
    }





}