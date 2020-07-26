package com.example.petagramapp;

import java.util.ArrayList;

public interface IPetagramFragmentView {


    public void linearlayout ();

    public  MascotaAdap crearAdaptador (ArrayList<MascotaDet> mascotas);

    public void inicializarAdaptador(MascotaAdap adap);
}
