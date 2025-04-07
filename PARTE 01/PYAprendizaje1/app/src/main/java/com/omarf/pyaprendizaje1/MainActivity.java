package com.omarf.pyaprendizaje1;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Toast;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Button;
import android.widget.ListView;
import android.graphics.Color;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.snackbar.Snackbar;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.omarf.pyaprendizaje1.Alumno;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;
import java.lang.reflect.Type;

public class MainActivity extends AppCompatActivity {
    private EditText editNombre, editEdad, editIdAlumno;
    private Button btnRegistrar, btnConsultar, btnEliminar;
    private ListView listVisitas;
    private ArrayList<Alumno> datosGuardados;
    private ArrayAdapter<String> adapter;
    private ArrayList<String> visitas; // Para mostrar en ListView

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editNombre = findViewById(R.id.edit_nombre);
        editEdad = findViewById(R.id.edit_edad);
        editIdAlumno = findViewById(R.id.edit_id_alumno);
        btnRegistrar = findViewById(R.id.btn_registrar);
        btnConsultar = findViewById(R.id.btn_consultar);
        btnEliminar = findViewById(R.id.btn_eliminar);
        listVisitas = findViewById(R.id.list_visitas);

        datosGuardados = new ArrayList<>();
        visitas = new ArrayList<>();
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, visitas);
        listVisitas.setAdapter(adapter);

        cargarDatos();

        btnRegistrar.setOnClickListener(v -> registrarAlumno());
        btnConsultar.setOnClickListener(v -> actualizarLista());
        btnEliminar.setOnClickListener(v -> eliminarTodosLosRegistros());

        listVisitas.setOnItemClickListener((parent, view, position, id) -> mostrarOpciones(position));
    }

    @Override
    protected void onPause() {
        super.onPause();
        guardarDatos();
    }

    private void registrarAlumno() {
        String nombre = editNombre.getText().toString().trim();
        String edad = editEdad.getText().toString().trim();
        String id = editIdAlumno.getText().toString().trim();

        if (nombre.isEmpty() || edad.isEmpty() || id.isEmpty()) {
            Toast.makeText(this, "Complete todos los campos", Toast.LENGTH_SHORT).show();
            return;
        }

        String horaEntrada = new SimpleDateFormat("dd/MM/yyyy HH:mm", Locale.getDefault()).format(new Date());
        Alumno nuevo = new Alumno(nombre, edad, id, horaEntrada, null);
        datosGuardados.add(nuevo);

        Snackbar.make(findViewById(android.R.id.content), "Alumno registrado", Snackbar.LENGTH_LONG)
                .setAction("Deshacer", v -> {
                    datosGuardados.remove(datosGuardados.size() - 1);
                    actualizarLista();
                })
                .setActionTextColor(Color.YELLOW)
                .show();

        limpiarCampos();
    }

    private void mostrarOpciones(int pos) {
        Alumno alumno = datosGuardados.get(pos);
        String[] opciones = {"Registrar salida", "Eliminar registro"};

        new AlertDialog.Builder(this)
                .setTitle("Opciones para " + alumno.getNombre())
                .setItems(opciones, (dialog, which) -> {
                    if (which == 0) {
                        registrarSalida(pos);
                    } else {
                        eliminarAlumno(pos);
                    }
                })
                .show();
    }

    private void registrarSalida(int pos) {
        Alumno alumno = datosGuardados.get(pos);
        if (alumno.getHoraSalida() == null) {
            String horaSalida = new SimpleDateFormat("dd/MM/yyyy HH:mm", Locale.getDefault()).format(new Date());
            alumno.setHoraSalida(horaSalida);
            Toast.makeText(this, "Salida registrada", Toast.LENGTH_SHORT).show();
            guardarDatos();
        } else {
            Toast.makeText(this, "Salida ya registrada", Toast.LENGTH_SHORT).show();
        }
    }

    private void eliminarAlumno(int pos) {
        new AlertDialog.Builder(this)
                .setTitle("¿Eliminar registro?")
                .setMessage("¿Seguro que desea eliminar este alumno?")
                .setPositiveButton("Sí", (dialog, which) -> {
                    datosGuardados.remove(pos);
                    actualizarLista();
                    guardarDatos();
                })
                .setNegativeButton("No", null)
                .show();
    }

    private void eliminarTodosLosRegistros() {
        new AlertDialog.Builder(this)
                .setTitle("¿Eliminar todos los registros?")
                .setMessage("¿Seguro que desea eliminar todos los registros?")
                .setPositiveButton("Sí", (dialog, which) -> {
                    datosGuardados.clear();
                    actualizarLista();
                    guardarDatos();
                    Toast.makeText(this, "Todos los registros eliminados", Toast.LENGTH_SHORT).show();
                })
                .setNegativeButton("No", null)
                .show();
    }

    private void actualizarLista() {
        visitas.clear();
        for (Alumno alumno : datosGuardados) {
            visitas.add(alumno.toString());
        }
        adapter.notifyDataSetChanged();
    }

    private void limpiarCampos() {
        editNombre.setText("");
        editEdad.setText("");
        editIdAlumno.setText("");
    }

    private void guardarDatos() {
        SharedPreferences prefs = getSharedPreferences("AlumnosApp", MODE_PRIVATE);
        SharedPreferences.Editor editor = prefs.edit();
        String json = new Gson().toJson(datosGuardados);
        editor.putString("alumnos_list", json);
        editor.apply();
    }

    private void cargarDatos() {
        SharedPreferences prefs = getSharedPreferences("AlumnosApp", MODE_PRIVATE);
        String json = prefs.getString("alumnos_list", null);
        Type type = new TypeToken<ArrayList<Alumno>>(){}.getType();
        ArrayList<Alumno> lista = new Gson().fromJson(json, type);

        if (lista != null) {
            datosGuardados.clear();
            datosGuardados.addAll(lista);
        }
    }
}
