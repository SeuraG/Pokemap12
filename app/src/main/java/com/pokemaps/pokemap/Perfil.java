package com.pokemaps.pokemap;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Spinner;

import com.pokemaps.pokemap.adapter.AdaptadorPokemones;
import com.pokemaps.pokemap.model.Pokemones;

import java.util.ArrayList;

public class Perfil extends AppCompatActivity {

    private Spinner sp_pokemon;
    private Pokemones objpokemon;
    private AdaptadorPokemones adapterPokemon;
    private ArrayList<Pokemones> listapokemon;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.perfil);

        sp_pokemon = (Spinner) findViewById(R.id.item);

        cargarSpinnerPokemones();
        adapterPokemon = new AdaptadorPokemones(this, listapokemon);
        sp_pokemon.setAdapter(adapterPokemon);
    }
    public  void cargarSpinnerPokemones()
    {
        listapokemon = new ArrayList<>();
        listapokemon.add(new Pokemones("Bulbasaur",R.drawable.bulbasaur));
        listapokemon.add(new Pokemones("Charmander",R.drawable.charmander));
        listapokemon.add(new Pokemones("Pikachu",R.drawable.pikachu));
        listapokemon.add(new Pokemones("Squirtle",R.drawable.squirtle));
    }
}



