package com.pdm.trainyourself;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;

import static java.lang.Math.abs;

public class Ejercicio{

    /**
     * La clase Ejercicio es la representación lógica de la información de un ejercicio
     * Sus atributos son un identificador, un nombre, una descripción, el tipo de ejercicio
     * que es (mirar la clase TipoEjercicio), y el número máximo y mínimo de repeticiones
     * que puede tener este ejercicio
     *
     * Tiene un atributo adicional, llamado numRepeticiones, que indica el número de repeticiones
     * según la intensidad de la lista a la que pertenece. Es un valor que calcula en el constructor.
     */
    private int identificador;
    private String nombre;
    private String descripcion;
    private tipoEjercicio tipo;
    private int numMaxRepeticiones;
    private int numMinRepeticiones;

    private int numRepeticiones;


    //  Constructor con parámetros
    public Ejercicio(int id, String nombre, String descripcion, float nivelEjercicio, tipoEjercicio tipo, int numMaxRepeticiones, int numMinRepeticiones) {
        this.identificador = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.tipo = tipo;
        this.numMaxRepeticiones = numMaxRepeticiones;
        this.numMinRepeticiones = numMinRepeticiones;

        this.numRepeticiones = obtenerNivelOptimo(nivelEjercicio);
    }

    // Constructor Copia
    public Ejercicio(Ejercicio e, float nivelEjercicio) {
        this.identificador = e.getIdentificador() ;
        this.nombre = e.getNombre();
        this.descripcion = e.getDescripcion();
        this.tipo = e.getTipo();
        this.numMaxRepeticiones = e.getNumMaxRepeticiones();
        this.numMinRepeticiones = e.getNumMinRepeticiones();
        this.numRepeticiones = obtenerNivelOptimo(nivelEjercicio);

    }


    public int getIdentificador() {
        return identificador;
    }



    public String getNombre() {
        return nombre;
    }


    public String getDescripcion() {
        return descripcion;
    }


    public int getNumRepeticiones() {
        return numRepeticiones;
    }


    public int getNumMaxRepeticiones() {
        return numMaxRepeticiones;
    }

    public int getNumMinRepeticiones() {
        return numMinRepeticiones;
    }



    public void setNumRepeticiones(int n) {
        this.numRepeticiones = n;
    }

    public tipoEjercicio getTipo() {
        return tipo;
    }

    /**
     * Este método sirve para calcular el nivel deseado de repeticiones
     * según una intensidad proporcionada
     * @param i la intensidad
     * @return el numero de repeticiones
     */
    public int obtenerNivelOptimo(float i){
        return (int) i * (numMaxRepeticiones-numMinRepeticiones) / 2 + numMinRepeticiones;
    }

}
