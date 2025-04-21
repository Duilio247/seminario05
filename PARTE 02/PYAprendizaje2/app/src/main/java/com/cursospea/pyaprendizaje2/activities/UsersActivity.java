package com.cursospea.pyaprendizaje2.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.cursospea.pyaprendizaje2.R;
import com.cursospea.pyaprendizaje2.adapters.UserAdapter;
import com.cursospea.pyaprendizaje2.data.UserDbHelper;
import com.cursospea.pyaprendizaje2.model.User;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.List;

public class UsersActivity extends AppCompatActivity {
    public static final String EXTRA_USER_ID = "extra_user_id";
    private static final int REQUEST_ADD_USER = 1;
    private static final int REQUEST_EDIT_USER = 2;

    private UserDbHelper dbHelper;
    private UserAdapter adapter;
    private List<User> userList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_users); // Asegúrate de tener este layout

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        dbHelper = new UserDbHelper(this);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(view -> {
            Intent intent = new Intent(this, AddEditUserActivity.class);
            startActivityForResult(intent, REQUEST_ADD_USER);
        });

        loadUserList();
    }

    @Override
    protected void onResume() {
        super.onResume();
        loadUserList();
    }

    private void loadUserList() {
        userList = dbHelper.getAllUsers();

        adapter = new UserAdapter(this, userList);
        ListView listView = findViewById(R.id.users_list);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener((parent, view, position, id) -> {
            User selectedUser = userList.get(position);
            Intent intent = new Intent(UsersActivity.this, UserDetailActivity.class);
            intent.putExtra(EXTRA_USER_ID, selectedUser.getId());
            startActivity(intent);
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode == RESULT_OK) {
            if (requestCode == REQUEST_ADD_USER) {
                Toast.makeText(this, "Usuario agregado correctamente", Toast.LENGTH_SHORT).show();
                loadUserList();
            } else if (requestCode == REQUEST_EDIT_USER) {
                Toast.makeText(this, "Datos del usuario actualizados", Toast.LENGTH_SHORT).show();
                loadUserList();
            }
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu); // Puedes usar el mismo menú
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.action_about) {
            Toast.makeText(this, "Gestión de Usuarios v1.0", Toast.LENGTH_SHORT).show();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
