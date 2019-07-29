package com.example.priscy.eva1_prac1_cafeteria;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class Principal extends AppCompatActivity  {

    EditText txtCant;
    RadioButton rdAme, rdCapu, rdExpr;
    CheckBox cBxAzu, cBxCre;
    TextView lblPed;
    Button btnTot;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Mostrar la interfaz grafica
        setContentView(R.layout.activity_principal);
        //Conectar
        txtCant=(EditText) findViewById(R.id.txtCant);
        rdAme= (RadioButton) findViewById(R.id.rdAme);
        rdCapu= (RadioButton) findViewById(R.id.rdCapu);
        rdExpr= (RadioButton) findViewById(R.id.rdExpr);
        lblPed=(TextView) findViewById(R.id.lblPed);
        cBxAzu=(CheckBox) findViewById(R.id.cBxAzu);
        cBxCre=(CheckBox) findViewById(R.id.cBxCre);
        btnTot=(Button) findViewById(R.id.btnTot);
    }
    public void click(View e) {
        //Leer Texto
        String tipC="", Az, Cr;
        int cof=0, azu, cre,c;
        c = Integer.parseInt(txtCant.getText().toString());
        if (rdAme.isChecked()) {
            cof = 20;
            tipC ="Americano";
        } else if (rdCapu.isChecked()) {
            cof = 48;
            tipC = "Capuchino";
        } else if (rdExpr.isChecked()) {
            cof = 30;
            tipC = "Expresso";
        }

        if (cBxAzu.isChecked()) {
            azu = 1;
            Az = "Azucar";
        } else {
            azu = 0;
            Az="";
        }

        if (cBxCre.isChecked()) {
            cre = 1;
            Cr = "Crema";
        } else {
            cre = 0;
            Cr="";
        }
        lblPed.setText("Descripcion de la compra: " + tipC+", "+Az+", "+Cr);
        Toast.makeText(this,"$ "+(c*( cof + azu + cre)), Toast.LENGTH_LONG).show();

    }


}




