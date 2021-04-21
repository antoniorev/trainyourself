package com.pdm.trainyourself;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;

public class ListaEjercicios{

    /**
     * La clase ListaEjercicios guarda información sobre un arrayList de Ejercicios y
     * sus propiedades, como cuantos son, su intensidad o su tipo. La idea es que
     * representen lo que sería un día de una rutina. También tienen el atributo id como
     * identificador.
     */

    private int id;
    private int numEjercicios;
    private ArrayList<Ejercicio> listaEjercicios;
    private float intensidadMedia;
    private tipoEjercicio tipo;

    //  Constructor por parámetros
    public ListaEjercicios(int id, int numEjercicios, ArrayList<Ejercicio> listaEjercicios, float intensidadMedia, tipoEjercicio tipo) {
        this.id = id;
        this.numEjercicios = numEjercicios;
        this.intensidadMedia = intensidadMedia;
        this.listaEjercicios = listaEjercicios;
        this.tipo = tipo;


    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNumEjercicios() {
        return numEjercicios;
    }

    public ArrayList<Ejercicio> getListaEjercicios() {
        return listaEjercicios;
    }

    public float getIntensidadMedia() {
        return intensidadMedia;
    }

    public tipoEjercicio getTipo() {
        return tipo;
    }

    @Override
    public String toString() {
        return "ListaEjercicios{" +
                "id=" + id +
                ", numEjercicios=" + numEjercicios +
                ", listaEjercicios=" + listaEjercicios +
                ", intensidadMedia=" + intensidadMedia +
                ", tipo=" + tipo +
                '}';
    }
}
