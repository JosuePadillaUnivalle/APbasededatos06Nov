package com.example.basededatos;

import com.google.gson.annotations.SerializedName;

public class Contacto {
    @SerializedName("idContacto")
    private int idContacto;
    
    @SerializedName("idUsuario")
    private int idUsuario;
    
    @SerializedName("idEmpresa")
    private int idEmpresa;
    
    @SerializedName("mensaje")
    private String mensaje;
    
    @SerializedName("fecha")
    private String fecha;
    
    public Contacto() {}
    
    public Contacto(int idUsuario, int idEmpresa, String mensaje) {
        this.idUsuario = idUsuario;
        this.idEmpresa = idEmpresa;
        this.mensaje = mensaje;
    }
    
    // Getters y Setters
    public int getIdContacto() { return idContacto; }
    public void setIdContacto(int idContacto) { this.idContacto = idContacto; }
    
    public int getIdUsuario() { return idUsuario; }
    public void setIdUsuario(int idUsuario) { this.idUsuario = idUsuario; }
    
    public int getIdEmpresa() { return idEmpresa; }
    public void setIdEmpresa(int idEmpresa) { this.idEmpresa = idEmpresa; }
    
    public String getMensaje() { return mensaje; }
    public void setMensaje(String mensaje) { this.mensaje = mensaje; }
    
    public String getFecha() { return fecha; }
    public void setFecha(String fecha) { this.fecha = fecha; }
}

