package com.example.tallerlistview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.util.HashMap;

public class VolumenCubo extends AppCompatActivity {
    private EditText ancho, numeroAltura, largo;
    private TextView resultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_volumen_cubo);
        ancho = findViewById(R.id.txt_num_ancho_cubo);
        numeroAltura = findViewById(R.id.txt_num_altura_cubo);
        largo = findViewById(R.id.txt_num_largo_cubo);
        resultado = findViewById(R.id.lbl_resultado_cubo);
    }
    public void calcular(View v){
        if (validar()) {
            int r = Integer.parseInt(ancho.getText().toString());
            int altura = Integer.parseInt(numeroAltura.getText().toString());
            int l = Integer.parseInt(largo.getText().toString());
            int res =  r * altura * l;

            HashMap<String, Integer> dato = new HashMap<>();
            dato.put(getString(R.string.txt_ancho), r);
            dato.put(getString(R.string.txt_altura), altura);
            dato.put(getString(R.string.txt_largo), l);

            Operacion op = new Operacion(getString(R.string.txt_calculo_volumen), getString(R.string.txt_opc_volumen_4), dato, ""+res);
            op.guardar();

            resultado.setText(getString(R.string.txt_lbl_resultado) + " " + res);
        }
    }

    public boolean validar(){
        if (ancho.getText().toString().isEmpty()){
            ancho.setError(getString(R.string.txt_err_falta));
            ancho.requestFocus();
            return false;
        }

        if (numeroAltura.getText().toString().isEmpty()){
            numeroAltura.setError(getString(R.string.txt_err_falta));
            numeroAltura.requestFocus();
            return false;
        }

        if (largo.getText().toString().isEmpty()){
            largo.setError(getString(R.string.txt_err_falta));
            largo.requestFocus();
            return false;
        }

        return true;
    }

    public void limpiar(View v){
        ancho.setText("");
        ancho.requestFocus();
        numeroAltura.setText("");
        numeroAltura.requestFocus();
        largo.setText("");
        largo.requestFocus();
        resultado.setText("");
    }
}