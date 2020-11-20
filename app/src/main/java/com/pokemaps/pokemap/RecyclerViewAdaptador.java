package com.pokemaps.pokemap;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class RecyclerViewAdaptador extends RecyclerView.Adapter<RecyclerViewAdaptador.ViewHolder> {

    public static class ViewHolder extends RecyclerView.ViewHolder{
        private TextView pokemon,descripcion;
        ImageView fotopokemon;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            pokemon=(TextView)itemView.findViewById(R.id.fvpokemon);
            descripcion=(TextView)itemView.findViewById(R.id.fvDescripcion);
            fotopokemon=(ImageView) itemView.findViewById(R.id.imgPokemon);
        }
    }
    public List<PokemonModelo> pokemonLista;

    public RecyclerViewAdaptador(List<PokemonModelo> pokemonLista) {
        this.pokemonLista = pokemonLista;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.item_pokemon,parent,false);
        ViewHolder viewHolder=new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.pokemon.setText(pokemonLista.get(position).getPokemon());
        holder.descripcion.setText(pokemonLista.get(position).getDescripcion());
        holder.fotopokemon.setImageResource(pokemonLista.get(position).getImgPokemon());
    }

    @Override
    public int getItemCount() {
        return pokemonLista.size();
    }
}