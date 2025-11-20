package com.example.basededatos;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class ValoracionDAO {
    private SQLiteDatabase db;

    public ValoracionDAO(SQLiteDatabase db) {
        this.db = db;
    }

    // Insertar valoración
    public long insertarValoracion(int idUsuario, int idEmpresa, int puntuacion, String comentario) {
        ContentValues values = new ContentValues();
        values.put("idUsuario", idUsuario);
        values.put("idEmpresa", idEmpresa);
        values.put("puntuacion", puntuacion);
        values.put("comentario", comentario);
        return db.insert("Valoraciones", null, values);
    }

    // Obtener valoración por ID
    public Cursor obtenerValoracionPorId(int idValoracion) {
        return db.query("Valoraciones", null, "idValoracion = ?", new String[]{String.valueOf(idValoracion)}, null, null, null);
    }

    // Obtener valoraciones por empresa
    public Cursor obtenerValoracionesPorEmpresa(int idEmpresa) {
        return db.query("Valoraciones", null, "idEmpresa = ?", new String[]{String.valueOf(idEmpresa)}, null, null, "fecha DESC");
    }

    // Obtener valoraciones por usuario
    public Cursor obtenerValoracionesPorUsuario(int idUsuario) {
        return db.query("Valoraciones", null, "idUsuario = ?", new String[]{String.valueOf(idUsuario)}, null, null, "fecha DESC");
    }

    // Obtener promedio de valoraciones de una empresa
    public double obtenerPromedioValoraciones(int idEmpresa) {
        Cursor cursor = db.rawQuery("SELECT AVG(puntuacion) as promedio FROM Valoraciones WHERE idEmpresa = ?", 
                new String[]{String.valueOf(idEmpresa)});
        double promedio = 0;
        if (cursor.moveToFirst()) {
            promedio = cursor.getDouble(0);
        }
        cursor.close();
        return promedio;
    }

    // Obtener todas las valoraciones
    public Cursor obtenerTodasValoraciones() {
        return db.query("Valoraciones", null, null, null, null, null, "fecha DESC");
    }

    // Eliminar valoración
    public int eliminarValoracion(int idValoracion) {
        return db.delete("Valoraciones", "idValoracion = ?", new String[]{String.valueOf(idValoracion)});
    }
}

