package com.example.basededatos;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.DELETE;
import retrofit2.http.Path;
import java.util.List;

public interface ApiService {
    
    // Endpoints de Usuarios
    @GET("usuarios")
    Call<List<Usuario>> obtenerUsuarios();
    
    @POST("usuarios")
    Call<Usuario> crearUsuario(@Body Usuario usuario);
    
    @GET("usuarios/{id}")
    Call<Usuario> obtenerUsuario(@Path("id") int id);
    
    // Endpoints de Empresas
    @GET("empresas")
    Call<List<Empresa>> obtenerEmpresas();
    
    @POST("empresas")
    Call<Empresa> crearEmpresa(@Body Empresa empresa);
    
    // Endpoints de Productos
    @GET("productos")
    Call<List<Producto>> obtenerProductos();
    
    @POST("productos")
    Call<Producto> crearProducto(@Body Producto producto);
    
    @GET("productos/empresa/{idEmpresa}")
    Call<List<Producto>> obtenerProductosPorEmpresa(@Path("idEmpresa") int idEmpresa);
    
    // Endpoints de Categorias
    @GET("categorias")
    Call<List<Categoria>> obtenerCategorias();
    
    @POST("categorias")
    Call<Categoria> crearCategoria(@Body Categoria categoria);
    
    // Endpoints de Contactos
    @GET("contactos")
    Call<List<Contacto>> obtenerContactos();
    
    @POST("contactos")
    Call<Contacto> crearContacto(@Body Contacto contacto);
    
    // Endpoints de Valoraciones
    @GET("valoraciones")
    Call<List<Valoracion>> obtenerValoraciones();
    
    @POST("valoraciones")
    Call<Valoracion> crearValoracion(@Body Valoracion valoracion);
    
    @GET("valoraciones/empresa/{idEmpresa}")
    Call<List<Valoracion>> obtenerValoracionesPorEmpresa(@Path("idEmpresa") int idEmpresa);
}

