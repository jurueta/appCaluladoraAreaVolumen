package com.example.tallerlistview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import java.util.ArrayList;

public class HistorialCalculos extends AppCompatActivity {
    private TableLayout tablaReg;
    private ArrayList<Operacion> historial;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_historial_calculos);
        tablaReg = findViewById(R.id.tblHistorialCalculo);
        historial = Datos.getOperacion();

        for (int i = 0; i < historial.size(); i++) {
            TableRow fila = new TableRow(this);

            TextView columna1 = new TextView(this);
            TextView columna2 = new TextView(this);
            TextView columna3 = new TextView(this);
            TextView columna4 = new TextView(this);

            String datos = "";
            for (String key: historial.get(i).getDatos().keySet()) {
                datos += key + ": " + historial.get(i).getDatos().get(key) + " \n ";
            }

            columna1.setText("" + (i+1));
            columna2.setText(historial.get(i).getTipoOperacion() + " " + historial.get(i).getFiguraGeometrica());
            columna3.setText(datos);
            columna4.setText(historial.get(i).getResultado());

            fila.addView(columna1);
            fila.addView(columna2);
            fila.addView(columna3);
            fila.addView(columna4);
            tablaReg.addView(fila);
        }


    }
}