# 📸 Evidencias del Proyecto

Este documento indica dónde encontrar cada evidencia requerida.

## 🔗 1. Repositorio de GitHub

**URL:** https://github.com/JosuePadillaUnivalle/APbasededatos06Nov.git

**Contenido:**
- Todo el código fuente del proyecto
- Archivos de configuración
- Documentación completa
- README.md con instrucciones

## 💾 2. Captura de Pantalla de los Métodos de SQLite

### Ubicación de los Métodos CRUD:

**Archivos DAO (Data Access Object):**
- `app/src/main/java/com/example/basededatos/UsuarioDAO.java`
  - Líneas 15-20: `insertarUsuario()` - CREATE
  - Líneas 23-25: `obtenerUsuarioPorEmail()` - READ
  - Líneas 28-30: `obtenerUsuarioPorId()` - READ
  - Líneas 33-35: `obtenerTodosUsuarios()` - READ
  - Líneas 38-44: `actualizarUsuario()` - UPDATE
  - Líneas 47-49: `eliminarUsuario()` - DELETE

- `app/src/main/java/com/example/basededatos/EmpresaDAO.java`
  - Líneas 15-22: `insertarEmpresa()` - CREATE
  - Líneas 25-27: `obtenerEmpresaPorId()` - READ
  - Líneas 30-32: `obtenerEmpresaPorUsuario()` - READ
  - Líneas 35-37: `obtenerTodasEmpresas()` - READ
  - Líneas 40-46: `actualizarEmpresa()` - UPDATE
  - Líneas 49-51: `eliminarEmpresa()` - DELETE

- `app/src/main/java/com/example/basededatos/ProductoDAO.java`
  - Líneas 15-22: `insertarProducto()` - CREATE
  - Líneas 25-27: `obtenerProductoPorId()` - READ
  - Líneas 30-32: `obtenerProductosPorEmpresa()` - READ
  - Líneas 35-37: `obtenerProductosPorCategoria()` - READ
  - Líneas 40-42: `obtenerTodosProductos()` - READ
  - Líneas 45-51: `actualizarProducto()` - UPDATE
  - Líneas 54-56: `eliminarProducto()` - DELETE

- `app/src/main/java/com/example/basededatos/CategoriaDAO.java`
- `app/src/main/java/com/example/basededatos/ContactoDAO.java`
- `app/src/main/java/com/example/basededatos/ValoracionDAO.java`

**Uso de los Métodos en MainActivity:**
- `app/src/main/java/com/example/basededatos/MainActivity.java`
  - Líneas 74-79: Instanciación de DAOs
  - Líneas 82-103: Ejecución de operaciones CREATE (INSERT)
  - Líneas 106-134: Ejecución de operaciones READ (SELECT)
  - Los métodos UPDATE y DELETE están disponibles en cada DAO

**Para Capturar:**
1. Abrir cualquier archivo `*DAO.java` en Android Studio
2. Mostrar los métodos CRUD (Create, Read, Update, Delete)
3. Mostrar el uso en `MainActivity.java` línea 68-145

## 🌐 3. Captura de Conexión con la API

### Ubicación del Código de API:

**Cliente API:**
- `app/src/main/java/com/example/basededatos/ApiClient.java`
  - Líneas 7-8: URL base de la API
  - Líneas 10-18: Configuración de Retrofit
  - Líneas 20-23: Método para obtener servicio API

**Interfaz de Servicio:**
- `app/src/main/java/com/example/basededatos/ApiService.java`
  - Líneas 9-11: Endpoint GET usuarios
  - Líneas 13-14: Endpoint POST usuarios
  - Líneas 16-18: Endpoint GET empresas
  - Y más endpoints para todas las entidades

**Uso de la API:**
- `app/src/main/java/com/example/basededatos/MainActivity.java`
  - Líneas 147-182: Método `probarConexionAPI()`
  - Línea 150: Obtención del servicio API
  - Línea 153: Llamada a la API
  - Líneas 155-181: Callbacks de respuesta

**Para Capturar:**
1. Abrir `ApiClient.java` y `ApiService.java`
2. Mostrar la configuración de Retrofit
3. Mostrar el método `probarConexionAPI()` en MainActivity
4. Ejecutar la app y presionar "Probar Conexión con API"
5. Capturar la respuesta en el TextView o Logcat

