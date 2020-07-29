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

    public static final String TABLE_PETS_F           = "favoritos";
    public static final String TABLE_PETS_ID_F          = "id";
    public static final String TABLE_PETS_NOMBRE_F      = "nombre";
    public static final String TABLE_PETS_TELEFONO_F    = "telefono";
    public static final String TABLE_PETS_EMAIL_F       = "email";
    public static final String TABLE_PETS_FOTO_F        = "foto";
}

