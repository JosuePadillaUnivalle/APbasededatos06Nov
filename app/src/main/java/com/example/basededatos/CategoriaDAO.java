package com.example.basededatos;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class CategoriaDAO {
    private SQLiteDatabase db;

    public CategoriaDAO(SQLiteDatabase db) {
        this.db = db;
    }

    // Insertar categoría
    public long insertarCategoria(String nombre) {
        ContentValues values = new ContentValues();
        values.put("nombre", nombre);
        return db.insert("Categorias", null, values);
    }

    // Obtener categoría por ID
    public Cursor obtenerCategoriaPorId(int idCategoria) {
        return db.query("Categorias", null, "idCategoria = ?", new String[]{String.valueOf(idCategoria)}, null, null, null);
    }

    // Obtener todas las categorías
    public Cursor obtenerTodasCategorias() {
        return db.query("Categorias", null, null, null, null, null, null);
    }

    // Actualizar categoría
    public int actualizarCategoria(int idCategoria, String nombre) {
        ContentValues values = new ContentValues();
        values.put("nombre", nombre);
        return db.update("Categorias", values, "idCategoria = ?", new String[]{String.valueOf(idCategoria)});
    }

    // Eliminar categoría
    public int eliminarCategoria(int idCategoria) {
        return db.delete("Categorias", "idCategoria = ?", new String[]{String.valueOf(idCategoria)});
    }
}

