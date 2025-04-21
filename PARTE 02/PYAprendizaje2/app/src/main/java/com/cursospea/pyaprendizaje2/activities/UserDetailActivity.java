package com.cursospea.pyaprendizaje2.activities;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.cursospea.pyaprendizaje2.R;
import com.cursospea.pyaprendizaje2.data.UserDbHelper;
import com.cursospea.pyaprendizaje2.model.User;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class UserDetailActivity extends AppCompatActivity {
    private static final int REQUEST_EDIT_USER = 1;

    private UserDbHelper dbHelper;
    private User user;
    private String userId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_detail);

        // Configurar Toolbar
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // Verificar que el ActionBar no sea null antes de configurar el "Up Button"
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

        dbHelper = new UserDbHelper(this);
        userId = getIntent().getStringExtra(UsersActivity.EXTRA_USER_ID);

        FloatingActionButton fabEdit = findViewById(R.id.fab_edit);
        fabEdit.setOnClickListener(view -> {
            Intent intent = new Intent(this, AddEditUserActivity.class);
            intent.putExtra(UsersActivity.EXTRA_USER_ID, userId);
            startActivityForResult(intent, REQUEST_EDIT_USER);
        });

        FloatingActionButton fabCall = findViewById(R.id.fab_call);
        fabCall.setOnClickListener(view -> {
            if (user != null) {
                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:" + user.getPhone()));
                startActivity(intent);
            }
        });

        loadUserDetails();
    }


    @Override
    protected void onResume() {
        super.onResume();
        loadUserDetails();
    }

    private void loadUserDetails() {
        if (userId != null) {
            user = dbHelper.getUserById(userId);

            if (user != null) {
                // Establecer título
                getSupportActionBar().setTitle(user.getName());

                // Poblar vistas con datos
                TextView nameTextView = findViewById(R.id.detail_name);
                TextView professionTextView = findViewById(R.id.detail_profession);
                TextView emailTextView = findViewById(R.id.detail_email);
                TextView phoneTextView = findViewById(R.id.detail_phone);
                ImageView avatarImageView = findViewById(R.id.detail_avatar);
                TextView bioTextView = findViewById(R.id.detail_bio);

                nameTextView.setText(user.getName());
                professionTextView.setText(user.getProfession());
                emailTextView.setText(user.getEmail());

                if (user.getPhone() != null && !user.getPhone().isEmpty()) {
                    phoneTextView.setText(user.getPhone());
                } else {
                    phoneTextView.setText("Teléfono: No disponible");
                }

                if (user.getBio() != null && !user.getBio().isEmpty()) {
                    bioTextView.setText(user.getBio());
                } else {
                    bioTextView.setText("Sin biografía disponible");
                }

                if (user.getAvatarUri() != null && !user.getAvatarUri().isEmpty()) {
                    avatarImageView.setImageURI(Uri.parse(user.getAvatarUri()));
                } else {
                    avatarImageView.setImageResource(R.drawable.default_avatar);
                }
            }
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode == RESULT_OK && requestCode == REQUEST_EDIT_USER) {
            Toast.makeText(this, "Datos actualizados correctamente", Toast.LENGTH_SHORT).show();
            loadUserDetails();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_detail, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_delete) {
            showDeleteConfirmationDialog();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onSupportNavigateUp() {
        finish(); // Regresa a la pantalla anterior de forma segura
        return true;
    }

    private void showDeleteConfirmationDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Eliminar usuario");
        builder.setMessage("¿Estás seguro de que deseas eliminar este usuario? Esta acción no se puede deshacer.");
        builder.setPositiveButton("Eliminar", (dialog, which) -> deleteUser());
        builder.setNegativeButton("Cancelar", null);
        builder.show();
    }

    private void deleteUser() {
        if (userId != null) {
            int rowsDeleted = dbHelper.deleteUser(userId);

            if (rowsDeleted > 0) {
                Toast.makeText(this, "Usuario eliminado correctamente", Toast.LENGTH_SHORT).show();
                finish();
            } else {
                Toast.makeText(this, "Error al eliminar usuario", Toast.LENGTH_SHORT).show();
            }
        }
    }
}
