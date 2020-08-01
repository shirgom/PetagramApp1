package com.example.petagramapp.Vista;

import com.example.petagramapp.Adaptador.MascotaAdap;
import com.example.petagramapp.Modelo.MascotaDet;

import java.util.ArrayList;

public interface IPetagramFragmentView {


    public void linearlayout ();

    public MascotaAdap crearAdaptador (ArrayList<MascotaDet> mascotas);

    public void inicializarAdaptador(MascotaAdap adap);
}
