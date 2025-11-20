package com.example.basededatos;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class UsuarioDAO {
    private SQLiteDatabase db;

    public UsuarioDAO(SQLiteDatabase db) {
        this.db = db;
    }

    // Insertar usuario
    public long insertarUsuario(String nombre, String email, String password, String rol) {
        ContentValues values = new ContentValues();
        values.put("nombre", nombre);
        values.put("email", email);
        values.put("password", password);
        values.put("rol", rol);
        return db.insert("Usuarios", null, values);
    }

    // Obtener usuario por email
    public Cursor obtenerUsuarioPorEmail(String email) {
        return db.query("Usuarios", null, "email = ?", new String[]{email}, null, null, null);
    }

    // Obtener usuario por ID
    public Cursor obtenerUsuarioPorId(int idUsuario) {
        return db.query("Usuarios", null, "idUsuario = ?", new String[]{String.valueOf(idUsuario)}, null, null, null);
    }

    // Obtener todos los usuarios
    public Cursor obtenerTodosUsuarios() {
        return db.query("Usuarios", null, null, null, null, null, null);
    }

    // Actualizar usuario
    public int actualizarUsuario(int idUsuario, String nombre, String email, String password, String rol) {
        ContentValues values = new ContentValues();
        values.put("nombre", nombre);
        values.put("email", email);
        values.put("password", password);
        values.put("rol", rol);
        return db.update("Usuarios", values, "idUsuario = ?", new String[]{String.valueOf(idUsuario)});
    }

    // Eliminar usuario
    public int eliminarUsuario(int idUsuario) {
        return db.delete("Usuarios", "idUsuario = ?", new String[]{String.valueOf(idUsuario)});
    }

    // Verificar login
    public Cursor verificarLogin(String email, String password) {
        return db.query("Usuarios", null, "email = ? AND password = ?", 
                new String[]{email, password}, null, null, null);
    }
}

