package com.example.basededatos;

import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class UsuarioAdapter extends RecyclerView.Adapter<UsuarioAdapter.UsuarioViewHolder> {
    
    private Cursor cursor;
    
    public UsuarioAdapter(Cursor cursor) {
        this.cursor = cursor;
    }
    
    @NonNull
    @Override
    public UsuarioViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_usuario, parent, false);
        return new UsuarioViewHolder(view);
    }
    
    @Override
    public void onBindViewHolder(@NonNull UsuarioViewHolder holder, int position) {
        if (cursor != null && cursor.moveToPosition(position)) {
            String nombre = cursor.getString(1); // nombre
            String email = cursor.getString(2); // email
            String rol = cursor.getString(4); // rol
            
            holder.tvNombre.setText(nombre);
            holder.tvEmail.setText(email);
            holder.tvRol.setText(rol);
            
            // Cambiar color según el rol
            int colorRes;
            switch (rol.toLowerCase()) {
                case "admin":
                    colorRes = android.R.color.holo_red_dark;
                    break;
                case "empresa":
                    colorRes = android.R.color.holo_blue_dark;
                    break;
                default:
                    colorRes = android.R.color.holo_green_dark;
            }
            holder.tvRol.setBackgroundColor(holder.itemView.getContext().getResources().getColor(colorRes));
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
    
    static class UsuarioViewHolder extends RecyclerView.ViewHolder {
        TextView tvNombre, tvEmail, tvRol;
        
        UsuarioViewHolder(@NonNull View itemView) {
            super(itemView);
            tvNombre = itemView.findViewById(R.id.tvNombreUsuario);
            tvEmail = itemView.findViewById(R.id.tvEmailUsuario);
            tvRol = itemView.findViewById(R.id.tvRolUsuario);
        }
    }
}

