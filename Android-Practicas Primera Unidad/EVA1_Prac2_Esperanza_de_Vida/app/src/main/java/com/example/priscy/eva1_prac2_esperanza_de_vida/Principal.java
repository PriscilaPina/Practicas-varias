package com.example.priscy.eva1_prac2_esperanza_de_vida;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class Principal extends AppCompatActivity {

    EditText etEdad=(EditText)findViewById(R.id.txtNac);
    RadioButton rdRegDes=(RadioButton)findViewById(R.id.rdRegDes);
    RadioButton rdAmeLat=(RadioButton)findViewById(R.id.rdAmeLat);
    RadioButton rdAsi=(RadioButton)findViewById(R.id.rdAsi);
    RadioButton rdAfr=(RadioButton)findViewById(R.id.rdAfr);

    RadioButton rdHom=(RadioButton)findViewById(R.id.rdHom);
    RadioButton rdMuj=(RadioButton)findViewById(R.id.rdMuj);

    int fecha =Integer.parseInt(etEdad.getText().toString());
                            //true hombre false mujer
    int aux=0;int aux2=0; boolean genero=false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);
    }

    public void rbRegionClick(View view){

        boolean checked = ((RadioButton) view).isChecked();

        if(fecha>1949 && fecha<1961){
           switch(view.getId()) {
                case R.id.rdRegDes:
                    if (checked)
                            aux=75;
                        break;
                case R.id.rdAmeLat:
                    if (checked)
                        aux=60;
                        break;

                case R.id.rdAsi:
                    if (checked)
                        aux=45;
                        break;
                case R.id.rdAfr:
                    if (checked)
                        aux=35;
                        break;
           }
        }


        if(fecha>1959 && fecha<1971){
            switch(view.getId()) {
                case R.id.rdRegDes:
                    if (checked)
                        aux=75;
                    break;
                case R.id.rdAmeLat:
                    if (checked)
                        aux=65;
                    break;

                case R.id.rdAsi:
                    if (checked)
                        aux=50;
                    break;
                case R.id.rdAfr:
                    if (checked)
                        aux=45;
                    break;
            }
        }

        if(fecha>1969 && fecha<1981){
            switch(view.getId()) {
                case R.id.rdRegDes:
                    if (checked)
                        aux=80;
                    break;
                case R.id.rdAmeLat:
                    if (checked)
                        aux=70;
                    break;

                case R.id.rdAsi:
                    if (checked)
                        aux=65;
                    break;
                case R.id.rdAfr:
                    if (checked)
                        aux=55;
                    break;
            }
        }

        if(fecha>1989 && fecha<2000){
            switch(view.getId()) {
                case R.id.rdRegDes:
                    if (checked)
                        aux=85;
                    break;
                case R.id.rdAmeLat:
                    if (checked)
                        aux=75;
                    break;

                case R.id.rdAsi:
                    if (checked)
                        aux=60;
                    break;
                case R.id.rdAfr:
                    if (checked)
                        aux=55;
                    break;
            }
        }

        if(fecha>1999 && fecha<2011){
            switch(view.getId()) {
                case R.id.rdRegDes:
                    if (checked)
                        aux=90;
                    break;
                case R.id.rdAmeLat:
                    if (checked)
                        aux=70;
                    break;

                case R.id.rdAsi:
                    if (checked)
                        aux=65;
                    break;
                case R.id.rdAfr:
                    if (checked)
                        aux=60;
                    break;
            }
        }
        calcular();
    }

    public void rbGeneroClick(View view){

        boolean checked = ((RadioButton) view).isChecked();

        if(fecha>1949 && fecha<1961){
            aux2=10;
            switch(view.getId()) {
                case R.id.rdHom:
                    if (checked)
                        genero=true;
                    break;
                case R.id.rdMuj:
                    if (checked)
                        genero=false;
                    break;
            }
        }


        if(fecha>1959 && fecha<1971){
            aux2=9;
            switch(view.getId()) {
                case R.id.rdHom:
                    if (checked)
                        genero=true;
                    break;
                case R.id.rdMuj:
                    if (checked)
                        genero=false;
                    break;
            }
            }


        if(fecha>1969 && fecha<1981){
            aux2=8;
            switch(view.getId()) {
                case R.id.rdHom:
                    if (checked)
                        genero=true;
                    break;
                case R.id.rdMuj:
                    if (checked)
                        genero=false;
                    break;
            }
            }


        if(fecha>1989 && fecha<2000){
            aux2=7;
            switch(view.getId()) {
                case R.id.rdHom:
                    if (checked)
                        genero=true;
                    break;
                case R.id.rdMuj:
                    if (checked)
                        genero=false;
                    break;
            }
        }

        if(fecha>1999 && fecha<2011){
            aux2=6;
            switch(view.getId()) {
                case R.id.rdHom:
                    if (checked)
                        genero=true;
                    break;
                case R.id.rdMuj:
                    if (checked)
                        genero=false;
                    break;
            }
        }
        calcular();
    }


        public void calcular(){

            int resultado=fecha+aux;
            resultado=genero==true? resultado-(aux2/2):resultado+(aux2/2);
        }

    }
}
