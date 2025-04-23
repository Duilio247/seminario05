package com.cursospea.pyaprendizaje3;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import androidx.appcompat.app.AppCompatActivity;

import com.cursospea.pyaprendizaje3.utils.SessionManager;

public class MainActivity extends AppCompatActivity {

    private static final int SPLASH_TIME_OUT = 2000; // 2 segundos
    private SessionManager sessionManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Ocultar la ActionBar solo en esta pantalla (pantalla de bienvenida)
        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }

        setContentView(R.layout.activity_main);

        // Inicializar SessionManager
        sessionManager = new SessionManager(this);

        // Handler para retrasar la navegación
        new Handler().postDelayed(() -> {
            if (sessionManager.isLoggedIn()) {
                startActivity(new Intent(MainActivity.this, ProfileActivity.class));
            } else {
                startActivity(new Intent(MainActivity.this, LoginActivity.class));
            }
            finish();
        }, SPLASH_TIME_OUT);
    }
}
