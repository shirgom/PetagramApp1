package com.example.petagramapp.Modelo;

import java.io.Serializable;

public class MascotaDet implements Serializable {

    private int id;
    private String nombre;
    private String telefono;
    private String email;
    private int foto;
    private int likes;

    public MascotaDet(String nombre, String telefono, String email, int foto, int likes) {
        this.nombre = nombre;
        this.telefono = telefono;
        this.email = email;
        this.foto=foto;
        this.likes= likes;

    }

    public MascotaDet() {

    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getFoto() {
        return foto;
    }

    public void setFoto(int foto) {
        this.foto = foto;
    }

    public int getLikes() {
        return likes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}