# Sistema de Base de Datos - BaseDeDatos

Aplicación Android que implementa un sistema completo de gestión de base de datos SQLite con conexión a API REST.

## 📋 Características

- **Base de Datos SQLite** con 6 tablas relacionadas
- **Operaciones CRUD** completas para todas las entidades
- **Conexión con API REST** usando Retrofit
- **Interfaz de usuario** para probar operaciones

## 🗄️ Estructura de Base de Datos

### Tablas Implementadas

1. **Usuarios** - Gestión de usuarios con roles (cliente, empresa, admin)
2. **Empresas** - Información de empresas (relación 1:1 con Usuarios)
3. **Productos** - Catálogo de productos por empresa
4. **Categorias** - Categorización de productos
5. **Contactos** - Mensajes entre clientes y empresas
6. **Valoraciones** - Sistema de calificaciones (1-5 estrellas)

## 📁 Estructura del Proyecto

### Clases de Base de Datos (SQLite)

- `DBSalar.java` - Helper de SQLite, creación de tablas
- `UsuarioDAO.java` - Operaciones CRUD para Usuarios
- `EmpresaDAO.java` - Operaciones CRUD para Empresas
- `ProductoDAO.java` - Operaciones CRUD para Productos
- `CategoriaDAO.java` - Operaciones CRUD para Categorias
- `ContactoDAO.java` - Operaciones CRUD para Contactos
- `ValoracionDAO.java` - Operaciones CRUD para Valoraciones

**Ubicación:** `app/src/main/java/com/example/basededatos/`

### Clases de API

- `ApiClient.java` - Cliente Retrofit para conexión API
- `ApiService.java` - Interfaz con endpoints de la API
- `Usuario.java` - Modelo de datos Usuario
- `Empresa.java` - Modelo de datos Empresa
- `Producto.java` - Modelo de datos Producto
- `Categoria.java` - Modelo de datos Categoria
- `Contacto.java` - Modelo de datos Contacto
- `Valoracion.java` - Modelo de datos Valoracion

**Ubicación:** `app/src/main/java/com/example/basededatos/`

### Interfaz de Usuario

- `MainActivity.java` - Actividad principal con pruebas de CRUD y API
- `activity_main.xml` - Layout de la interfaz principal

**Ubicación:** 
- Java: `app/src/main/java/com/example/basededatos/MainActivity.java`
- XML: `app/src/main/res/layout/activity_main.xml`

## 🔧 Configuración

### Dependencias

El proyecto utiliza las siguientes dependencias (configuradas en `gradle/libs.versions.toml`):

- **Retrofit 2.9.0** - Cliente HTTP para API REST
- **Gson 2.10.1** - Serialización JSON
- **AndroidX** - Librerías de soporte

### Permisos

Los permisos de internet están configurados en `AndroidManifest.xml`:
- `INTERNET`
- `ACCESS_NETWORK_STATE`

**Ubicación:** `app/src/main/AndroidManifest.xml`

## 🚀 Uso

### Probar Operaciones SQLite

1. Abre la aplicación
2. Presiona el botón **"Probar Operaciones SQLite (CRUD)"**
3. Se ejecutarán automáticamente:
   - Inserción de datos de prueba
   - Consultas de todas las tablas
   - Visualización de resultados

### Probar Conexión API

1. Presiona el botón **"Probar Conexión con API"**
2. La aplicación intentará conectarse a la API configurada
3. Se mostrará el resultado de la conexión

**Nota:** La URL de la API está configurada en `ApiClient.java`. Actualiza `BASE_URL` con tu endpoint real.

## 📸 Evidencias

### Métodos SQLite
Los métodos CRUD están implementados en las clases DAO:
- `insertar*()` - Crear registros
- `obtener*()` - Leer registros
- `actualizar*()` - Actualizar registros
- `eliminar*()` - Eliminar registros

### Conexión API
La conexión con la API se realiza mediante:
- `ApiClient.getApiService()` - Obtener instancia del servicio
- `ApiService` - Interfaz con todos los endpoints
- Callbacks de Retrofit para manejo asíncrono

### Ejecución
La aplicación muestra resultados en tiempo real en la interfaz, incluyendo:
- Operaciones SQLite exitosas
- Datos insertados y consultados
- Estado de conexión API
- Errores si ocurren

## 🛠️ Tecnologías

- **Java** - Lenguaje de programación
- **SQLite** - Base de datos local
- **Retrofit** - Cliente HTTP
- **Gson** - Serialización JSON
- **Android SDK** - Framework de Android

## 📝 Notas

- La base de datos se crea automáticamente al iniciar la aplicación
- La versión de la BD es 3 (se actualiza automáticamente si existe una versión anterior)
- Los datos de prueba se insertan cada vez que se presiona el botón de pruebas SQLite

