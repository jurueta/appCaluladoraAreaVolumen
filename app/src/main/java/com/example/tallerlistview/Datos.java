package com.example.tallerlistview;

import java.util.ArrayList;

public class Datos {
    private static ArrayList<Operacion> bdOperacion = new ArrayList();

    public static void almacenarOperacion(Operacion p){
        bdOperacion.add(p);
    }

    public static ArrayList<Operacion> getOperacion(){
        return bdOperacion;
    }
}
