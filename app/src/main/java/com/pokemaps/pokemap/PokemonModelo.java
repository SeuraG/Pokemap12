package com.pokemaps.pokemap;

public class PokemonModelo {
    private String pokemon,descripcion;
    private int imgPokemon;

    public PokemonModelo() {
    }

    public PokemonModelo(String pokemon, String descripcion, int imgPokemon) {
        this.pokemon = pokemon;
        this.descripcion = descripcion;
        this.imgPokemon = imgPokemon;
    }

    public String getPokemon() {
        return pokemon;
    }

    public void setPokemon(String pokemon) {
        this.pokemon = pokemon;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getImgPokemon() {
        return imgPokemon;
    }

    public void setImgPokemon(int imgPokemon) {
        this.imgPokemon = imgPokemon;
    }
}
