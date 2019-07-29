package com.example.temporal2.eva3_3__concurrencia_sincronizacion;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class Principal extends AppCompatActivity {
    TextView lblNom;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);
        lblNom=(TextView)findViewById(R.id.LblNom);
        // Hilo de Ejecucion
        Thread hilo = new Thread(){
            @Override
            public void run() {//Class mia y extends Thread{}
                super.run();
                int i=0;
                while (i<20){
                    Log.e("Mi Hilo", "Valor de i= " +i);
                    lblNom.setText("Valor de i= "+i);
                    i++;

                }
                try{
                    Thread.sleep(5000);

                }
                catch(Exception e){
                    e.printStackTrace();

                }
            }
        };
        hilo.start();
    }
}
