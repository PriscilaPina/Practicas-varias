package com.example.temporal2.eva3_2_concurrencia_runnables;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class Principal extends AppCompatActivity {

    TextView lblWorld;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);
        lblWorld=(TextView) findViewById(R.id.lblWorld);

        miThread objeto= new miThread();
        objeto.start();
    }


class miThread extends Thread{
    @Override
    public void run() {
        super.run();
        try{
            for (int i=0 ;i<20;i++) {
                lblWorld.setText( "valor de i= "+i);
                Thread.sleep(500);

            }
        }
        catch (Exception e){
            e.printStackTrace();
        }

    }
}
}
