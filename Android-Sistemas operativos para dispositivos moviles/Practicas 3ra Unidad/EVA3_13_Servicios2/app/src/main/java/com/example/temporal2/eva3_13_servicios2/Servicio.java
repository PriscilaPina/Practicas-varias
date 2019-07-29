package com.example.temporal2.eva3_13_servicios2;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

public class Servicio extends Service {
    Intent Ser;
    boolean bBande;
    public Servicio() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public void onStart(Intent intent, int startId) {
        super.onStart(intent, startId);
        Thread Hilo =new Thread(){

        };

        Ser.putExtra("SERVICIO","OnStart");
        Log.e("SERVICIO","Aqui se realiza alguna tarea");

    }

    @Override
    public void onDestroy() {//Un servicio se destruye solo una vez
        super.onDestroy();
        Log.e("SERVICIO","Destruido");
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Log.e("SERVICIO","Creado");
    }

}