## 🖥️ 4. Captura de la Ejecución

### Interfaz de Usuario:

**Layout Principal:**
- `app/src/main/res/layout/activity_main.xml`
  - Toolbar con título
  - Botones para operaciones SQLite
  - Botones para ver datos en RecyclerView
  - Botón para probar API
  - RecyclerView para mostrar datos
  - TextView para resultados

**Layouts de Items:**
- `app/src/main/res/layout/item_usuario.xml` - Card para usuarios
- `app/src/main/res/layout/item_empresa.xml` - Card para empresas
- `app/src/main/res/layout/item_producto.xml` - Card para productos

**Para Capturar la Ejecución:**

1. **Operaciones SQLite:**
   - Ejecutar la app
   - Presionar "Ejecutar CRUD y Mostrar Datos"
   - Capturar:
     - Los mensajes de éxito en el TextView
     - Los datos insertados y consultados
     - El Toast de confirmación

2. **RecyclerView:**
   - Después de ejecutar CRUD
   - Presionar "Ver Usuarios en RecyclerView"
   - Presionar "Ver Empresas en RecyclerView"
   - Presionar "Ver Productos en RecyclerView"
   - Capturar:
     - La lista desplegable con Material Cards
     - Los datos mostrados en cada card
     - El diseño UI/UX moderno

3. **Conexión API:**
   - Presionar "Probar Conexión con API"
   - Capturar:
     - El mensaje de conexión
     - La respuesta exitosa o error
     - El código HTTP en el TextView

## 📋 Criterios de Evaluación

### ✅ Uso de Clases
**Ubicación:**
- Clases DAO: `app/src/main/java/com/example/basededatos/*DAO.java`
- Clases Modelo: `app/src/main/java/com/example/basededatos/Usuario.java`, `Empresa.java`, etc.
- Clases Adapter: `app/src/main/java/com/example/basededatos/*Adapter.java`
- Clase Helper: `app/src/main/java/com/example/basededatos/DBSalar.java`

### ✅ Uso de SQLite de forma correcta
**Ubicación:**
- `app/src/main/java/com/example/basededatos/DBSalar.java` - Creación de tablas
- Todos los archivos `*DAO.java` - Operaciones CRUD
- `MainActivity.java` líneas 68-145 - Uso de SQLite

### ✅ Implementación de RecyclerView
**Ubicación:**
- Adaptadores: `app/src/main/java/com/example/basededatos/UsuarioAdapter.java`, `EmpresaAdapter.java`, `ProductoAdapter.java`
- Layouts: `app/src/main/res/layout/item_*.xml`
- Uso: `MainActivity.java` líneas 147-200 (métodos mostrar*EnRecyclerView)
- Layout principal: `activity_main.xml` - RecyclerView en línea 95

### ✅ Implementación de Base de Datos
**Ubicación:**
- `app/src/main/java/com/example/basededatos/DBSalar.java` - Estructura completa
- 6 tablas creadas en `onCreate()` método
- Relaciones con FOREIGN KEY implementadas
- Versión de BD: 3

### ✅ Diseño UI/UX
**Ubicación:**
- `app/src/main/res/layout/activity_main.xml` - Diseño principal con Material Design
- `app/src/main/res/layout/item_*.xml` - Cards modernos para RecyclerView
- Uso de Material Components:
  - MaterialCardView
  - MaterialButton
  - MaterialToolbar
  - AppBarLayout
  - CoordinatorLayout

## 📱 Cómo Generar las Capturas

1. **Abrir Android Studio**
2. **Ejecutar la aplicación** en un emulador o dispositivo
3. **Capturar pantalla de métodos SQLite:**
   - Abrir `UsuarioDAO.java` o cualquier DAO
   - Capturar pantalla mostrando los métodos CRUD
4. **Capturar conexión API:**
   - Presionar botón "Probar Conexión con API"
   - Capturar el resultado en el TextView
5. **Capturar ejecución:**
   - Presionar "Ejecutar CRUD y Mostrar Datos"
   - Presionar "Ver Usuarios/Empresas/Productos en RecyclerView"
   - Capturar la interfaz completa con RecyclerView funcionando

