package com.cursospea.pyaprendizaje2.activities;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.cursospea.pyaprendizaje2.R;
import com.cursospea.pyaprendizaje2.data.UserDbHelper;
import com.cursospea.pyaprendizaje2.model.User;

public class AddEditUserActivity extends AppCompatActivity {
    private static final int REQUEST_SELECT_IMAGE = 100;

    private UserDbHelper dbHelper;
    private User currentUser;
    private String userId;
    private boolean isEditMode = false;

    private EditText nameEditText;
    private EditText professionEditText;
    private EditText emailEditText;
    private EditText phoneEditText;
    private EditText bioEditText;
    private ImageView avatarImageView;
    private String selectedImageUri = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_edit_user);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        // Inicializar vistas
        nameEditText = findViewById(R.id.edit_name);
        professionEditText = findViewById(R.id.edit_profession);
        emailEditText = findViewById(R.id.edit_email);
        phoneEditText = findViewById(R.id.edit_phone);
        bioEditText = findViewById(R.id.edit_bio);
        avatarImageView = findViewById(R.id.edit_avatar);
        Button saveButton = findViewById(R.id.button_save);
        Button selectImageButton = findViewById(R.id.button_select_image);

        // Inicializar DB Helper
        dbHelper = new UserDbHelper(this);

        // Verificar modo edición
        userId = getIntent().getStringExtra(UsersActivity.EXTRA_USER_ID);
        isEditMode = userId != null;

        getSupportActionBar().setTitle(isEditMode ? "Editar Usuario" : "Nuevo Usuario");

        if (isEditMode) {
            loadUserData();
        }

        selectImageButton.setOnClickListener(view -> {
            Intent intent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
            startActivityForResult(intent, REQUEST_SELECT_IMAGE);
        });

        saveButton.setOnClickListener(view -> {
            saveUser();
        });
    }

    private void loadUserData() {
        currentUser = dbHelper.getUserById(userId);

        if (currentUser != null) {
            nameEditText.setText(currentUser.getName());
            professionEditText.setText(currentUser.getProfession());
            emailEditText.setText(currentUser.getEmail());
            phoneEditText.setText(currentUser.getPhone());
            bioEditText.setText(currentUser.getBio());

            if (currentUser.getAvatarUri() != null && !currentUser.getAvatarUri().isEmpty()) {
                selectedImageUri = currentUser.getAvatarUri();
                avatarImageView.setImageURI(Uri.parse(selectedImageUri));
            }
        }
    }

    private void saveUser() {
        String name = nameEditText.getText().toString().trim();
        String profession = professionEditText.getText().toString().trim();
        String email = emailEditText.getText().toString().trim();
        String phone = phoneEditText.getText().toString().trim();
        String bio = bioEditText.getText().toString().trim();

        if (name.isEmpty() || profession.isEmpty() || email.isEmpty()) {
            Toast.makeText(this, "Por favor complete todos los campos obligatorios", Toast.LENGTH_SHORT).show();
            return;
        }

        if (isEditMode) {
            currentUser.setName(name);
            currentUser.setProfession(profession);
            currentUser.setEmail(email);
            currentUser.setPhone(phone);
            currentUser.setBio(bio);

            if (selectedImageUri != null) {
                currentUser.setAvatarUri(selectedImageUri);
            }

            int rowsUpdated = dbHelper.updateUser(currentUser);

            if (rowsUpdated > 0) {
                setResult(RESULT_OK);
                finish();
            } else {
                Toast.makeText(this, "Error al actualizar datos", Toast.LENGTH_SHORT).show();
            }
        } else {
            User newUser = new User();
            newUser.setName(name);
            newUser.setProfession(profession);
            newUser.setEmail(email);
            newUser.setPhone(phone);
            newUser.setBio(bio);

            if (selectedImageUri != null) {
                newUser.setAvatarUri(selectedImageUri);
            }

            long newRowId = dbHelper.addUser(newUser);

            if (newRowId > 0) {
                setResult(RESULT_OK);
                finish();
            } else {
                Toast.makeText(this, "Error al guardar datos", Toast.LENGTH_SHORT).show();
            }
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == REQUEST_SELECT_IMAGE && resultCode == RESULT_OK && data != null) {
            Uri imageUri = data.getData();
            if (imageUri != null) {
                selectedImageUri = imageUri.toString();
                avatarImageView.setImageURI(imageUri);
            }
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            onBackPressed();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
