package com.pdm.trainyourself;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    /**
     * La Main activity muestra la pantalla inicial, donde se muestran todas las Rutinas
     * que hay en la base de datos, además de un botón para añadir una rutina. Se puede
     * pulsar en cada rutina para ver su lista de ListaEjercicios.
     */
    private static final int SECOND_ACTIVITY_REQUEST_CODE = 0;
    public ArrayList<Rutina> misRutinas = new ArrayList<>();
    FloatingActionButton btnAniadir;
    BaseDatosHelper bd;
    ListView listaMostrarRutinas;
    TextView faltanRutinas;
    listaRutinasAdapter adaptadorRutinas;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bd = new BaseDatosHelper(MainActivity.this);

        faltanRutinas = findViewById(R.id.mensajeFaltanRutinas);
        faltanRutinas.setText(R.string.mensaje_faltan_rutinas);

        misRutinas = bd.obtenerRutinas();


        // Para mostrar la lista de las Rutinas
        listaMostrarRutinas = findViewById(R.id.listaMostrarRutinas);
        adaptadorRutinas = new listaRutinasAdapter(MainActivity.this, R.layout.rutina_row,misRutinas);
        listaMostrarRutinas.setAdapter(adaptadorRutinas);

        if(!misRutinas.isEmpty()) {
            faltanRutinas.setVisibility(View.INVISIBLE);

        }

        //Si no hay rutinas que mostrar, nos dice que no hay ninguna
        else{
            faltanRutinas.setVisibility(View.VISIBLE);
        }




        //boton para añadir una nueva rutina, invoca la actividad AniadirRutina
        btnAniadir = findViewById(R.id.botonAniadir);
        btnAniadir.setOnClickListener(new View.OnClickListener() {

            /* Arrancamos la ventana de añadir rutina */

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, AniadirRutina.class);
                startActivity(intent);

            }
        });

    }


    //Cada vez que se añada una nueva rutina, que actualice las rutinas de la Actividad principal
    @Override
    protected void onRestart() {
        super.onRestart();
        refrescarLista();
        if(misRutinas.isEmpty())
            faltanRutinas.setVisibility(View.VISIBLE);

        else
            faltanRutinas.setVisibility(View.INVISIBLE);
    }

    public void refrescarLista(){
        misRutinas = bd.obtenerRutinas();
        adaptadorRutinas.actualizarRutinas(misRutinas);
        if (adaptadorRutinas != null) {
            adaptadorRutinas.notifyDataSetChanged();
        }
    }

}