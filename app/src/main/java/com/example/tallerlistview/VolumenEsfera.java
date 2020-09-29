package com.example.tallerlistview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.util.HashMap;

public class VolumenEsfera extends AppCompatActivity {
    private EditText radio;
    private TextView resultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_volumen_esfera);
        radio = findViewById(R.id.txt_num_radio_esfera);
        resultado = findViewById(R.id.lbl_resultado_esfera);
    }

    public void calcular(View v){
        if (validar()) {
            int r = Integer.parseInt(radio.getText().toString());
            double res = ((4 * Math.PI * Math.pow(r, 3)) / 3)  ;

            HashMap<String, Integer> dato = new HashMap<>();
            dato.put(getString(R.string.txt_radio), r);

            Operacion op = new Operacion(getString(R.string.txt_calculo_volumen), getString(R.string.txt_opc_volumen_1), dato, ""+res);
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
        return true;
    }

    public void limpiar(View v){
        radio.setText("");
        radio.requestFocus();
        resultado.setText("");
    }
}