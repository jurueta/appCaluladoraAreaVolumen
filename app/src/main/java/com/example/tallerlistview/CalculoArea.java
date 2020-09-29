package com.example.tallerlistview;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class CalculoArea extends AppCompatActivity {
    private ListView listaPaginas;
    private ArrayAdapter<String> adaptador;
    private String[] opciones;
    private Intent cambio;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculo_area);
        listaPaginas = findViewById(R.id.lstvwFigurasArea);
        opciones = getResources().getStringArray(R.array.opciones_area);
        adaptador = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,opciones);
        listaPaginas.setAdapter(adaptador);

        listaPaginas.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                switch (i){
                    case 0:
                        cambio = new Intent(CalculoArea.this, AreaCuadrado.class);
                        startActivity(cambio);
                        break;
                    case 1:
                        cambio = new Intent(CalculoArea.this, AreaRectangulo.class);
                        startActivity(cambio);
                        break;
                    case 2:
                        cambio = new Intent(CalculoArea.this, AreaTriangulo.class);
                        startActivity(cambio);
                        break;
                    case 3:
                        cambio = new Intent(CalculoArea.this, AreaCirculo.class);
                        startActivity(cambio);
                        break;
                }
            }
        });
    }
}