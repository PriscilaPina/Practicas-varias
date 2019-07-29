package com.example.priscy.eva1_3_eventos;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.VectorEnabledTintResources;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class Principal extends AppCompatActivity
implements View.OnClickListener {
    Button btnListen, btnAnon;
    TextView txtImp;

       @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);
        btnListen = (Button)findViewById(R.id.btnListen);
        btnAnon = (Button)findViewById(R.id.btnAnon);
        txtImp=(TextView) findViewById(R.id.txtImp);
        btnListen.setOnClickListener(this);
        btnAnon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Toast.makeText(this, "evento propio (click1)", Toast.LENGTH_LONG).show();
                txtImp.setText("Evento Clase Anonima");
            }
        });
    }
    public void Clic (View v){

        Toast.makeText(this, "Evento Propio (clic 1)", Toast.LENGTH_LONG).show();
    }
    public void Clic1 (View v){

        Toast.makeText(this, "Evento Propio <clic 2>", Toast.LENGTH_LONG).show();
    }    @Override
    public void onClick(View view) {
        Toast.makeText(this, "Evento Listener ", Toast.LENGTH_LONG).show();

    }
}
