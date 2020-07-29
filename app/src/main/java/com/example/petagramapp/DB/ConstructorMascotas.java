package com.example.petagramapp.DB;

import android.content.ContentValues;
import android.content.Context;

import com.example.petagramapp.MascotaDet;
import com.example.petagramapp.R;

import java.util.ArrayList;

public class ConstructorMascotas {

    private static final int LIKE = 1;
    private Context context;
    public ConstructorMascotas(Context context) {
        this.context = context;
    }

    public ArrayList<MascotaDet> obtenerDatos() {
        BaseDatos db = new BaseDatos(context);
        insertarTresContactos(db);
        return  db.obtenerTodosLosContactos();
    }



    public void insertarTresContactos(BaseDatos db){

        ContentValues contentValues = new ContentValues();
        contentValues.put(ConstantesBD.TABLE_PETS_NOMBRE, "Toby");
        contentValues.put(ConstantesBD.TABLE_PETS_TELEFONO, "77779999");
        contentValues.put(ConstantesBD.TABLE_PETS_EMAIL, "t@gmail.com");
        contentValues.put(ConstantesBD.TABLE_PETS_FOTO, R.drawable.p1);

        db.insertarContacto(contentValues);

        contentValues = new ContentValues();
        contentValues.put(ConstantesBD.TABLE_PETS_NOMBRE, "Motas");
        contentValues.put(ConstantesBD.TABLE_PETS_TELEFONO, "88882222");
        contentValues.put(ConstantesBD.TABLE_PETS_EMAIL, "p@gmail.com");
        contentValues.put(ConstantesBD.TABLE_PETS_FOTO, R.drawable.p2);

        db.insertarContacto(contentValues);

        contentValues = new ContentValues();
        contentValues.put(ConstantesBD.TABLE_PETS_NOMBRE, "Lupe");
        contentValues.put(ConstantesBD.TABLE_PETS_TELEFONO, "33331111");
        contentValues.put(ConstantesBD.TABLE_PETS_EMAIL, "m@gmail.com");
        contentValues.put(ConstantesBD.TABLE_PETS_FOTO, R.drawable.p3);

        db.insertarContacto(contentValues);

        contentValues = new ContentValues();
        contentValues.put(ConstantesBD.TABLE_PETS_NOMBRE, "Romeo");
        contentValues.put(ConstantesBD.TABLE_PETS_TELEFONO, "33331111");
        contentValues.put(ConstantesBD.TABLE_PETS_EMAIL, "r@gmail.com");
        contentValues.put(ConstantesBD.TABLE_PETS_FOTO, R.drawable.p4);

        db.insertarContacto(contentValues);

        contentValues = new ContentValues();
        contentValues.put(ConstantesBD.TABLE_PETS_NOMBRE, "Aria");
        contentValues.put(ConstantesBD.TABLE_PETS_TELEFONO, "33331111");
        contentValues.put(ConstantesBD.TABLE_PETS_EMAIL, "a@gmail.com");
        contentValues.put(ConstantesBD.TABLE_PETS_FOTO, R.drawable.p5);

        db.insertarContacto(contentValues);

        contentValues = new ContentValues();
        contentValues.put(ConstantesBD.TABLE_PETS_NOMBRE, "Jack");
        contentValues.put(ConstantesBD.TABLE_PETS_TELEFONO, "33331111");
        contentValues.put(ConstantesBD.TABLE_PETS_EMAIL, "j@gmail.com");
        contentValues.put(ConstantesBD.TABLE_PETS_FOTO, R.drawable.p6);

        db.insertarContacto(contentValues);
    }

    public void darLikeCotnacto(MascotaDet mascotaDet){
        BaseDatos db = new BaseDatos(context);
        ContentValues contentValues = new ContentValues();
        contentValues.put(ConstantesBD.TABLE_LIKES_PETS_ID_PETS, mascotaDet.getId());
        contentValues.put(ConstantesBD.TABLE_LIKES_PETS_NUMERO_LIKES, LIKE);

        db.insertarLikeContacto(contentValues);
    }

    public int obtenerLikesContacto(MascotaDet mascotaDet){
        BaseDatos db = new BaseDatos(context);
        return db.obtenerLikesContacto(mascotaDet);
    }

    public void darLikefavorito (MascotaDet mascotaDet){
        BaseDatos db = new BaseDatos(context);
        ContentValues contentValues = new ContentValues();
        contentValues.put(ConstantesBD.TABLE_PETS_ID_F, mascotaDet.getId());
        contentValues.put(ConstantesBD.TABLE_PETS_NOMBRE_F , mascotaDet.getNombre());
        contentValues.put(ConstantesBD.TABLE_PETS_TELEFONO_F , mascotaDet.getTelefono());
        contentValues.put(ConstantesBD.TABLE_PETS_EMAIL_F , mascotaDet.getEmail());
        contentValues.put(ConstantesBD.TABLE_PETS_FOTO_F , mascotaDet.getFoto());
        contentValues.put(ConstantesBD.TABLE_PETS_NUMERO_LIKES,0);
        db.insertarFavoritos(contentValues);
    }

}
