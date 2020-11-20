package com.pokemaps.pokemap.model;

public class Pokemones
{
    private String nombre_pokemon;
    private int imagen_pokemon;

    public Pokemones(String nombre_pokemon, int imagen_pokemon) {
        this.nombre_pokemon = nombre_pokemon;
        this.imagen_pokemon = imagen_pokemon;
    }

    public String getNombre_pokemon() {
        return nombre_pokemon;
    }

    public void setNombre_pokemon(String nombre_pokemon) {
        this.nombre_pokemon = nombre_pokemon;
    }

    public int getImagen_pokemon() {
        return imagen_pokemon;
    }

    public void setImagen_pokemon(int imagen_pokemon) {
        this.imagen_pokemon = imagen_pokemon;
    }
}
