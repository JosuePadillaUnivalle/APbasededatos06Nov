package com.example.basededatos;

import com.google.gson.annotations.SerializedName;

public class Valoracion {
    @SerializedName("idValoracion")
    private int idValoracion;
    
    @SerializedName("idUsuario")
    private int idUsuario;
    
    @SerializedName("idEmpresa")
    private int idEmpresa;
    
    @SerializedName("puntuacion")
    private int puntuacion;
    
    @SerializedName("comentario")
    private String comentario;
    
    @SerializedName("fecha")
    private String fecha;
    
    public Valoracion() {}
    
    public Valoracion(int idUsuario, int idEmpresa, int puntuacion, String comentario) {
        this.idUsuario = idUsuario;
        this.idEmpresa = idEmpresa;
        this.puntuacion = puntuacion;
        this.comentario = comentario;
    }
    
    // Getters y Setters
    public int getIdValoracion() { return idValoracion; }
    public void setIdValoracion(int idValoracion) { this.idValoracion = idValoracion; }
    
    public int getIdUsuario() { return idUsuario; }
    public void setIdUsuario(int idUsuario) { this.idUsuario = idUsuario; }
    
    public int getIdEmpresa() { return idEmpresa; }
    public void setIdEmpresa(int idEmpresa) { this.idEmpresa = idEmpresa; }
    
    public int getPuntuacion() { return puntuacion; }
    public void setPuntuacion(int puntuacion) { this.puntuacion = puntuacion; }
    
    public String getComentario() { return comentario; }
    public void setComentario(String comentario) { this.comentario = comentario; }
    
    public String getFecha() { return fecha; }
    public void setFecha(String fecha) { this.fecha = fecha; }
}

