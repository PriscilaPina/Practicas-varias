package com.example.temporal2.eva3_1_concurrencia_threads;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

public class Principal extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);
        //
       Runnable rnHilo =new Runnable() {
           @Override
           public void run(){
               try{
                   int i=0;

                   while(i<10) {
                       Log.e("Principal", "Hola");
                       Thread.sleep(500);
                       i++;

                   }
               }
               catch (Exception e){
                   e.printStackTrace();
               }
           }


       };
        Thread thHilo = new Thread(rnHilo);
        thHilo.start();
    }

    public void onClick(View view) {
        Toast.makeText(this, "Hola Mundo", Toast.LENGTH_SHORT).show();
    }
}

