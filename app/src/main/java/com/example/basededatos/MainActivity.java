package com.example.basededatos;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    
    private static final String TAG = "MainActivity";
    private DBSalar dbHelper;
    private SQLiteDatabase db;
    private TextView tvResultado;
    private Button btnTestSQLite, btnTestAPI;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        
        // Inicializar base de datos
        dbHelper = new DBSalar(this);
        db = dbHelper.getWritableDatabase();
        
        // Inicializar vistas
        tvResultado = findViewById(R.id.tvResultado);
        btnTestSQLite = findViewById(R.id.btnTestSQLite);
        btnTestAPI = findViewById(R.id.btnTestAPI);
        
        // Botón para probar operaciones SQLite
        btnTestSQLite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                probarOperacionesSQLite();
            }
        });
        
        // Botón para probar conexión API
        btnTestAPI.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                probarConexionAPI();
            }
        });
    }
    
    private void probarOperacionesSQLite() {
        StringBuilder resultado = new StringBuilder();
        resultado.append("=== PRUEBAS SQLite ===\n\n");
        
        try {
            // Crear instancias de DAO
            UsuarioDAO usuarioDAO = new UsuarioDAO(db);
            EmpresaDAO empresaDAO = new EmpresaDAO(db);
            ProductoDAO productoDAO = new ProductoDAO(db);
            CategoriaDAO categoriaDAO = new CategoriaDAO(db);
            ContactoDAO contactoDAO = new ContactoDAO(db);
            ValoracionDAO valoracionDAO = new ValoracionDAO(db);
            
            // 1. Insertar usuario
            long idUsuario = usuarioDAO.insertarUsuario("Juan Pérez", "juan@email.com", "123456", "cliente");
            resultado.append("✓ Usuario insertado - ID: ").append(idUsuario).append("\n");
            
            // 2. Insertar empresa
            long idEmpresa = empresaDAO.insertarEmpresa((int)idUsuario, "Mi Empresa", "Descripción de la empresa", "123456789", "Cali, Colombia");
            resultado.append("✓ Empresa insertada - ID: ").append(idEmpresa).append("\n");
            
            // 3. Insertar categoría
            long idCategoria = categoriaDAO.insertarCategoria("Electrónica");
            resultado.append("✓ Categoría insertada - ID: ").append(idCategoria).append("\n");
            
            // 4. Insertar producto
            long idProducto = productoDAO.insertarProducto((int)idEmpresa, "Producto Test", "Descripción del producto", 99.99, "Electrónica", "activo");
            resultado.append("✓ Producto insertado - ID: ").append(idProducto).append("\n");
            
            // 5. Insertar contacto
            long idContacto = contactoDAO.insertarContacto((int)idUsuario, (int)idEmpresa, "Mensaje de prueba");
            resultado.append("✓ Contacto insertado - ID: ").append(idContacto).append("\n");
            
            // 6. Insertar valoración
            long idValoracion = valoracionDAO.insertarValoracion((int)idUsuario, (int)idEmpresa, 5, "Excelente servicio");
            resultado.append("✓ Valoración insertada - ID: ").append(idValoracion).append("\n");
            
            // 7. Consultar usuarios
            Cursor cursorUsuarios = usuarioDAO.obtenerTodosUsuarios();
            resultado.append("\n=== Usuarios en BD ===\n");
            while (cursorUsuarios.moveToNext()) {
                resultado.append("ID: ").append(cursorUsuarios.getInt(0))
                        .append(", Nombre: ").append(cursorUsuarios.getString(1))
                        .append(", Email: ").append(cursorUsuarios.getString(2))
                        .append(", Rol: ").append(cursorUsuarios.getString(4)).append("\n");
            }
            cursorUsuarios.close();
            
            // 8. Consultar empresas
            Cursor cursorEmpresas = empresaDAO.obtenerTodasEmpresas();
            resultado.append("\n=== Empresas en BD ===\n");
            while (cursorEmpresas.moveToNext()) {
                resultado.append("ID: ").append(cursorEmpresas.getInt(0))
                        .append(", Nombre: ").append(cursorEmpresas.getString(2))
                        .append(", Teléfono: ").append(cursorEmpresas.getString(4)).append("\n");
            }
            cursorEmpresas.close();
            
            // 9. Consultar productos
            Cursor cursorProductos = productoDAO.obtenerTodosProductos();
            resultado.append("\n=== Productos en BD ===\n");
            while (cursorProductos.moveToNext()) {
                resultado.append("ID: ").append(cursorProductos.getInt(0))
                        .append(", Nombre: ").append(cursorProductos.getString(2))
                        .append(", Precio: $").append(cursorProductos.getDouble(4)).append("\n");
            }
            cursorProductos.close();
            
            resultado.append("\n✓ Todas las operaciones SQLite completadas exitosamente!");
            
        } catch (Exception e) {
            resultado.append("\n✗ Error: ").append(e.getMessage());
            Log.e(TAG, "Error en operaciones SQLite", e);
        }
        
        tvResultado.setText(resultado.toString());
        Toast.makeText(this, "Operaciones SQLite completadas", Toast.LENGTH_SHORT).show();
    }
    
    private void probarConexionAPI() {
        tvResultado.setText("Conectando con API...");
        
        ApiService apiService = ApiClient.getApiService();
        
        // Probar obtener usuarios (usando JSONPlaceholder como ejemplo)
        Call<List<Usuario>> call = apiService.obtenerUsuarios();
        
        call.enqueue(new Callback<List<Usuario>>() {
            @Override
            public void onResponse(Call<List<Usuario>> call, Response<List<Usuario>> response) {
                if (response.isSuccessful() && response.body() != null) {
                    StringBuilder resultado = new StringBuilder();
                    resultado.append("=== CONEXIÓN API EXITOSA ===\n\n");
                    resultado.append("Respuesta recibida: ").append(response.body().size()).append(" elementos\n");
                    resultado.append("Código HTTP: ").append(response.code()).append("\n");
                    resultado.append("\n✓ La conexión con la API funciona correctamente!");
                    
                    tvResultado.setText(resultado.toString());
                    Toast.makeText(MainActivity.this, "Conexión API exitosa", Toast.LENGTH_SHORT).show();
                    Log.d(TAG, "API Response: " + response.body().size() + " items");
                } else {
                    tvResultado.setText("Error en respuesta API: " + response.code());
                    Toast.makeText(MainActivity.this, "Error en API", Toast.LENGTH_SHORT).show();
                }
            }
            
            @Override
            public void onFailure(Call<List<Usuario>> call, Throwable t) {
                String error = "Error de conexión API: " + t.getMessage();
                tvResultado.setText(error);
                Toast.makeText(MainActivity.this, "Error de conexión", Toast.LENGTH_SHORT).show();
                Log.e(TAG, "API Error", t);
            }
        });
    }
    
    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (db != null) {
            db.close();
        }
        if (dbHelper != null) {
            dbHelper.close();
        }
    }
}
