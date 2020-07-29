package com.example.petagramapp;


import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.petagramapp.DB.ConstructorMascotas;

import java.util.ArrayList;


public class MascotaAdap extends RecyclerView.Adapter <MascotaAdap.MascotasViewHolder> {

    ArrayList <MascotaDet> mascotas;
    ArrayList<MascotaDet> mostrardatos;
    Activity activity;


    public MascotaAdap(ArrayList<MascotaDet> mascotas, Activity activity){
        this.mascotas = mascotas;
        this.activity =activity;
    }

    


    @NonNull
    @Override
    //Inflar el layout y pasarlo al viewholder para obtener los views
    public MascotasViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview,parent,false);
        return new MascotasViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull final MascotasViewHolder mascotasViewHolder, int position) { //asignar items de la lista


        final MascotaDet mascotaDet= mascotas.get(position);
        mascotasViewHolder.foto.setImageResource(mascotaDet.getFoto());
        mascotasViewHolder.tvnameCV.setText(mascotaDet.getNombre());
        mascotasViewHolder.tvlikes.setText(String.valueOf(mascotaDet.getLikes()) + " " + activity.getString(R.string.likes));



        mascotasViewHolder.btnlike.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(activity, "Diste like a: " +mascotaDet.getNombre(), Toast.LENGTH_SHORT).show();

                ConstructorMascotas constructporContactos= new ConstructorMascotas(activity);
                constructporContactos.darLikeCotnacto(mascotaDet);
                mascotasViewHolder.tvlikes.setText(constructporContactos.obtenerLikesContacto(mascotaDet) + " " + activity.getString(R.string.likes));
                constructporContactos.darLikefavorito(mascotaDet);
                Toast.makeText(activity, "SE AGREGÓ CORRECTAMENTE", Toast.LENGTH_LONG).show();

            }
        });
    }

    @Override
    public int getItemCount() { //Cantidad de elementos que contiene la lista
        return mascotas.size();

    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
    }

    public static class MascotasViewHolder extends RecyclerView.ViewHolder{

        private ImageView foto;
        private TextView tvnameCV;
        private ImageButton btnlike;
        private TextView tvlikes;



        public MascotasViewHolder(@NonNull View itemView) {
            super(itemView);

            foto=(ImageView)itemView.findViewById(R.id.foto);
            tvnameCV= (TextView) itemView.findViewById(R.id.tvnameCV);
            btnlike =(ImageButton) itemView.findViewById(R.id.btnlike);
            tvlikes= (TextView) itemView.findViewById(R.id.tvlikes);


        }
    }

    /*public void guardardatos (View v){
        BaseDatos2 db= new BaseDatos2(activity,"admin",null, 1);
        SQLiteDatabase BaseDatos= db.getWritableDatabase();
        String nombre=



    }*/

}