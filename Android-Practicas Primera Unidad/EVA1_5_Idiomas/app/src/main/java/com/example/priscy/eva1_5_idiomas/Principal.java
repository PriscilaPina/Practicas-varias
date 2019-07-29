package com.example.priscy.eva1_5_idiomas;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;

public class Principal extends AppCompatActivity implements RadioGroup.OnCheckedChangeListener{
    TextView lblEdad,lblNom,lblApe;
    EditText txtEdad,txtNom,txtApe;
    RadioGroup rdGrpIdi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);
        //Conexion
        txtNom=(EditText)findViewById(R.id.txtNom);
        txtApe=(EditText)findViewById(R.id.txtApe);
        txtEdad=(EditText)findViewById(R.id.txtEdad);
        lblNom=(TextView) findViewById(R.id.lblNom);
        lblApe=(TextView)findViewById(R.id.lblApe);
        lblEdad=(TextView)findViewById(R.id.lblEdad);
        rdGrpIdi=(RadioGroup) findViewById(R.id.rdGrpIdi);
        rdGrpIdi.setOnCheckedChangeListener(this);
        txtNom.setText(R.string.Nombre);
    }

    @Override
    public void onCheckedChanged(RadioGroup radioGroup, int i) {

    }
}
