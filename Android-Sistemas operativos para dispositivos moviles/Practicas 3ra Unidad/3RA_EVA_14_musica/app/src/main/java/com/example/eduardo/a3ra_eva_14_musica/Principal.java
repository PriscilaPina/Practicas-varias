package com.example.eduardo.a3ra_eva_14_musica;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Principal extends AppCompatActivity {
Intent inPlay;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);
    }
    public void playmusica(View v){
        inPlay = new Intent(this,playmusic.class);
        startService(inPlay);
    }
    public void DEtenermusica(View v){
        stopService(inPlay);
    }
}
