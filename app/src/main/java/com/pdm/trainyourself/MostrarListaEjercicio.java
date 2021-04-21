package com.pdm.trainyourself;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class MostrarListaEjercicio extends AppCompatActivity {

    /**
     * Esta Actividad se encarga de manejar el layout que muestra las ListaEjercicios.
     */
    BaseDatosHelper bd;

    Rutina r;
        // Elementos del layout

    TextView tituloRutina;
    ListView listaMostrarListaEjercicios;
    ImageButton botonAumentarIntensidad, botonDisminuirIntensidad, botonEliminarRutina;
    ListaEjerciciosAdapter adaptadorListaEj;

    Bundle extras;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mostrar_lista_ejercicio);



            bd = new BaseDatosHelper(MostrarListaEjercicio.this);
            extras = getIntent().getExtras();

            r = bd.obtenerRutina(extras.getInt("idRutina"));

            tituloRutina = findViewById(R.id.tituloRutina);
            tituloRutina.setText(r.getNombre());

            listaMostrarListaEjercicios = findViewById(R.id.listaMostrarListaEjercicios);
            adaptadorListaEj = new ListaEjerciciosAdapter(MostrarListaEjercicio.this, R.layout.lista_ejercicios_row, r.getMisEjerciciosRutina());
            listaMostrarListaEjercicios.setAdapter(adaptadorListaEj);


            botonAumentarIntensidad = findViewById(R.id.botonAumentarIntensidad);
            botonAumentarIntensidad.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(r.getIntensidadRutina()<3.0){
                        bd.cambiarIntensidadRutina(r.getId(), (float)(r.getIntensidadRutina()+1.0));
                        refrescarLista();
                    }
                    else
                        Toast.makeText(MostrarListaEjercicio.this, "No se puede aumentar más", Toast.LENGTH_SHORT).show();
                }
            });


            botonDisminuirIntensidad = findViewById(R.id.botonDisminuirIntensidad);
            botonDisminuirIntensidad.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(r.getIntensidadRutina()>1.0){
                        bd.cambiarIntensidadRutina(r.getId(), (float)(r.getIntensidadRutina()-1.0));
                        refrescarLista();
                    }
                    else
                        Toast.makeText(MostrarListaEjercicio.this, "No se puede disminuir más", Toast.LENGTH_SHORT).show();
                }
            });

            botonEliminarRutina = findViewById(R.id.botonEliminarRutina);
            botonEliminarRutina.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    boolean exito = bd.borrarRutina(r.getId());
                    if(exito)
                        Toast.makeText(MostrarListaEjercicio.this, "Borrado con éxito", Toast.LENGTH_SHORT).show();
                    else
                        Toast.makeText(MostrarListaEjercicio.this, "Error al borrar", Toast.LENGTH_SHORT).show();
                    finish();
                }
            });

        }


    public void refrescarLista(){
        r = bd.obtenerRutina(extras.getInt("idRutina"));
        adaptadorListaEj.actualizarListaEjercicios(r.getMisEjerciciosRutina());
        if (adaptadorListaEj != null) {
            adaptadorListaEj.notifyDataSetChanged();
        }
    }

}