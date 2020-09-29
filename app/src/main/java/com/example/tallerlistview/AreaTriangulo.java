package com.example.tallerlistview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.util.HashMap;

public class AreaTriangulo extends AppCompatActivity {
    private EditText numeroBase, numeroAltura;
    private TextView resultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_area_triangulo);
        numeroBase = findViewById(R.id.txt_num_base_trg);
        numeroAltura = findViewById(R.id.txt_num_altura_trg);
        resultado = findViewById(R.id.lbl_resultado_trg);
    }

    public void calcular(View v){
        if (validar()) {
            int base = Integer.parseInt(numeroBase.getText().toString());
            int altura = Integer.parseInt(numeroAltura.getText().toString());
            float res = (base * altura)/2;

            HashMap<String, Integer> dato = new HashMap<>();
            dato.put("Base", base);
            dato.put("Altura", altura);

            Operacion op = new Operacion("Calculo Area", "Triangulo", dato, ""+ res);
            op.guardar();

            resultado.setText(getString(R.string.txt_lbl_resultado) + " " + res);
        }
    }

    public boolean validar(){
        if (numeroBase.getText().toString().isEmpty()){
            numeroBase.setError(getString(R.string.txt_err_falta));
            numeroBase.requestFocus();
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
        numeroBase.setText("");
        numeroBase.requestFocus();
        numeroAltura.setText("");
        numeroAltura.requestFocus();
        resultado.setText("");
    }
}