package com.example.priscy.eva1_4_radiogroup;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class Principal extends AppCompatActivity
        implements RadioGroup.OnCheckedChangeListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);
        //Conexion
        RadioGroup rdGrpColor;
        //RadioButton rdBtnVer,rdBtnNar,rdBtnAzu,rdBtnRoj,rdBtnMor;
        rdGrpColor=(RadioGroup)findViewById(R.id.rdGrpColor);
        rdGrpColor.setOnCheckedChangeListener(this);

    }

    @Override
    public void onCheckedChanged(RadioGroup radioGroup, int i) {


        if (i==R.id.rdBtnVer) {
            Toast.makeText(this, "Verde", Toast.LENGTH_LONG).show();
        } else if (i==R.id.rdBtnAzu){
            Toast.makeText(this, "Azul", Toast.LENGTH_LONG).show();
        }else if (i==R.id.rdBtnNar){
            Toast.makeText(this, "Naranja", Toast.LENGTH_LONG).show();
        }else if (i==R.id.rdBtnRoj){
            Toast.makeText(this, "Rojo", Toast.LENGTH_LONG).show();
        }else if (i==R.id.rdBtnMor){
            Toast.makeText(this, "Morado", Toast.LENGTH_LONG).show();
        }
    }
}
