package com.pdm.trainyourself;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class ListaEjerciciosAdapter extends ArrayAdapter<ListaEjercicios> {

    /**
     * Esta clase es el adaptador de ListaEjercicios, que se encarga de generar (cuando se solicite)
     * el layout personalizado para cada uno de los elementos de la lista de ListaEjercicios objects.
     * Hace que en el layout se muestre información acerca de cada una de las ListaEjercicios.
     * En este adapter también se genera un click listener para cada una de las views de ListaEjercicios,
     * para que te redirija a su propio layout donde muestra sus ejercicios.
     */

    private ArrayList<ListaEjercicios> mListaEjercicios;
    private Context mContext;


    public ListaEjerciciosAdapter(@NonNull Context context, int resource, @NonNull ArrayList<ListaEjercicios> objects) {
        super(context, resource, objects);
        this.mListaEjercicios = objects;
        this.mContext = context;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        if(convertView == null)
            convertView = LayoutInflater.from(mContext).inflate(R.layout.lista_ejercicios_row, parent, false);

        ListaEjercicios l = mListaEjercicios.get(position);

        int diaCorrespondiente = position + 1;


        TextView tituloListaEjercicio = convertView.findViewById(R.id.tituloListaEjercicio);
        tituloListaEjercicio.setText("Día " + diaCorrespondiente);


        TextView textoNumEjerLista = convertView.findViewById(R.id.textoNumEjerciciosLista);
        textoNumEjerLista.setText(l.getNumEjercicios() + " ejercicios");


        TextView textoTipoLista = convertView.findViewById(R.id.textoTipoLista);
        switch(l.getTipo()){
            case CARDIO:
                textoTipoLista.setText("Día de cardio");
                break;
            case MUSCULO:
                textoTipoLista.setText("Día de ganar músculo");
                break;
            case MIXTA:
                textoTipoLista.setText("Día mixto");
                break;

        }

        TextView textoIntensidadLista = convertView.findViewById(R.id.textoIntensidadLista);
        if(l.getIntensidadMedia() <= 1.0)
                textoIntensidadLista.setText("Intensidad suave");
        else if(l.getIntensidadMedia() <= 2.0)
                textoIntensidadLista.setText("Intensidad media");
        else if(l.getIntensidadMedia() <= 3.0)
                textoIntensidadLista.setText("Intensida alta");

        convertView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mContext, MostrarEjercicios.class);
                intent.putExtra("idLista", l.getId());
                intent.putExtra("titulo", "Día " + diaCorrespondiente);

                mContext.startActivity(intent);
            }
        });



        return convertView;

    }


    public void actualizarListaEjercicios (ArrayList<ListaEjercicios> l){
        this.mListaEjercicios = l;
    }
}
