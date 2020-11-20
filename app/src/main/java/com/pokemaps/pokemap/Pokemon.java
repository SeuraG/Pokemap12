package com.pokemaps.pokemap;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class Pokemon extends AppCompatActivity {

    private RecyclerView recyclerViewPokemon;
    private  RecyclerViewAdaptador adaptadorPokemon;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pokemonfull);

        recyclerViewPokemon=(RecyclerView)findViewById(R.id.recyclerPokemon);
        recyclerViewPokemon.setLayoutManager(new LinearLayoutManager(this));

        adaptadorPokemon=new RecyclerViewAdaptador(obtenerPokemones());
        recyclerViewPokemon.setAdapter(adaptadorPokemon);
    }

    public List<PokemonModelo> obtenerPokemones(){
        List<PokemonModelo> pokemon=new ArrayList<>();
        pokemon.add(new PokemonModelo("Bulbasaur","Tipo Planta",R.drawable.bulbasaur));
        pokemon.add(new PokemonModelo("Charmander","Tipo Fuego",R.drawable.charmander));
        pokemon.add(new PokemonModelo("Pikachu","Tipo Electrico",R.drawable.pikachu));
        pokemon.add(new PokemonModelo("Squirtle","Tipo Agua",R.drawable.squirtle));
        return pokemon;
    }

}