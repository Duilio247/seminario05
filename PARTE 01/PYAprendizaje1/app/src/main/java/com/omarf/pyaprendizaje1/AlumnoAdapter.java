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

import java.util.ArrayList;

// Adaptador personalizado para mostrar objetos de tipo Alumno usando el layout item_alumno.xml
public class AlumnoAdapter extends ArrayAdapter<Alumno> {
    private Context context;                  // Contexto de la aplicación
    private ArrayList<Alumno> alumnos;        // Lista de alumnos a mostrar

    // Constructor del adaptador
    public AlumnoAdapter(Context context, ArrayList<Alumno> alumnos) {
        super(context, 0, alumnos);
        this.context = context;
        this.alumnos = alumnos;
    }

    // Método que define cómo se renderiza cada elemento (item) en la ListView
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View listItem = convertView;

        // Si no se ha creado aún la vista, inflarla desde el layout item_alumno.xml
        if (listItem == null) {
            listItem = LayoutInflater.from(context).inflate(R.layout.item_alumno, parent, false);
        }

        // Obtener el alumno actual basado en la posición
        Alumno alumno = alumnos.get(position);

        // Obtener referencias a los elementos de la interfaz (TextViews)
        TextView tvNombre = listItem.findViewById(R.id.tv_nombre);
        TextView tvEstado = listItem.findViewById(R.id.tv_estado);
        TextView tvEdad = listItem.findViewById(R.id.tv_edad);
        TextView tvId = listItem.findViewById(R.id.tv_id);
        TextView tvHoraEntrada = listItem.findViewById(R.id.tv_hora_entrada);
        TextView tvHoraSalida = listItem.findViewById(R.id.tv_hora_salida);

        // Asignar los datos del alumno a las vistas correspondientes
        tvNombre.setText(alumno.getNombre());
        tvEdad.setText("Edad: " + alumno.getEdad());
        tvId.setText("ID: " + alumno.getId());
        tvHoraEntrada.setText("Entrada: " + alumno.getHoraEntrada());

        // Mostrar la hora de salida si existe, de lo contrario ocultarla
        if (alumno.getHoraSalida() != null) {
            tvHoraSalida.setText("Salida: " + alumno.getHoraSalida());
            tvHoraSalida.setVisibility(View.VISIBLE);           // Mostrar salida
            tvEstado.setText("FINALIZADO");                     // Cambiar estado
            tvEstado.setTextColor(Color.GRAY);                  // Color gris para finalizado
        } else {
            tvHoraSalida.setVisibility(View.GONE);              // Ocultar salida
            tvEstado.setText("ACTIVO");                         // Cambiar estado
            tvEstado.setTextColor(Color.GREEN);                 // Color verde para activo
        }

        return listItem; // Devolver la vista del item ya personalizada
    }
}
