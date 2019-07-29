package com.example.temporal2.eva3_6_concurrenciapost;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Principal extends AppCompatActivity {
    TextView msg1;
    Handler manejador = new Handler();
    Runnable rnForeGround = new Runnable() {
        @Override
        public void run() {
            msg1.append("Hola Mundo");
        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);
        msg1=(TextView)findViewById(R.id.msg1);

        //Runnable 1= No interactua con UI
        Runnable rnBackGround = new Runnable() {
            @Override
            public void run() {
                for(int i=0; i<20;i++){
                    manejador.post(rnForeGround);
                    try{
                        Thread.sleep(500);
                    }
                    catch(Exception e){
                        e.printStackTrace();
                    }
                }

            }
        };
        //Runable 2= Interactua con la UI
        Thread th =new Thread(rnBackGround);
        th.start();

    }
}
