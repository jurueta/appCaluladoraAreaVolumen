package com.example.tallerlistview;

import java.util.HashMap;

public class Operacion {
    private String tipoOperacion;
    private String figuraGeometrica;
    private HashMap<String, Integer> datos;
    private String resultado;

    public Operacion(String tipoOperacion, String figuraGeometrica, HashMap<String, Integer> datos, String resultado) {
        this.tipoOperacion = tipoOperacion;
        this.figuraGeometrica = figuraGeometrica;
        this.datos = datos;
        this.resultado = resultado;
    }

    public String getTipoOperacion() {
        return tipoOperacion;
    }

    public void setTipoOperacion(String tipoOperacion) {
        this.tipoOperacion = tipoOperacion;
    }

    public String getFiguraGeometrica() {
        return figuraGeometrica;
    }

    public void setFiguraGeometrica(String figuraGeometrica) {
        this.figuraGeometrica = figuraGeometrica;
    }

    public HashMap<String, Integer> getDatos() {
        return datos;
    }

    public void setDatos(HashMap<String, Integer> datos) {
        this.datos = datos;
    }

    public String getResultado() {
        return resultado;
    }

    public void setResultado(String resultado) {
        this.resultado = resultado;
    }

    public void guardar(){
        Datos.almacenarOperacion(this);
    }
}
