package com.example.tallerlistview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.util.HashMap;

public class AreaCuadrado extends AppCompatActivity {
    private EditText numeroLados;
    private TextView resultado;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_area_cuadrado);
        numeroLados = findViewById(R.id.txt_num_lados_cuadrado);
        resultado = findViewById(R.id.lbl_resultado);
    }

    public void calcular(View v){
        if (validar()) {
            int lados = Integer.parseInt(numeroLados.getText().toString());
            int res = lados * lados;

            HashMap<String, Integer> dato = new HashMap<>();
            dato.put("Lados", lados);

            Operacion op = new Operacion("Calculo Area", "Cuadrado", dato, ""+res);
            op.guardar();

            resultado.setText(getString(R.string.txt_lbl_resultado) + " " + res);
        }
    }

    public boolean validar(){
        if (numeroLados.getText().toString().isEmpty()){
            numeroLados.setError(getString(R.string.txt_err_falta));
            numeroLados.requestFocus();
            return false;
        }
        return true;
    }

    public void limpiar(View v){
        numeroLados.setText("");
        numeroLados.requestFocus();
        resultado.setText("");
    }
}