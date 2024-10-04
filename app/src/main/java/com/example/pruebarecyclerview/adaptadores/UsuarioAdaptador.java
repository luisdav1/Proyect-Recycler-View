package com.example.pruebarecyclerview.adaptadores;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.pruebarecyclerview.CharacterDetailActivity;
import com.example.pruebarecyclerview.R;
import com.example.pruebarecyclerview.clases.Character;
import com.squareup.picasso.Picasso;

import java.util.List;

public class UsuarioAdaptador extends RecyclerView.Adapter<UsuarioAdaptador.ViewHolder> {

    private List<Character> datos;

    public UsuarioAdaptador(List<Character> datos){
        this.datos = datos;
    }

    @NonNull
    @Override
    public UsuarioAdaptador.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_usuario,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull UsuarioAdaptador.ViewHolder holder, int position) {
        Character dato = datos.get(position);
        holder.bind(dato);

        holder.itemView.setOnClickListener(v -> {
            Intent intent = new Intent(v.getContext(), CharacterDetailActivity.class);
            intent.putExtra("character",dato);
            v.getContext().startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        return datos.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{
        TextView txt_nombre_usuario,txt_curso_usuario;
        ImageView img_usuario;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            txt_nombre_usuario = itemView.findViewById(R.id.txt_nombre_usuario);
            txt_curso_usuario = itemView.findViewById(R.id.txt_curso_usuario);
            img_usuario = itemView.findViewById(R.id.img_usuario);
        }

        public void bind(Character dato){
            txt_nombre_usuario.setText(dato.getName());
            txt_curso_usuario.setText(dato.getGender());
            //imagen libreria
            Picasso.get().load(dato.getImage()).into(img_usuario);
        }
    }

}
