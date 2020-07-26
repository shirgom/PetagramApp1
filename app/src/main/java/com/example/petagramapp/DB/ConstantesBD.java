package com.example.petagramapp.DB;

public final class ConstantesBD {

    public static final String DBName = "mascotas";
    public static final int DBVersion = 1;

    public static final String TABLE_PETS           = "mascotas";
    public static final String TABLE_PETS_ID        = "id";
    public static final String TABLE_PETS_NOMBRE    = "nombre";
    public static final String TABLE_PETS_TELEFONO  = "telefono";
    public static final String TABLE_PETS_EMAIL     = "email";
    public static final String TABLE_PETS_FOTO      = "foto";

    public static final String TABLE_LIKES_PETS = "pets_likes";
    public static final String TABLE_LIKES_PETS_ID = "id";
    public static final String TABLE_LIKES_PETS_ID_PETS = "id_mascota";
    public static final String TABLE_LIKES_PETS_NUMERO_LIKES = "numero_likes";
}

