package com.example.tallerlistview;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ListView listaPaginas;
    private ArrayAdapter<String> adaptador;
    private String[] opciones;
    private Intent cambio;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listaPaginas = findViewById(R.id.listvwPrincipal);
        opciones = getResources().getStringArray(R.array.opciones_principales);
        adaptador = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,opciones);
        listaPaginas.setAdapter(adaptador);

        listaPaginas.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                switch (i){
                    case 0:
                        cambio = new Intent(MainActivity.this, CalculoArea.class);
                        startActivity(cambio);
                        break;
                    case 1:
                        cambio = new Intent(MainActivity.this, CalculoVolumen.class);
                        startActivity(cambio);
                        break;
                    case 2:
                        cambio = new Intent(MainActivity.this, HistorialCalculos.class);
                        startActivity(cambio);
                        break;
                }
            }
        });
    }
}