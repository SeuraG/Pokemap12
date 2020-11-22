package com.pokemaps.pokemap;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;

import com.pokemaps.pokemap.adapter.AdaptadorPokemones;
import com.pokemaps.pokemap.model.Pokemones;

import java.util.ArrayList;

public class Perfil extends AppCompatActivity {

    private Spinner sp_pokemon;
    private AdaptadorPokemones adapterPokemon;
    private ArrayList<Pokemones> listapokemon;
    private ImageView fondo;
    private Button etdora;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.perfil);

        sp_pokemon = (Spinner) findViewById(R.id.item);
        fondo=(ImageView)findViewById(R.id.fondo);
        etdora=(Button)findViewById(R.id.btnchica);
        etdora.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fondo.setImageResource(R.drawable.entrenadora);
            }
        });

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
    public void mieventochico(View view){
        fondo.setImageResource(R.drawable.entrenador);
    }

}



