package com.example.basededatos;

import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class EmpresaAdapter extends RecyclerView.Adapter<EmpresaAdapter.EmpresaViewHolder> {
    
    private Cursor cursor;
    
    public EmpresaAdapter(Cursor cursor) {
        this.cursor = cursor;
    }
    
    @NonNull
    @Override
    public EmpresaViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_empresa, parent, false);
        return new EmpresaViewHolder(view);
    }
    
    @Override
    public void onBindViewHolder(@NonNull EmpresaViewHolder holder, int position) {
        if (cursor != null && cursor.moveToPosition(position)) {
            String nombre = cursor.getString(2); // nombre
            String descripcion = cursor.getString(3); // descripcion
            String telefono = cursor.getString(4); // telefono
            String ubicacion = cursor.getString(5); // ubicacion
            
            holder.tvNombre.setText(nombre);
            holder.tvDescripcion.setText(descripcion != null ? descripcion : "Sin descripción");
            holder.tvTelefono.setText(telefono != null ? "📞 " + telefono : "📞 No disponible");
            holder.tvUbicacion.setText(ubicacion != null ? "📍 " + ubicacion : "📍 No disponible");
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
    
    static class EmpresaViewHolder extends RecyclerView.ViewHolder {
        TextView tvNombre, tvDescripcion, tvTelefono, tvUbicacion;
        
        EmpresaViewHolder(@NonNull View itemView) {
            super(itemView);
            tvNombre = itemView.findViewById(R.id.tvNombreEmpresa);
            tvDescripcion = itemView.findViewById(R.id.tvDescripcionEmpresa);
            tvTelefono = itemView.findViewById(R.id.tvTelefonoEmpresa);
            tvUbicacion = itemView.findViewById(R.id.tvUbicacionEmpresa);
        }
    }
}

