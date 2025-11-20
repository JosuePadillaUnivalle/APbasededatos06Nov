package com.example.basededatos;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class EmpresaDAO {
    private SQLiteDatabase db;

    public EmpresaDAO(SQLiteDatabase db) {
        this.db = db;
    }

    // Insertar empresa
    public long insertarEmpresa(int idUsuario, String nombre, String descripcion, String telefono, String ubicacion) {
        ContentValues values = new ContentValues();
        values.put("idUsuario", idUsuario);
        values.put("nombre", nombre);
        values.put("descripcion", descripcion);
        values.put("telefono", telefono);
        values.put("ubicacion", ubicacion);
        return db.insert("Empresas", null, values);
    }

    // Obtener empresa por ID
    public Cursor obtenerEmpresaPorId(int idEmpresa) {
        return db.query("Empresas", null, "idEmpresa = ?", new String[]{String.valueOf(idEmpresa)}, null, null, null);
    }

    // Obtener empresa por ID de usuario
    public Cursor obtenerEmpresaPorUsuario(int idUsuario) {
        return db.query("Empresas", null, "idUsuario = ?", new String[]{String.valueOf(idUsuario)}, null, null, null);
    }

    // Obtener todas las empresas
    public Cursor obtenerTodasEmpresas() {
        return db.query("Empresas", null, null, null, null, null, null);
    }

    // Actualizar empresa
    public int actualizarEmpresa(int idEmpresa, String nombre, String descripcion, String telefono, String ubicacion) {
        ContentValues values = new ContentValues();
        values.put("nombre", nombre);
        values.put("descripcion", descripcion);
        values.put("telefono", telefono);
        values.put("ubicacion", ubicacion);
        return db.update("Empresas", values, "idEmpresa = ?", new String[]{String.valueOf(idEmpresa)});
    }

    // Eliminar empresa
    public int eliminarEmpresa(int idEmpresa) {
        return db.delete("Empresas", "idEmpresa = ?", new String[]{String.valueOf(idEmpresa)});
    }
}

