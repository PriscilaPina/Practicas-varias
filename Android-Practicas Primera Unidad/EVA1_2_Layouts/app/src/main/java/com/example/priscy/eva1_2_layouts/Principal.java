package com.example.priscy.eva1_2_layouts;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class Principal extends AppCompatActivity {
    //Crear objetos para los componentes visuales
    EditText txtNom, txtApe;
    RadioButton rdbF, rdbM;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Mostrar la interfaz grafica
        setContentView(R.layout.activity_principal);
        //Conectar
        txtNom=(EditText) findViewById(R.id.txtNom);
        txtApe=(EditText) findViewById(R.id.txtApe);
        rdbF= (RadioButton) findViewById(R.id.rdbF);
        //rdbM=(RadioButton) findViewById(R.id.rdbM);
        //txtNom.setText("Priscila");
        //txtApe.setText("Piña");
    }
    public void click(View e){
        //Leer Texto
        String Nom, Ape, G;
        Nom= txtNom.getText().toString();
        Ape= txtApe.getText().toString();
        if (rdbF.isChecked())
            G="Femenino";
        else
            G="Masculino";
        Toast.makeText(this,Nom +" "+Ape+ " : "+G,Toast.LENGTH_LONG).show();
    }
}
