package com.example.temporal2.eva3_5_handlemessage;

import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

public class principal extends AppCompatActivity {

    ImageView imImagen;
    int cont=1;
    Handler Manejador= new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            //Aqui procesamos los mensajes
            switch (cont){
                case 1:
                    imImagen.setImageResource(R.drawable.f1);
                    break;
                case 2:
                    imImagen.setImageResource(R.drawable.f2);
                    break;
                case 3:
                    imImagen.setImageResource(R.drawable.f3);
                    break;

            }

            if(cont < 3)
                cont++;
            else
                cont =1;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);
        imImagen=(ImageView)findViewById(R.id.imImagen);

        //Hilo de Ejecucion
        Runnable hilo=new Runnable() {
            @Override
            public void run() {
                while(true){
                    Message msg = Manejador.obtainMessage();
                    Manejador.sendMessage(msg);
                    try{
                        Thread.sleep(1500);
                    }
                    catch(Exception e){
                        e.printStackTrace();
                    }
                }

            }
        };
        Thread thHilo= new Thread(hilo);
        thHilo.start();
    }
}
