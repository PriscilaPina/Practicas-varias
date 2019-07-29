package com.example.eduardo.a3ra_eva_14_servicios3;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Principal extends AppCompatActivity {
TextView lbl1;
    BroadcastReceiver bcrEscuchar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);
        lbl1=(TextView)findViewById(R.id.lbl1);
        IntentFilter ifFiltro = new IntentFilter("Mi_servicio");
        bcrEscuchar = new MiBroadCastReceiver();
        registerReceiver(bcrEscuchar,ifFiltro);
    }
    public class MiBroadCastReceiver extends BroadcastReceiver{

        @Override
        public void onReceive(Context context, Intent intent) {
            String sCAde = intent.getStringExtra("misdatos");
            lbl1.append(sCAde);
            lbl1.append("\n");

        }
    }
}
