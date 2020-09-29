package com.example.tallerlistview;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class CalculoVolumen extends AppCompatActivity {
    private ListView listaPaginas;
    private ArrayAdapter<String> adaptador;
    private String[] opciones;
    private Intent cambio;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculo_volumen);
        listaPaginas = findViewById(R.id.lstvw_figuras_volumen);
        opciones = getResources().getStringArray(R.array.opciones_volumen);
        adaptador = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,opciones);
        listaPaginas.setAdapter(adaptador);

        listaPaginas.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                switch (i){
                    case 0:
                        cambio = new Intent(CalculoVolumen.this, VolumenEsfera.class);
                        startActivity(cambio);
                        break;
                    case 1:
                        cambio = new Intent(CalculoVolumen.this, VolumenCilindro.class);
                        startActivity(cambio);
                        break;
                    case 2:
                        cambio = new Intent(CalculoVolumen.this, VolumenCono.class);
                        startActivity(cambio);
                        break;
                    case 3:
                        cambio = new Intent(CalculoVolumen.this, VolumenCubo.class);
                        startActivity(cambio);
                        break;
                }
            }
        });
    }

}