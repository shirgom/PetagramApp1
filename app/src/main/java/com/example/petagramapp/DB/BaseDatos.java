package com.example.petagramapp.DB;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.petagramapp.MascotaDet;

import java.util.ArrayList;

public class BaseDatos extends SQLiteOpenHelper {

    private Context context;

    public BaseDatos(Context context) {
        super(context, ConstantesBD.DBName, null, ConstantesBD.DBVersion);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String queryCrearTablaContacto = "CREATE TABLE " + ConstantesBD.TABLE_PETS + "(" +
                ConstantesBD.TABLE_PETS_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                ConstantesBD.TABLE_PETS_NOMBRE + " TEXT, " +
                ConstantesBD.TABLE_PETS_TELEFONO + " TEXT, " +
                ConstantesBD.TABLE_PETS_EMAIL + " TEXT, " +
                ConstantesBD.TABLE_PETS_FOTO + " INTEGER" +
                ")";
        String queryCrearTablaLikesContacto = "CREATE TABLE " + ConstantesBD.TABLE_LIKES_PETS + "(" +
                ConstantesBD.TABLE_LIKES_PETS_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                ConstantesBD.TABLE_LIKES_PETS_ID_PETS + " INTEGER, " +
                ConstantesBD.TABLE_LIKES_PETS_NUMERO_LIKES + " INTEGER, " +
                "FOREIGN KEY (" + ConstantesBD.TABLE_LIKES_PETS_ID_PETS + ") " +
                "REFERENCES " + ConstantesBD.TABLE_PETS + "(" + ConstantesBD.TABLE_PETS_ID + ")" +
                ")";

        db.execSQL(queryCrearTablaContacto);
        db.execSQL(queryCrearTablaLikesContacto);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + ConstantesBD.TABLE_PETS);
        db.execSQL("DROP TABLE IF EXISTS " + ConstantesBD.TABLE_LIKES_PETS);
        onCreate(db);
    }

    public ArrayList<MascotaDet> obtenerTodosLosContactos() {
        ArrayList<MascotaDet> contactos = new ArrayList<>();

        String query = "SELECT * FROM " + ConstantesBD.TABLE_PETS;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor registros = db.rawQuery(query, null);

        while (registros.moveToNext()){
            MascotaDet mascotaActual = new MascotaDet();
            mascotaActual.setId(registros.getInt(0));
            mascotaActual.setNombre(registros.getString(1));
            mascotaActual.setTelefono(registros.getString(2));
            mascotaActual.setEmail(registros.getString(3));
            mascotaActual.setFoto(registros.getInt(4));

            String queryLikes = "SELECT COUNT("+ConstantesBD.TABLE_LIKES_PETS_NUMERO_LIKES+") as likes " +
                    " FROM " + ConstantesBD.TABLE_LIKES_PETS +
                    " WHERE " + ConstantesBD.TABLE_LIKES_PETS_ID_PETS + "=" + mascotaActual.getId();

            Cursor registrosLikes = db.rawQuery(queryLikes, null);
            if (registrosLikes.moveToNext()){
                mascotaActual.setLikes(registrosLikes.getInt(0));
            }else {
                mascotaActual.setLikes(0);
            }

            contactos.add(mascotaActual);

        }

        db.close();

        return contactos;
    }

    public void insertarContacto(ContentValues contentValues){
        SQLiteDatabase db = this.getWritableDatabase();
        db.insert(ConstantesBD.TABLE_PETS,null, contentValues);
        db.close();
    }

    public void insertarLikeContacto(ContentValues contentValues){
        SQLiteDatabase db = this.getWritableDatabase();
        db.insert(ConstantesBD.TABLE_LIKES_PETS, null, contentValues);
        db.close();
    }


    public int obtenerLikesContacto(MascotaDet mascotaDet){
        int likes = 0;

        String query = "SELECT COUNT("+ConstantesBD.TABLE_LIKES_PETS_NUMERO_LIKES+")" +
                " FROM " + ConstantesBD.TABLE_LIKES_PETS +
                " WHERE " + ConstantesBD.TABLE_LIKES_PETS_ID_PETS + "="+mascotaDet.getId();

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor registros = db.rawQuery(query, null);

        if (registros.moveToNext()){
            likes = registros.getInt(0);
        }

        db.close();

        return likes;
    }
}
