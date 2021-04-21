package com.pdm.trainyourself;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class EjerciciosAdapter extends ArrayAdapter<Ejercicio> {

    /**
     * Esta clase es el adaptador de Ejercicios, que se encarga de generar (cuando se solicite)
     * el layout personalizado para cada uno de los elementos de la lista de Ejercicios objects
     */

    private ArrayList<Ejercicio> mEjercicios;
    private Context mContext;

    public EjerciciosAdapter(@NonNull Context context, int resource, @NonNull ArrayList<Ejercicio> objects) {
        super(context, resource, objects);

        this.mEjercicios = objects;
        this.mContext = context;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        if(convertView == null)
            convertView = LayoutInflater.from(mContext).inflate(R.layout.ejercicios_row, parent, false);

        Ejercicio e = mEjercicios.get(position);



        TextView tituloEjercicio = convertView.findViewById(R.id.tituloEjercicio);
        tituloEjercicio.setText(e.getNombre());


        TextView textoNumRep = convertView.findViewById(R.id.textoNumRep);
        textoNumRep.setText("Series: " + e.getNumRepeticiones() + " repeticiones");


        TextView textoDescripcion = convertView.findViewById(R.id.textoDescripcion);
        textoDescripcion.setText(e.getDescripcion());

        TextView textoIntensidadLista = convertView.findViewById(R.id.textoIntensidadLista);

        return convertView;

    }



}
