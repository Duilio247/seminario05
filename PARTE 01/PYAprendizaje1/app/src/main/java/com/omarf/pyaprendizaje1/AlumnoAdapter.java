package com.omarf.pyaprendizaje1;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.omarf.pyaprendizaje1.Alumno;

import java.util.ArrayList;

public class AlumnoAdapter extends ArrayAdapter<Alumno> {
    private Context context;
    private ArrayList<Alumno> alumnos;

    public AlumnoAdapter(Context context, ArrayList<Alumno> alumnos) {
        super(context, 0, alumnos);
        this.context = context;
        this.alumnos = alumnos;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View listItem = convertView;
        if (listItem == null) {
            listItem = LayoutInflater.from(context).inflate(R.layout.item_alumno, parent, false);
        }

        Alumno alumno = alumnos.get(position);

        TextView tvNombre = listItem.findViewById(R.id.tv_nombre);
        TextView tvEstado = listItem.findViewById(R.id.tv_estado);
        TextView tvEdad = listItem.findViewById(R.id.tv_edad);
        TextView tvId = listItem.findViewById(R.id.tv_id);
        TextView tvHoraEntrada = listItem.findViewById(R.id.tv_hora_entrada);
        TextView tvHoraSalida = listItem.findViewById(R.id.tv_hora_salida);

        // Set data to views
        tvNombre.setText(alumno.getNombre());
        tvEdad.setText("Edad: " + alumno.getEdad());
        tvId.setText("ID: " + alumno.getId());
        tvHoraEntrada.setText("Entrada: " + alumno.getHoraEntrada());

        // Display hora de salida if available, otherwise hide it
        if (alumno.getHoraSalida() != null) {
            tvHoraSalida.setText("Salida: " + alumno.getHoraSalida());
            tvHoraSalida.setVisibility(View.VISIBLE);
            tvEstado.setText("FINALIZADO");
            tvEstado.setTextColor(Color.GRAY);
        } else {
            tvHoraSalida.setVisibility(View.GONE);
            tvEstado.setText("ACTIVO");
            tvEstado.setTextColor(Color.GREEN);
        }

        return listItem;
    }
}
