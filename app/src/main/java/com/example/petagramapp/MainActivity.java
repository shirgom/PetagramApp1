package com.example.petagramapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.example.petagramapp.Activities.AboutActivity;
import com.example.petagramapp.Activities.Activity2;
import com.example.petagramapp.Activities.ContactoActivity;
import com.example.petagramapp.Adaptador.PageAdapter;
import com.example.petagramapp.Modelo.MascotaDet;
import com.example.petagramapp.Vista.Mascotaperfil;
import com.example.petagramapp.Vista.PetagramFragment;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity  {

    ArrayList <MascotaDet> mascotas;
    private RecyclerView ListaMascotas;
    private Toolbar toolbar;
    private TabLayout tabLayout;
    private ViewPager viewPager;

    //
    Mascotaperfil mascotaperfil;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar=(Toolbar) findViewById(R.id.toolbar);
        tabLayout= (TabLayout) findViewById(R.id.tablayout);
        viewPager= (ViewPager) findViewById(R.id.viewp);
        setupViewPager();


        /*Toolbar toolbar= (Toolbar)findViewById(R.id.miab);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setIcon(R.mipmap.ic_launcher);

        ListaMascotas= (RecyclerView) findViewById(R.id.rvmascotas);

        LinearLayoutManager llm= new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        //GridLayoutManager glm= new GridLayoutManager(this,2);
        ListaMascotas.setLayoutManager(llm);
        IniciarLista();
        IniciarAdap(); */

        /*ListView listView =(ListView) findViewById(R.id.lvcontactos);
        listView.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, nombrescontacto));

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                Intent intent =new Intent(MainActivity.this, DetalleContacto.class);
                intent.putExtra("name",contactos.get(i).getNombre());
                intent.putExtra("tel",contactos.get(i).getTelefono());
                intent.putExtra("mail",contactos.get(i).getEmail());
                startActivity(intent);

            }
        });
*/
        if (toolbar !=null){
            setSupportActionBar(toolbar);
        }

    }

    //Metodo para poner en orbita los fragments

    private ArrayList <Fragment> agregarfragments (){

        ArrayList <Fragment> fragments =new ArrayList<>();
        fragments.add(new PetagramFragment());
        fragments.add(new Mascotaperfil());
        return fragments;
    }

    private void setupViewPager (){
        viewPager.setAdapter(new PageAdapter(getSupportFragmentManager(), agregarfragments()));
        tabLayout.setupWithViewPager(viewPager);
        tabLayout.getTabAt(0).setIcon(R.drawable.ic_action_name);
        tabLayout.getTabAt(1).setIcon(R.drawable.ic_puppy);
    }

    //actionview

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.action_view, menu);
        return true;
    }


    @Override
    public boolean onOptionsItemSelected (MenuItem item) {

        switch ((item.getItemId())){

            case R.id.mcontacto:
                Intent intent= new Intent(this, ContactoActivity.class);
                startActivity(intent);
                break;

            case R.id.macerca:
                Intent intent2= new Intent(this, AboutActivity.class);
                startActivity(intent2);
                break;

            case R.id.mstar:
                Intent intent1= new Intent(this, Activity2.class);
                startActivity(intent1);
                break;
        }
        return super.onOptionsItemSelected(item);
    }

}
