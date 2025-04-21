package com.cursospea.pyaprendizaje2.data;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.cursospea.pyaprendizaje2.model.User;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class UserDbHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "Users.db";
    private static final int DATABASE_VERSION = 2;  // Versión incrementada

    // Definición de tabla
    private static final String TABLE_USERS = "user";
    private static final String COLUMN_ID = "_id";
    private static final String COLUMN_UUID = "id";
    private static final String COLUMN_NAME = "name";
    private static final String COLUMN_PROFESSION = "profession";
    private static final String COLUMN_EMAIL = "email";
    private static final String COLUMN_PHONE = "phone";
    private static final String COLUMN_BIO = "bio"; // Nuevo campo
    private static final String COLUMN_AVATAR_URI = "avatarUri"; // Nuevo campo

    public UserDbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String SQL_CREATE_USER_TABLE = "CREATE TABLE " + TABLE_USERS + " (" +
                COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                COLUMN_UUID + " TEXT NOT NULL," +
                COLUMN_NAME + " TEXT NOT NULL," +
                COLUMN_PROFESSION + " TEXT NOT NULL," +
                COLUMN_EMAIL + " TEXT NOT NULL," +
                COLUMN_PHONE + " TEXT NOT NULL," +
                COLUMN_BIO + " TEXT," + // Nuevo campo
                COLUMN_AVATAR_URI + " TEXT);";
        db.execSQL(SQL_CREATE_USER_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        if (oldVersion < 2) {
            db.execSQL("ALTER TABLE " + TABLE_USERS + " ADD COLUMN " + COLUMN_BIO + " TEXT;");
            db.execSQL("ALTER TABLE " + TABLE_USERS + " ADD COLUMN " + COLUMN_AVATAR_URI + " TEXT;");
        }
    }

    // CREATE
    public long addUser(User user) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues values = new ContentValues();

        if (user.getId() == null || user.getId().isEmpty()) {
            user.setId(UUID.randomUUID().toString());
        }

        values.put(COLUMN_UUID, user.getId());
        values.put(COLUMN_NAME, user.getName());
        values.put(COLUMN_PROFESSION, user.getProfession());
        values.put(COLUMN_EMAIL, user.getEmail());
        values.put(COLUMN_PHONE, user.getPhone());
        values.put(COLUMN_BIO, user.getBio()); // Nuevo campo
        values.put(COLUMN_AVATAR_URI, user.getAvatarUri());

        return db.insert(TABLE_USERS, null, values);
    }

    // READ - all users
    public List<User> getAllUsers() {
        List<User> userList = new ArrayList<>();
        SQLiteDatabase db = getReadableDatabase();

        Cursor cursor = db.query(
                TABLE_USERS,
                null,
                null,
                null,
                null,
                null,
                COLUMN_NAME + " ASC"
        );

        try {
            int idColumnIndex = cursor.getColumnIndex(COLUMN_UUID);
            int nameColumnIndex = cursor.getColumnIndex(COLUMN_NAME);
            int professionColumnIndex = cursor.getColumnIndex(COLUMN_PROFESSION);
            int emailColumnIndex = cursor.getColumnIndex(COLUMN_EMAIL);
            int phoneColumnIndex = cursor.getColumnIndex(COLUMN_PHONE);
            int bioColumnIndex = cursor.getColumnIndex(COLUMN_BIO); // Nuevo campo
            int avatarUriColumnIndex = cursor.getColumnIndex(COLUMN_AVATAR_URI);

            while (cursor.moveToNext()) {
                User user = new User();
                user.setId(cursor.getString(idColumnIndex));
                user.setName(cursor.getString(nameColumnIndex));
                user.setProfession(cursor.getString(professionColumnIndex));
                user.setEmail(cursor.getString(emailColumnIndex));
                user.setPhone(cursor.getString(phoneColumnIndex));
                user.setBio(cursor.getString(bioColumnIndex)); // Nuevo campo
                user.setAvatarUri(cursor.getString(avatarUriColumnIndex));

                userList.add(user);
            }
        } finally {
            cursor.close();
        }

        return userList;
    }

    // READ - single user by ID
    public User getUserById(String userId) {
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.query(
                TABLE_USERS,
                null,
                COLUMN_UUID + " = ?",
                new String[]{userId},
                null,
                null,
                null
        );

        User user = null;

        try {
            if (cursor.moveToFirst()) {
                int idColumnIndex = cursor.getColumnIndex(COLUMN_UUID);
                int nameColumnIndex = cursor.getColumnIndex(COLUMN_NAME);
                int professionColumnIndex = cursor.getColumnIndex(COLUMN_PROFESSION);
                int emailColumnIndex = cursor.getColumnIndex(COLUMN_EMAIL);
                int phoneColumnIndex = cursor.getColumnIndex(COLUMN_PHONE);
                int bioColumnIndex = cursor.getColumnIndex(COLUMN_BIO); // Nuevo campo
                int avatarUriColumnIndex = cursor.getColumnIndex(COLUMN_AVATAR_URI);

                user = new User();
                user.setId(cursor.getString(idColumnIndex));
                user.setName(cursor.getString(nameColumnIndex));
                user.setProfession(cursor.getString(professionColumnIndex));
                user.setEmail(cursor.getString(emailColumnIndex));
                user.setPhone(cursor.getString(phoneColumnIndex));
                user.setBio(cursor.getString(bioColumnIndex)); // Nuevo campo
                user.setAvatarUri(cursor.getString(avatarUriColumnIndex));
            }
        } finally {
            cursor.close();
        }

        return user;
    }

    // UPDATE
    public int updateUser(User user) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(COLUMN_NAME, user.getName());
        values.put(COLUMN_PROFESSION, user.getProfession());
        values.put(COLUMN_EMAIL, user.getEmail());
        values.put(COLUMN_PHONE, user.getPhone());
        values.put(COLUMN_BIO, user.getBio()); // Nuevo campo
        values.put(COLUMN_AVATAR_URI, user.getAvatarUri());

        return db.update(
                TABLE_USERS,
                values,
                COLUMN_UUID + " = ?",
                new String[]{user.getId()}
        );
    }

    // DELETE
    public int deleteUser(String userId) {
        SQLiteDatabase db = getWritableDatabase();
        return db.delete(
                TABLE_USERS,
                COLUMN_UUID + " = ?",
                new String[]{userId}
        );
    }
}
