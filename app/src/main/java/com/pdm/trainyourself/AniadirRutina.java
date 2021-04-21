package com.pdm.trainyourself;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.chip.Chip;

import java.util.ArrayList;

public class AniadirRutina extends AppCompatActivity {

    /**
     * La actividad AniadirRutina se encarga de mostrar una serie de
     * parámetros a escoger por el usuario y llamar al método aniadirRutina,
     * que se encarga de introducir una nueva Rutina en la base de datos
     */
    // Elementos del layout
    Chip confirmarRutina;
    RadioGroup grupoTipo, grupoIntensidad, grupoDias;
    BaseDatosHelper bd;
    TextView nombreSeleccionado;

    // Valores donde almacenar nueva rutina
    String nombre;
    int dias, intensidad;
    tipoEjercicio tipo;
    Bundle extras;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aniadir_rutina);

        // Creamos un objeto de la clase BaseDatosHelper, encargada de hacer peticiones a la BD
        bd = new BaseDatosHelper(AniadirRutina.this);

        // Asignamos los elementos de layout
        confirmarRutina     = findViewById(R.id.confirmarAniadirRutina);
        grupoTipo           = findViewById(R.id.grupoBotonTipo);
        grupoIntensidad     = findViewById(R.id.grupoBotonIntensidad);
        grupoDias           = findViewById(R.id.grupoBotonDias);
        nombreSeleccionado  = findViewById(R.id.introNombreAniadirRutina);
        extras              = getIntent().getExtras();


        // Se crea un listener para cuando se pulse el botón de confirmar rutina
        confirmarRutina.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View v) {

                // Transforma los datos obtenidos en datos legibles por el metodo anadirRutina
                switch (grupoTipo.indexOfChild(findViewById(grupoTipo.getCheckedRadioButtonId()))){
                    case 0:
                        tipo = tipoEjercicio.CARDIO;
                        break;
                    case 1:
                        tipo = tipoEjercicio.MUSCULO;
                        break;
                    case 2:
                        tipo = tipoEjercicio.MIXTA;
                        break;
                }
                intensidad = grupoIntensidad.indexOfChild(findViewById(grupoIntensidad.getCheckedRadioButtonId()))+1;
                dias = grupoDias.indexOfChild(findViewById(grupoDias.getCheckedRadioButtonId()))+1;
                nombre = nombreSeleccionado.getText().toString();
                if(nombre.isEmpty())
                    nombre = "Rutina personalizada";


                // Aqui añadimos la rutina a la base de datos
                boolean exito = bd.anadirRutina(nombre,dias,intensidad,tipo);

                if(exito)
                    Toast.makeText(AniadirRutina.this, "Rutina anadida", Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(AniadirRutina.this, "No se ha podido añadir", Toast.LENGTH_SHORT).show();

                finish();


            }


        });
    }
}