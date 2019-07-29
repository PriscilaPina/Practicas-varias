package com.example.temporal2.eva3_7_concurrenciapostbanner;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

public class Principal extends AppCompatActivity {

    ImageView imagen;
    int cont=1;
    Handler manejador = new Handler();
    Runnable rnForeGround =new Runnable() {
        @Override
        public void run() {

            switch (cont){
                case 1:
                    imagen.setImageResource(R.drawable.f1);
                    break;
                case 2:
                    imagen.setImageResource(R.drawable.f2);
                    break;
                case 3:
                    imagen.setImageResource(R.drawable.f3);
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
        imagen=(ImageView)findViewById(R.id.imagen);
       Runnable rnBackGround = new Runnable() {
           @Override
           public void run() {

               while(true){
                  manejador.post(rnForeGround);
                   try{
                       Thread.sleep(1500);
                   }
                   catch(Exception e){
                       e.printStackTrace();
                   }
               }


           }
       };
        Thread thHilo= new Thread(rnBackGround);
        thHilo.start();
    }
}
