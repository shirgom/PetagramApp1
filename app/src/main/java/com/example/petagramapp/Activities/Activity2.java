package com.example.petagramapp.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.petagramapp.Adaptador.MascotaAdap;
import com.example.petagramapp.DB.BaseDatos;
import com.example.petagramapp.Modelo.MascotaDet;
import com.example.petagramapp.R;

import java.util.ArrayList;

public class Activity2 extends AppCompatActivity {

    ArrayList<MascotaDet> mascotas;
    private RecyclerView ListaFavoritos;
    private MascotaAdap mascotaAdap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);

        Toolbar toolbar= (Toolbar)findViewById(R.id.miab);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setIcon(R.mipmap.ic_launcher);

        ListaFavoritos= (RecyclerView) findViewById(R.id.rvfavoritos);
        LinearLayoutManager llm= new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        ListaFavoritos.setLayoutManager(llm);

        BaseDatos db= new BaseDatos(getApplicationContext());
        mascotaAdap = new MascotaAdap(db.mostrardatos(), this);
        ListaFavoritos.setAdapter(mascotaAdap);
        //IniciarLista();
        //IniciarAdap();
    }

    /*public void IniciarAdap (){

        MascotaAdap adap= new MascotaAdap(mascotas,this);
        ListaFavoritos.setAdapter(adap);

    }

    public void  IniciarLista (){

        mascotas = new ArrayList<MascotaDet>();

        mascotas.add(new MascotaDet("Toby", "320456", "shir@icloud.com", R.drawable.p1,5));
        mascotas.add(new MascotaDet("Motas", "320455", "stell@icloud.com", R.drawable.p2,4 ));
        mascotas.add(new MascotaDet("Lupe", "320236", "luis@icloud.com",R.drawable.p3,4));
        mascotas.add(new MascotaDet("Romeo", "324366", "vivi@icloud.com", R.drawable.p4,3));
        mascotas.add(new MascotaDet("Aria", "320678", "fabi@icloud.com",R.drawable.p5,2));



    }*/
}