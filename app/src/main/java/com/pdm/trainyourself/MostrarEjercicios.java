package com.pdm.trainyourself;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;

public class MostrarEjercicios extends AppCompatActivity {

    /**
     * Esta Actividad se encarga de manejar el layout que muestra los Ejercicios.
     */
    BaseDatosHelper bd;

    ListaEjercicios l;
    // Elementos del layout

    TextView tituloLista;
    ListView listaMostrarEjercicios;
    EjerciciosAdapter adaptadorEjercicios;

    Bundle extras;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mostrar_ejercicios);

        bd = new BaseDatosHelper(MostrarEjercicios.this);
        extras = getIntent().getExtras();

        l = bd.obtenerLista(extras.getInt("idLista"));

        tituloLista = findViewById(R.id.tituloLista);
        tituloLista.setText(extras.getString("titulo"));

        listaMostrarEjercicios = findViewById(R.id.listaMostrarEjercicios);
        adaptadorEjercicios = new EjerciciosAdapter(MostrarEjercicios.this, R.layout.ejercicios_row, l.getListaEjercicios());
        listaMostrarEjercicios.setAdapter(adaptadorEjercicios);

    }

}