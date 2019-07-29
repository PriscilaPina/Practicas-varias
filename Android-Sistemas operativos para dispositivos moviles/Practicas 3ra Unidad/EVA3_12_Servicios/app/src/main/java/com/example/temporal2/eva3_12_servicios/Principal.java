package com.example.temporal2.eva3_12_servicios;

import android.content.ComponentName;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Principal extends AppCompatActivity {

    Intent Serv;
    ComponentName cnServ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);
        // Aqui iniciamos el servicio

        Serv= new Intent(this, Servicio.class);
        cnServ =startService(Serv); // invocamos el servicio

    }


    public void onClick(View view){
        try {
            stopService(Serv);
        }catch(Exception e){
            e.printStackTrace();
        }

    }
}
