package com.example.temporal2.eva3_13_servicios2;

import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Principal extends AppCompatActivity {
    Intent Serv;
    ComponentName cnServ;
    TextView lblSer;
    BroadcastReceiver Escucha;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);
        lblSer=(TextView) findViewById(R.id.lblSer);

        Serv= new Intent(this, Servicio.class);
        cnServ =startService(Serv); // invocamos el servicio
        // Crear un hilo para distinguir que servicio se comunica
        IntentFilter Filtro = new IntentFilter("SERVICIO");
        Escucha=new miBroadcast();
        registerReceiver(Escucha, Filtro);

    }


    public void onClick(View view){
        try {
            stopService(Serv);
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public class miBroadcast extends BroadcastReceiver{
        @Override
        public void onReceive(Context context, Intent intent) {
            String Text = intent.getStringExtra("Datos");
            lblSer.append(Text);
            lblSer.append("\n");

        }
    }
}