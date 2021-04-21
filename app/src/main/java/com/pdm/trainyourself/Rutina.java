package com.pdm.trainyourself;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;

public class Rutina{

    /**
     * La clase Rutina es la representación lógica en el código de una Rutina de ejercicio.
     * Consta de un nombre, un número de días, una lista de ListaEjercicios donde se incluyen
     * los ejercicios (lo equivalente a los distintos días de la rutina), la intensidad de la
     * rutina y el tipo de rutina que es (cardio, músculo, mixta)
     *
     */
    private int id;
    private String nombre;
    private int numDias;
    private ArrayList<ListaEjercicios> misEjerciciosRutina;
    private int intensidadRutina;
    private tipoEjercicio tipoRutina;

    public Rutina(int id, String nombre, int numDias, ArrayList<ListaEjercicios> totalEjercicios, int intensidadRutina, tipoEjercicio tipoRutina) {
        this.id = id;
        this.nombre = nombre;
        this.numDias = numDias;
        this.intensidadRutina = intensidadRutina;
        this.tipoRutina = tipoRutina;
        this.misEjerciciosRutina = totalEjercicios;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public int getNumDias() {
        return numDias;
    }

    public ArrayList<ListaEjercicios> getMisEjerciciosRutina() {
        return misEjerciciosRutina;
    }

    public int getIntensidadRutina() {
        return intensidadRutina;
    }

    public tipoEjercicio getTipoRutina() {
        return tipoRutina;
    }

    @Override
    public String toString() {
        return "Rutina{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", numDias=" + numDias +
                ", misEjerciciosRutina=" + misEjerciciosRutina +
                ", intensidadRutina=" + intensidadRutina +
                ", tipoRutina=" + tipoRutina +
                '}';
    }
}
