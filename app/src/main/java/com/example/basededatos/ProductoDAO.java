package com.example.basededatos;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class ProductoDAO {
    private SQLiteDatabase db;

    public ProductoDAO(SQLiteDatabase db) {
        this.db = db;
    }

    // Insertar producto
    public long insertarProducto(int idEmpresa, String nombre, String descripcion, double precio, String categoria, String estado) {
        ContentValues values = new ContentValues();
        values.put("idEmpresa", idEmpresa);
        values.put("nombre", nombre);
        values.put("descripcion", descripcion);
        values.put("precio", precio);
        values.put("categoria", categoria);
        values.put("estado", estado);
        return db.insert("Productos", null, values);
    }

    // Obtener producto por ID
    public Cursor obtenerProductoPorId(int idProducto) {
        return db.query("Productos", null, "idProducto = ?", new String[]{String.valueOf(idProducto)}, null, null, null);
    }

    // Obtener productos por empresa
    public Cursor obtenerProductosPorEmpresa(int idEmpresa) {
        return db.query("Productos", null, "idEmpresa = ?", new String[]{String.valueOf(idEmpresa)}, null, null, null);
    }

    // Obtener productos por categoría
    public Cursor obtenerProductosPorCategoria(String categoria) {
        return db.query("Productos", null, "categoria = ?", new String[]{categoria}, null, null, null);
    }

    // Obtener todos los productos
    public Cursor obtenerTodosProductos() {
        return db.query("Productos", null, null, null, null, null, null);
    }

    // Actualizar producto
    public int actualizarProducto(int idProducto, String nombre, String descripcion, double precio, String categoria, String estado) {
        ContentValues values = new ContentValues();
        values.put("nombre", nombre);
        values.put("descripcion", descripcion);
        values.put("precio", precio);
        values.put("categoria", categoria);
        values.put("estado", estado);
        return db.update("Productos", values, "idProducto = ?", new String[]{String.valueOf(idProducto)});
    }

    // Eliminar producto
    public int eliminarProducto(int idProducto) {
        return db.delete("Productos", "idProducto = ?", new String[]{String.valueOf(idProducto)});
    }
}

