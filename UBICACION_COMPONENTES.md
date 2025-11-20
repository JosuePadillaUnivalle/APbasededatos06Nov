# 📍 Ubicación de Componentes del Proyecto

Este documento indica dónde se encuentra cada componente del sistema.

## 🗄️ BASE DE DATOS SQLITE

### Helper de Base de Datos
**Archivo:** `app/src/main/java/com/example/basededatos/DBSalar.java`
- Creación de todas las tablas
- Método `onCreate()` - Crea las 6 tablas
- Método `onUpgrade()` - Actualiza la base de datos
- Versión actual: 3

### Clases DAO (Data Access Object) - Operaciones CRUD

**Ubicación:** `app/src/main/java/com/example/basededatos/`

1. **UsuarioDAO.java**
   - `insertarUsuario()` - Crear usuario
   - `obtenerUsuarioPorEmail()` - Buscar por email
   - `obtenerUsuarioPorId()` - Buscar por ID
   - `obtenerTodosUsuarios()` - Listar todos
   - `actualizarUsuario()` - Modificar usuario
   - `eliminarUsuario()` - Eliminar usuario
   - `verificarLogin()` - Validar credenciales

2. **EmpresaDAO.java**
   - `insertarEmpresa()` - Crear empresa
   - `obtenerEmpresaPorId()` - Buscar por ID
   - `obtenerEmpresaPorUsuario()` - Buscar por usuario
   - `obtenerTodasEmpresas()` - Listar todas
   - `actualizarEmpresa()` - Modificar empresa
   - `eliminarEmpresa()` - Eliminar empresa

3. **ProductoDAO.java**
   - `insertarProducto()` - Crear producto
   - `obtenerProductoPorId()` - Buscar por ID
   - `obtenerProductosPorEmpresa()` - Buscar por empresa
   - `obtenerProductosPorCategoria()` - Buscar por categoría
   - `obtenerTodosProductos()` - Listar todos
   - `actualizarProducto()` - Modificar producto
   - `eliminarProducto()` - Eliminar producto

4. **CategoriaDAO.java**
   - `insertarCategoria()` - Crear categoría
   - `obtenerCategoriaPorId()` - Buscar por ID
   - `obtenerTodasCategorias()` - Listar todas
   - `actualizarCategoria()` - Modificar categoría
   - `eliminarCategoria()` - Eliminar categoría

5. **ContactoDAO.java**
   - `insertarContacto()` - Crear contacto
   - `obtenerContactoPorId()` - Buscar por ID
   - `obtenerContactosPorUsuario()` - Buscar por usuario
   - `obtenerContactosPorEmpresa()` - Buscar por empresa
   - `obtenerTodosContactos()` - Listar todos
   - `eliminarContacto()` - Eliminar contacto

6. **ValoracionDAO.java**
   - `insertarValoracion()` - Crear valoración
   - `obtenerValoracionPorId()` - Buscar por ID
   - `obtenerValoracionesPorEmpresa()` - Buscar por empresa
   - `obtenerValoracionesPorUsuario()` - Buscar por usuario
   - `obtenerPromedioValoraciones()` - Calcular promedio
   - `obtenerTodasValoraciones()` - Listar todas
   - `eliminarValoracion()` - Eliminar valoración

## 🌐 CONEXIÓN CON API

### Cliente y Servicio de API
**Ubicación:** `app/src/main/java/com/example/basededatos/`

1. **ApiClient.java**
   - Configuración de Retrofit
   - Método `getClient()` - Obtener instancia de Retrofit
   - Método `getApiService()` - Obtener servicio API
   - URL base configurada (actualizar según tu API)

2. **ApiService.java**
   - Interfaz con todos los endpoints
   - Endpoints para Usuarios, Empresas, Productos, Categorias, Contactos, Valoraciones
   - Métodos GET, POST, PUT, DELETE

### Modelos de Datos para API
**Ubicación:** `app/src/main/java/com/example/basededatos/`

1. **Usuario.java** - Modelo Usuario con anotaciones Gson
2. **Empresa.java** - Modelo Empresa con anotaciones Gson
3. **Producto.java** - Modelo Producto con anotaciones Gson
4. **Categoria.java** - Modelo Categoria con anotaciones Gson
5. **Contacto.java** - Modelo Contacto con anotaciones Gson
6. **Valoracion.java** - Modelo Valoracion con anotaciones Gson

