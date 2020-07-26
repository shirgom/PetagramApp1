package com.example.petagramapp;

import android.graphics.Color;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.mikhaellopez.circularimageview.CircularImageView;

import java.util.ArrayList;

public class Mascotaperfil extends Fragment {

    ArrayList<MascotaDet> mascotas;
    private RecyclerView Listafotos;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v =inflater.inflate(R.layout.fragment_mascotaperfil, container, false);



        Listafotos= (RecyclerView) v.findViewById(R.id.rvfotos);
        //LinearLayoutManager llm= new LinearLayoutManager (getActivity());
        //llm.setOrientation(LinearLayoutManager.VERTICAL);
        GridLayoutManager glm= new GridLayoutManager(getActivity(),2);
        Listafotos.setLayoutManager(glm);
        IniciarLista();
        IniciarAdap();

        return v;
    }


    public void IniciarAdap (){

        Listafotos.setLayoutManager(new LinearLayoutManager(getContext()));
        MascotaAdap adap= new MascotaAdap(mascotas,getActivity());
        Listafotos.setAdapter(adap);

    }

    public void  IniciarLista (){

        mascotas = new ArrayList<MascotaDet>();

        mascotas.add(new MascotaDet("Jack", "320456", "shir@icloud.com", R.drawable.ch1,1));
        mascotas.add(new MascotaDet("Jack", "320455", "stell@icloud.com", R.drawable.ch2,1 ));
        mascotas.add(new MascotaDet("Jack", "320236", "luis@icloud.com",R.drawable.ch3,1));
        mascotas.add(new MascotaDet("Jack", "324366", "vivi@icloud.com", R.drawable.ch4,1));



    }





    }

