package com.example.petagramapp.presentador;

import android.content.Context;

import com.example.petagramapp.DB.ConstructorMascotas;
import com.example.petagramapp.Vista.IPetagramFragmentView;
import com.example.petagramapp.Modelo.MascotaDet;

import java.util.ArrayList;

public class RecyclerPresenterC implements RecyclerPresenter{

    private  IPetagramFragmentView iPetagramFragmentView;
    private Context context;
    private ConstructorMascotas constructorMascotas;
    private ArrayList <MascotaDet> mascotas;

    public RecyclerPresenterC(IPetagramFragmentView iPetagramFragmentView, Context context) {
        this.iPetagramFragmentView = iPetagramFragmentView;
        this.context= context;
        obtenercontactosBD();
    }

    @Override
    public void obtenercontactosBD() {
        constructorMascotas= new ConstructorMascotas(context);
        mascotas= constructorMascotas.obtenerDatos();
        mostrarcontactosenRV();

    }

    @Override
    public void mostrarcontactosenRV() {
        iPetagramFragmentView.inicializarAdaptador(iPetagramFragmentView.crearAdaptador(mascotas));
        iPetagramFragmentView.linearlayout();

    }
}