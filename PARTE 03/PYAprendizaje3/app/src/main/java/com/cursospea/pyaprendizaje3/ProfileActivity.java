package com.cursospea.pyaprendizaje3;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.cursospea.pyaprendizaje3.utils.SessionManager;

public class ProfileActivity extends AppCompatActivity {

    private TextView welcomeTextView;
    private Button copyTokenButton;
    private SessionManager sessionManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        // Inicializar vistas
        welcomeTextView = findViewById(R.id.welcomeTextView);
        copyTokenButton = findViewById(R.id.copyTokenButton);

        // Inicializar SessionManager
        sessionManager = new SessionManager(getApplicationContext());

        // Verificar si el usuario está logueado
        if (!sessionManager.isLoggedIn()) {
            startActivity(new Intent(ProfileActivity.this, LoginActivity.class));
            finish();
        }

        // Mostrar mensaje de bienvenida con token
        String token = sessionManager.getToken();
        welcomeTextView.setText("¡Bienvenido a Zentry!\nHas iniciado sesión correctamente.\n\nToken: " + token);

        // Copiar el token al portapapeles
        copyTokenButton.setOnClickListener(v -> {
            String tokenText = sessionManager.getToken(); // Obtenemos el token
            if (!tokenText.isEmpty()) {
                android.content.ClipboardManager clipboard = (android.content.ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);
                android.content.ClipData clip = android.content.ClipData.newPlainText("Token", tokenText);
                clipboard.setPrimaryClip(clip);
                Toast.makeText(ProfileActivity.this, "Token copiado al portapapeles", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(ProfileActivity.this, "No hay token para copiar", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_profile, menu);
        MenuItem logoutItem = menu.findItem(R.id.action_logout);
        logoutItem.setIcon(R.drawable.ic_exit_to_app);  // Usamos el ícono para salir
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.action_logout) {
            // Muestra un AlertDialog para confirmar cierre de sesión
            new AlertDialog.Builder(this)
                    .setTitle("Cerrar sesión")
                    .setMessage("¿Estás seguro de que quieres cerrar sesión?")
                    .setCancelable(false)  // No permite salir del cuadro si no se hace una opción
                    .setPositiveButton("Sí", (dialog, which) -> {
                        // Realiza la acción de logout
                        sessionManager.logout();
                        startActivity(new Intent(ProfileActivity.this, LoginActivity.class));
                        finish();
                    })
                    .setNegativeButton("No", null)  // Si el usuario hace clic en No, solo cerramos el cuadro de diálogo
                    .show();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
