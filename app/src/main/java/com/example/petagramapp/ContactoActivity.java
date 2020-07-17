package com.example.petagramapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;


import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;




public class ContactoActivity extends AppCompatActivity {



    public EditText nombre;
    public EditText mail;
    public EditText mensaje;
    public Button enviar;

    //String correo;
    //String contraseña;
    javax.mail.Session session;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contacto);

        Toolbar toolbar= (Toolbar)findViewById(R.id.miab);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setIcon(R.mipmap.ic_launcher);



        nombre = (EditText) findViewById(R.id.campo_nombre);
        mail = (EditText)findViewById(R.id.campo_correo);
        mensaje = (EditText)findViewById(R.id.campo_mensaje);
        enviar = (Button) findViewById(R.id.enviar);

        enviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sendMail();
            }
        });
    }

    private void sendMail() {

        String email = mail.getText().toString().trim();
        String message = mensaje.getText().toString();
        String name = nombre.getText().toString().trim();

        //Send Mail
        JavaMailAPI javaMailAPI = new JavaMailAPI(this,email,name,message);

        javaMailAPI.execute();

    }


    }

