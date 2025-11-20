package com.example.basededatos;

import com.google.gson.annotations.SerializedName;

public class Empresa {
    @SerializedName("idEmpresa")
    private int idEmpresa;
    
    @SerializedName("idUsuario")
    private int idUsuario;
    
    @SerializedName("nombre")
    private String nombre;
    
    @SerializedName("descripcion")
    private String descripcion;
    
    @SerializedName("telefono")
    private String telefono;
    
    @SerializedName("ubicacion")
    private String ubicacion;
    
    public Empresa() {}
    
    public Empresa(int idUsuario, String nombre, String descripcion, String telefono, String ubicacion) {
        this.idUsuario = idUsuario;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.telefono = telefono;
        this.ubicacion = ubicacion;
    }
    
    // Getters y Setters
    public int getIdEmpresa() { return idEmpresa; }
    public void setIdEmpresa(int idEmpresa) { this.idEmpresa = idEmpresa; }
    
    public int getIdUsuario() { return idUsuario; }
    public void setIdUsuario(int idUsuario) { this.idUsuario = idUsuario; }
    
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    
    public String getDescripcion() { return descripcion; }
    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }
    
    public String getTelefono() { return telefono; }
    public void setTelefono(String telefono) { this.telefono = telefono; }
    
    public String getUbicacion() { return ubicacion; }
    public void setUbicacion(String ubicacion) { this.ubicacion = ubicacion; }
}

