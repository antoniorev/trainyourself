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

public class listaRutinasAdapter extends ArrayAdapter<Rutina> {

    /**
     * Esta clase es el adaptador de Rutinas, que se encarga de generar en la pantalla principal
     * el layout personalizado para cada uno de los elementos de la lista de Rutinas objects.
     * Hace que en el layout se muestre información acerca de cada una de las rutinas.
     * En este adapter también se genera un click listener para cada una de las views de Rutina,
     * para que te redirija a su propio layout donde muestra sus ListaEjercicios.
     */

    private ArrayList<Rutina> lRutinas;
    private Context mContext;


    public listaRutinasAdapter(@NonNull Context context, int resource, @NonNull ArrayList<Rutina> objects) {
        super(context, resource, objects);
        this.lRutinas = objects;
        this.mContext = context;
    }


    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        if(convertView == null)
            convertView = LayoutInflater.from(mContext).inflate(R.layout.rutina_row, parent, false);

        Rutina r = lRutinas.get(position);

        TextView textoTitulo = convertView.findViewById(R.id.textTitulo);
        textoTitulo.setText(r.getNombre());

        TextView textoTipo = convertView.findViewById(R.id.textTipo);
        switch(r.getTipoRutina()){
            case CARDIO:
                textoTipo.setText("Rutina de cardio");
                break;
            case MUSCULO:
                textoTipo.setText("Rutina para ganar músculo");
                break;
            case MIXTA:
                textoTipo.setText("Rutina mixta");
                break;

        }

        TextView textoIntensidad = convertView.findViewById(R.id.textIntensidad);
        switch(r.getIntensidadRutina()){
            case 1:
                textoIntensidad.setText("Intensidad suave");
                break;
            case 2:
                textoIntensidad.setText("Intensidad media");
                break;
            case 3:
                textoIntensidad.setText("Intensida alta");
                break;

        }

        TextView textoDias = convertView.findViewById(R.id.textDias);
        switch(r.getNumDias()){
            case 1:
                textoDias.setText("1 día");
                break;
            case 2:
                textoDias.setText("2 días");
                break;
            case 3:
                textoDias.setText("3 días");
                break;
            case 4:
                textoDias.setText("4 días");
                break;
            case 5:
                textoDias.setText("5 días");
                break;
        }

        convertView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mContext, MostrarListaEjercicio.class);
                intent.putExtra("idRutina", r.getId());
                mContext.startActivity(intent);
            }
        });

        return convertView;
    }

    @Nullable
    @Override
    public Rutina getItem(int position) {
        return lRutinas.get(position);
    }

    @Override
    public int getCount() {
        return lRutinas.size();
    }

    public void actualizarRutinas(ArrayList<Rutina> r){
        if(r.isEmpty())
            this.lRutinas = new ArrayList<>();
        else
            this.lRutinas = r;
    }
}
