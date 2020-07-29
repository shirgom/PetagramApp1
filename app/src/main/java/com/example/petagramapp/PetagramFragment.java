package com.example.petagramapp;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import com.example.petagramapp.presentador.RecyclerPresenterC;

import java.util.ArrayList;


public class PetagramFragment extends Fragment implements IPetagramFragmentView {

    ArrayList<MascotaDet> mascotas;
    private RecyclerView ListaMascotas;
    private RecyclerPresenterC presenter;
    private ImageButton like;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v =inflater.inflate(R.layout.fragment_petagram, container, false);


        ListaMascotas= (RecyclerView) v.findViewById(R.id.rvmascotas);
        //like= (ImageButton) v.findViewById(R.id.btnlike);
        presenter= new RecyclerPresenterC(this,getContext());
        /*like.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                BaseDatos2 db = new BaseDatos2(getContext());
                db.guardardatos(mascotaDet.getNombre(),mascotaDet.getFoto());
                Toast.makeText(getContext(), "SE AGREGÓ CORRECTAMENTE", Toast.LENGTH_LONG).show();
            }
        });*/


        return v;
    }


    public void linearlayout() {
        LinearLayoutManager llm= new LinearLayoutManager(getActivity());
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        //GridLayoutManager glm= new GridLayoutManager(this,2);
        ListaMascotas.setLayoutManager(llm);

    }

    @Override
    public MascotaAdap crearAdaptador(ArrayList<MascotaDet> mascotas) {
        MascotaAdap adap= new MascotaAdap(mascotas,getActivity());
        return adap;
    }

    @Override
    public void inicializarAdaptador(MascotaAdap adap) {
        ListaMascotas.setAdapter(adap);

    }



    /*public void  IniciarLista (){

        mascotas = new ArrayList<MascotaDet>();

        mascotas.add(new MascotaDet("Toby", "320456", "shir@icloud.com", R.drawable.p1, 0));
        mascotas.add(new MascotaDet("Motas", "320455", "stell@icloud.com", R.drawable.p2 ));
        mascotas.add(new MascotaDet("Lupe", "320236", "luis@icloud.com",R.drawable.p3));
        mascotas.add(new MascotaDet("Romeo", "324366", "vivi@icloud.com", R.drawable.p4));
        mascotas.add(new MascotaDet("Aria", "320678", "fabi@icloud.com",R.drawable.p5));
        mascotas.add(new MascotaDet("Jack", "320653", "jack@icloud.com",R.drawable.p6));
*/

    }
