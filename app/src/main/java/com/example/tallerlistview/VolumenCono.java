package com.example.tallerlistview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.util.HashMap;

public class VolumenCono extends AppCompatActivity {
    private EditText radio, numeroAltura;
    private TextView resultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_volumen_cono);
        radio = findViewById(R.id.txt_num_radio_cono);
        numeroAltura = findViewById(R.id.txt_num_altura_cono);
        resultado = findViewById(R.id.lbl_resultado_cono);
    }
    public void calcular(View v){
        if (validar()) {
            int r = Integer.parseInt(radio.getText().toString());
            int altura = Integer.parseInt(numeroAltura.getText().toString());
            double res =  (Math.PI * Math.pow(r, 2) * altura)/3;

            HashMap<String, Integer> dato = new HashMap<>();
            dato.put(getString(R.string.txt_radio), r);
            dato.put(getString(R.string.txt_altura), altura);

            Operacion op = new Operacion(getString(R.string.txt_calculo_volumen), getString(R.string.txt_opc_volumen_3), dato, ""+res);
            op.guardar();

            resultado.setText(getString(R.string.txt_lbl_resultado) + " " + res);
        }
    }

    public boolean validar(){
        if (radio.getText().toString().isEmpty()){
            radio.setError(getString(R.string.txt_err_falta));
            radio.requestFocus();
            return false;
        }

        if (numeroAltura.getText().toString().isEmpty()){
            numeroAltura.setError(getString(R.string.txt_err_falta));
            numeroAltura.requestFocus();
            return false;
        }

        return true;
    }

    public void limpiar(View v){
        radio.setText("");
        radio.requestFocus();
        numeroAltura.setText("");
        numeroAltura.requestFocus();
        resultado.setText("");
    }
}