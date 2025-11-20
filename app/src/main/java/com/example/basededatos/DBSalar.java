package com.example.basededatos;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DBSalar extends SQLiteOpenHelper {

    //Constructor de la clase
    public DBSalar(@Nullable Context context) {

//Invocar al constructor de la clase padre
        super(context, "Salar.db", null, 3);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        //  Tabla Usuarios
        db.execSQL("CREATE TABLE Usuarios (" +
                "idUsuario INTEGER PRIMARY KEY AUTOINCREMENT," +
                "nombre TEXT NOT NULL," +
                "email TEXT UNIQUE NOT NULL," +
                "password TEXT NOT NULL," +
                "rol TEXT CHECK(rol IN ('cliente','empresa','admin')) NOT NULL)");

        //  Tabla Empresas
        db.execSQL("CREATE TABLE Empresas (" +
                "idEmpresa INTEGER PRIMARY KEY AUTOINCREMENT," +
                "idUsuario INTEGER NOT NULL," +
                "nombre TEXT NOT NULL," +
                "descripcion TEXT," +
                "telefono TEXT," +
                "ubicacion TEXT," +
                "FOREIGN KEY (idUsuario) REFERENCES Usuarios(idUsuario))");

        //  Tabla Productos
        db.execSQL("CREATE TABLE Productos (" +
                "idProducto INTEGER PRIMARY KEY AUTOINCREMENT," +
                "idEmpresa INTEGER NOT NULL," +
                "nombre TEXT NOT NULL," +
                "descripcion TEXT," +
                "precio REAL," +
                "categoria TEXT," +
                "estado TEXT DEFAULT 'activo'," +
                "fechaPublicacion DATE DEFAULT (date('now'))," +
                "FOREIGN KEY (idEmpresa) REFERENCES Empresas(idEmpresa))");

        //  Tabla Categorias
        db.execSQL("CREATE TABLE Categorias (" +
                "idCategoria INTEGER PRIMARY KEY AUTOINCREMENT," +
                "nombre TEXT NOT NULL UNIQUE)");

        //  Tabla Contactos
        db.execSQL("CREATE TABLE Contactos (" +
                "idContacto INTEGER PRIMARY KEY AUTOINCREMENT," +
                "idUsuario INTEGER NOT NULL," +
                "idEmpresa INTEGER NOT NULL," +
                "mensaje TEXT," +
                "fecha DATE DEFAULT (date('now'))," +
                "FOREIGN KEY (idUsuario) REFERENCES Usuarios(idUsuario)," +
                "FOREIGN KEY (idEmpresa) REFERENCES Empresas(idEmpresa))");

        //  Tabla Valoraciones
        db.execSQL("CREATE TABLE Valoraciones (" +
                "idValoracion INTEGER PRIMARY KEY AUTOINCREMENT," +
                "idUsuario INTEGER NOT NULL," +
                "idEmpresa INTEGER NOT NULL," +
                "puntuacion INTEGER CHECK(puntuacion BETWEEN 1 AND 5)," +
                "comentario TEXT," +
                "fecha DATE DEFAULT (date('now'))," +
                "FOREIGN KEY (idUsuario) REFERENCES Usuarios(idUsuario)," +
                "FOREIGN KEY (idEmpresa) REFERENCES Empresas(idEmpresa))");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Eliminar tablas antiguas
        db.execSQL("DROP TABLE IF EXISTS Valoraciones");
        db.execSQL("DROP TABLE IF EXISTS Contactos");
        db.execSQL("DROP TABLE IF EXISTS Categorias");
        db.execSQL("DROP TABLE IF EXISTS Productos");
        db.execSQL("DROP TABLE IF EXISTS Empresas");
        db.execSQL("DROP TABLE IF EXISTS Usuarios");
        db.execSQL("DROP TABLE IF EXISTS usuarios");
        db.execSQL("DROP TABLE IF EXISTS roles");
        onCreate(db);
    }
}