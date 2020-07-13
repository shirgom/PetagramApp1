package com.example.petagramapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {

    ArrayList <MascotaDet> mascotas;
    private RecyclerView ListaMascotas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar= (Toolbar)findViewById(R.id.miab);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setIcon(R.mipmap.ic_launcher);

        ListaMascotas= (RecyclerView) findViewById(R.id.rvmascotas);

        LinearLayoutManager llm= new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        //GridLayoutManager glm= new GridLayoutManager(this,2);
        ListaMascotas.setLayoutManager(llm);
        IniciarLista();
        IniciarAdap();

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
            case R.id.mstar:
                Intent intent= new Intent(this, Activity2.class);
                startActivity(intent);
                break;
        }
        return super.onOptionsItemSelected(item);
    }




    public void IniciarAdap (){

        MascotaAdap adap= new MascotaAdap(mascotas,this);
        ListaMascotas.setAdapter(adap);

    }

    public void  IniciarLista (){

        mascotas = new ArrayList<MascotaDet>();

        mascotas.add(new MascotaDet("Toby", "320456", "shir@icloud.com", R.drawable.p1));
        mascotas.add(new MascotaDet("Motas", "320455", "stell@icloud.com", R.drawable.p2 ));
        mascotas.add(new MascotaDet("Lupe", "320236", "luis@icloud.com",R.drawable.p3));
        mascotas.add(new MascotaDet("Romeo", "324366", "vivi@icloud.com", R.drawable.p4));
        mascotas.add(new MascotaDet("Aria", "320678", "fabi@icloud.com",R.drawable.p5));
        mascotas.add(new MascotaDet("Jack", "320653", "jack@icloud.com",R.drawable.p6));


    }

}
