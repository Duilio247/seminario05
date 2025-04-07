package com.omarf.pyaprendizaje1;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.Button;
import android.widget.ListView;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private EditText editNombre, editEdad, editIdAlumno;
    private Button btnRegistrar, btnConsultar, btnEliminar, btnActualizar;
    private ListView listVisitas;
    private ArrayList<String> visitas;
    private ArrayAdapter<String> adapter;
    private ArrayList<String> datosGuardados;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Inicializar elementos de UI
        editNombre = findViewById(R.id.edit_nombre);
        editEdad = findViewById(R.id.edit_edad);
        editIdAlumno = findViewById(R.id.edit_id_alumno);
        btnRegistrar = findViewById(R.id.btn_registrar);
        btnConsultar = findViewById(R.id.btn_consultar);
        btnEliminar = findViewById(R.id.btn_eliminar);
        btnActualizar = findViewById(R.id.btn_actualizar);
        listVisitas = findViewById(R.id.list_visitas);

        // Configuración de lista
        visitas = new ArrayList<>();
        datosGuardados = new ArrayList<>();
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, visitas);
        listVisitas.setAdapter(adapter);

        // Listeners para botones
        btnRegistrar.setOnClickListener(v -> registrarVisita());
        btnConsultar.setOnClickListener(v -> consultarVisitas());
        btnEliminar.setOnClickListener(v -> eliminarVisita());
        btnActualizar.setOnClickListener(v -> actualizarLista());
    }

    private void registrarVisita() {
        String nombre = editNombre.getText().toString().trim();
        String edad = editEdad.getText().toString().trim();
        String idAlumno = editIdAlumno.getText().toString().trim();

        if (nombre.isEmpty() || edad.isEmpty() || idAlumno.isEmpty()) {
            mostrarAlerta("Por favor, complete todos los campos.");
        } else {
            String visita = "NOMBRE: " + nombre + "\nEDAD: " + edad + "\nID : " + idAlumno;
            datosGuardados.add(visita);
            limpiarCampos();
            mostrarAlerta("Registro guardado exitosamente.");
        }
    }

    private void consultarVisitas() {
        actualizarLista();
    }

    private void eliminarVisita() {
        if (!datosGuardados.isEmpty()) {
            datosGuardados.remove(datosGuardados.size() - 1);
            mostrarAlerta("Último registro eliminado.");
        } else {
            mostrarAlerta("No hay registros para eliminar.");
        }
    }

    private void actualizarLista() {
        visitas.clear();
        visitas.addAll(datosGuardados);
        adapter.notifyDataSetChanged();
    }

    private void limpiarCampos() {
        editNombre.setText("");
        editEdad.setText("");
        editIdAlumno.setText("");
    }

    private void mostrarAlerta(String mensaje) {
        Toast.makeText(this, mensaje, Toast.LENGTH_SHORT).show();
    }
}
