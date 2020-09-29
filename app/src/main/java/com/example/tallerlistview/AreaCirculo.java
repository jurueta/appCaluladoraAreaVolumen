package com.example.tallerlistview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.util.HashMap;

public class AreaCirculo extends AppCompatActivity {
    private EditText radio;
    private TextView resultado;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_area_circulo);
        radio = findViewById(R.id.txt_num_radio_cir);
        resultado = findViewById(R.id.lbl_resultado_cir);
    }

    public void calcular(View v){
        if (validar()) {
            int r = Integer.parseInt(radio.getText().toString());
            double res =  (Math.PI * Math.pow(r, 2));

            HashMap<String, Integer> dato = new HashMap<>();
            dato.put("Radio", r);

            Operacion op = new Operacion("Calculo Area", "Circulo", dato, ""+res);
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