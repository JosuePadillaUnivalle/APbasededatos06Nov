package com.example.basededatos;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class ContactoDAO {
    private SQLiteDatabase db;

    public ContactoDAO(SQLiteDatabase db) {
        this.db = db;
    }

    // Insertar contacto
    public long insertarContacto(int idUsuario, int idEmpresa, String mensaje) {
        ContentValues values = new ContentValues();
        values.put("idUsuario", idUsuario);
        values.put("idEmpresa", idEmpresa);
        values.put("mensaje", mensaje);
        return db.insert("Contactos", null, values);
    }

    // Obtener contacto por ID
    public Cursor obtenerContactoPorId(int idContacto) {
        return db.query("Contactos", null, "idContacto = ?", new String[]{String.valueOf(idContacto)}, null, null, null);
    }

    // Obtener contactos por usuario
    public Cursor obtenerContactosPorUsuario(int idUsuario) {
        return db.query("Contactos", null, "idUsuario = ?", new String[]{String.valueOf(idUsuario)}, null, null, "fecha DESC");
    }

    // Obtener contactos por empresa
    public Cursor obtenerContactosPorEmpresa(int idEmpresa) {
        return db.query("Contactos", null, "idEmpresa = ?", new String[]{String.valueOf(idEmpresa)}, null, null, "fecha DESC");
    }

    // Obtener todos los contactos
    public Cursor obtenerTodosContactos() {
        return db.query("Contactos", null, null, null, null, null, "fecha DESC");
    }

    // Eliminar contacto
    public int eliminarContacto(int idContacto) {
        return db.delete("Contactos", "idContacto = ?", new String[]{String.valueOf(idContacto)});
    }
}

