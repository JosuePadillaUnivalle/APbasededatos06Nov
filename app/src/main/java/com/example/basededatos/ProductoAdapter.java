package com.example.basededatos;

import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.text.DecimalFormat;

public class ProductoAdapter extends RecyclerView.Adapter<ProductoAdapter.ProductoViewHolder> {
    
    private Cursor cursor;
    private DecimalFormat df = new DecimalFormat("#.##");
    
    public ProductoAdapter(Cursor cursor) {
        this.cursor = cursor;
    }
    
    @NonNull
    @Override
    public ProductoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_producto, parent, false);
        return new ProductoViewHolder(view);
    }
    
    @Override
    public void onBindViewHolder(@NonNull ProductoViewHolder holder, int position) {
        if (cursor != null && cursor.moveToPosition(position)) {
            String nombre = cursor.getString(2); // nombre
            String descripcion = cursor.getString(3); // descripcion
            double precio = cursor.getDouble(4); // precio
            String categoria = cursor.getString(5); // categoria
            String estado = cursor.getString(6); // estado
            
            holder.tvNombre.setText(nombre);
            holder.tvDescripcion.setText(descripcion != null ? descripcion : "Sin descripción");
            holder.tvPrecio.setText("$" + df.format(precio));
            holder.tvCategoria.setText(categoria != null ? categoria : "Sin categoría");
            holder.tvEstado.setText(estado != null ? estado : "activo");
            
            // Cambiar color según estado
            int colorRes = estado != null && estado.equals("activo") 
                    ? android.R.color.holo_green_dark 
                    : android.R.color.holo_red_dark;
            holder.tvEstado.setBackgroundColor(holder.itemView.getContext().getResources().getColor(colorRes));
        }
    }
    
    @Override
    public int getItemCount() {
        return cursor != null ? cursor.getCount() : 0;
    }
    
    public void swapCursor(Cursor newCursor) {
        if (cursor != null) {
            cursor.close();
        }
        cursor = newCursor;
        notifyDataSetChanged();
    }
    
    static class ProductoViewHolder extends RecyclerView.ViewHolder {
        TextView tvNombre, tvDescripcion, tvPrecio, tvCategoria, tvEstado;
        
        ProductoViewHolder(@NonNull View itemView) {
            super(itemView);
            tvNombre = itemView.findViewById(R.id.tvNombreProducto);
            tvDescripcion = itemView.findViewById(R.id.tvDescripcionProducto);
            tvPrecio = itemView.findViewById(R.id.tvPrecioProducto);
            tvCategoria = itemView.findViewById(R.id.tvCategoriaProducto);
            tvEstado = itemView.findViewById(R.id.tvEstadoProducto);
        }
    }
}

