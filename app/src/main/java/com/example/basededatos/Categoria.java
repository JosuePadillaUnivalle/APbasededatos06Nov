package com.example.basededatos;

import com.google.gson.annotations.SerializedName;

public class Categoria {
    @SerializedName("idCategoria")
    private int idCategoria;
    
    @SerializedName("nombre")
    private String nombre;
    
    public Categoria() {}
    
    public Categoria(String nombre) {
        this.nombre = nombre;
    }
    
    // Getters y Setters
    public int getIdCategoria() { return idCategoria; }
    public void setIdCategoria(int idCategoria) { this.idCategoria = idCategoria; }
    
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
}

