package com.example.temporal2.eva3_4_concurrencia_handlemessage;

import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ProgressBar;
import android.widget.TextView;

public class Principal extends AppCompatActivity {
    TextView lblEtiq;
    ProgressBar pbBarra;
     Handler Manejador = new Handler() {
        /*@Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            String Cad = (String) msg.obj;
            lblEtiq.append(Cad);
            lblEtiq.append("\n");
            pbBarra.incrementProgressBy(1);
        }
    };*/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);
        pbBarra = (ProgressBar) findViewById(R.id.pbBarra);
        pbBarra.getProgress();
        lblEtiq = (TextView) findViewById(R.id.lblEtiq);

        final Runnable Hilo = new Runnable() {
            @Override
            public void run() {
                int i = 0;
                while (i < 20) {
                    Log.e("Hilo", "I= " + i);
                    Message Datos = Manejador.obtainMessage(1, "I= " + i);
                    Manejador.sendMessage(Datos);
                    //lblEtiq.setText("i= "+i);


                    try {
                        Thread.sleep(5000);
                    } catch (Exception e) {
                        e.printStackTrace();

                    }
                    i++;
                }
            };


            Thread miHilo = new Thread(Hilo);
            miHilo.start();



    }
}