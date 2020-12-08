package com.pokemaps.pokemap.model;

public class Ubicacion {
    private String Nombre;
    private String pUbicacion;
    private String Ciudad;
    private String Nickname;

    public Ubicacion(){}
    public Ubicacion(String nombre, String ubicacion, String ciudad, String nickname) {
        this.Nombre = nombre;
        this.pUbicacion = ubicacion ;
        this.Ciudad = ciudad;
        this.Nickname = nickname;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public String getpUbicacion() {
        return pUbicacion;
    }

    public void setpUbicacion(String ubicacion) {
        pUbicacion = ubicacion;
    }

    public String getCiudad() {
        return Ciudad;
    }

    public void setCiudad(String ciudad) {
        Ciudad = ciudad;
    }

    public String getNickname() {
        return Nickname;
    }

    public void setNickname(String nickname) {
        this.Nickname = nickname;
    }


}