## 🖥️ INTERFAZ DE USUARIO

### Actividad Principal
**Archivo:** `app/src/main/java/com/example/basededatos/MainActivity.java`
- Inicialización de base de datos
- Botones para probar SQLite y API
- Método `probarOperacionesSQLite()` - Ejecuta todas las operaciones CRUD
- Método `probarConexionAPI()` - Prueba conexión con API
- Manejo de resultados y errores

### Layout de la Interfaz
**Archivo:** `app/src/main/res/layout/activity_main.xml`
- Botón "Probar Operaciones SQLite (CRUD)"
- Botón "Probar Conexión con API"
- TextView para mostrar resultados
- ScrollView para resultados largos

## ⚙️ CONFIGURACIÓN

### Dependencias
**Archivo:** `gradle/libs.versions.toml`
- Versiones de Retrofit, Gson, AndroidX
- Configuración de librerías

**Archivo:** `app/build.gradle.kts`
- Implementación de dependencias
- Configuración de compilación

### Permisos
**Archivo:** `app/src/main/AndroidManifest.xml`
- Permiso `INTERNET` (línea 5)
- Permiso `ACCESS_NETWORK_STATE` (línea 6)

### Base de Datos
**Archivo:** `app/src/main/java/com/example/basededatos/DBSalar.java`
- Nombre de BD: "Salar.db"
- Versión: 3
- Tablas creadas en `onCreate()`

## 📸 EVIDENCIAS

### Métodos SQLite
**Ubicación:** Todas las clases DAO en `app/src/main/java/com/example/basededatos/`
- Cada DAO contiene métodos CRUD completos
- Se pueden ver en: UsuarioDAO, EmpresaDAO, ProductoDAO, CategoriaDAO, ContactoDAO, ValoracionDAO

### Conexión API
**Ubicación:** 
- `app/src/main/java/com/example/basededatos/ApiClient.java` - Configuración
- `app/src/main/java/com/example/basededatos/ApiService.java` - Endpoints
- `app/src/main/java/com/example/basededatos/MainActivity.java` - Uso en línea 140-170

### Ejecución
**Ubicación:** `app/src/main/java/com/example/basededatos/MainActivity.java`
- Método `probarOperacionesSQLite()` - Líneas 60-130
- Método `probarConexionAPI()` - Líneas 132-170
- Los resultados se muestran en el TextView `tvResultado`

## 📂 ESTRUCTURA COMPLETA DE ARCHIVOS

```
app/src/main/java/com/example/basededatos/
├── DBSalar.java              (Helper BD)
├── MainActivity.java          (Actividad principal)
├── UsuarioDAO.java            (CRUD Usuarios)
├── EmpresaDAO.java            (CRUD Empresas)
├── ProductoDAO.java           (CRUD Productos)
├── CategoriaDAO.java          (CRUD Categorias)
├── ContactoDAO.java           (CRUD Contactos)
├── ValoracionDAO.java         (CRUD Valoraciones)
├── ApiClient.java             (Cliente Retrofit)
├── ApiService.java            (Interfaz API)
├── Usuario.java               (Modelo API)
├── Empresa.java               (Modelo API)
├── Producto.java               (Modelo API)
├── Categoria.java             (Modelo API)
├── Contacto.java              (Modelo API)
└── Valoracion.java            (Modelo API)

app/src/main/res/
└── layout/
    └── activity_main.xml      (Interfaz UI)

app/src/main/
└── AndroidManifest.xml        (Permisos y configuración)

gradle/
└── libs.versions.toml         (Dependencias)

README.md                      (Documentación principal)
UBICACION_COMPONENTES.md      (Este archivo)
```

## 🔍 CÓMO PROBAR

1. **Probar SQLite:**
   - Abrir `MainActivity.java`
   - Presionar botón "Probar Operaciones SQLite"
   - Ver resultados en `tvResultado`

2. **Probar API:**
   - Abrir `MainActivity.java`
   - Presionar botón "Probar Conexión con API"
   - Ver resultados en `tvResultado`
   - Revisar Logcat para detalles

3. **Ver Métodos CRUD:**
   - Abrir cualquier archivo `*DAO.java`
   - Ver métodos públicos disponibles

4. **Ver Configuración API:**
   - Abrir `ApiClient.java` - Ver URL base
   - Abrir `ApiService.java` - Ver endpoints disponibles

