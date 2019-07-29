package com.example.practica4.practica4;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.TextView;

import java.util.StringTokenizer;

public class MainActivity extends AppCompatActivity {



    EditText texto;
    TextView lblPalabas,lblErrores;
    ContadorDePalabras contador;
    ContadorDeErrores errores;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        texto=(EditText)findViewById(R.id.etTexto);
        lblErrores=(TextView)findViewById(R.id.tvErrores);
        lblPalabas=(TextView)findViewById(R.id.tvPalabras);


        texto.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                contador=new ContadorDePalabras();
                contador.execute(texto.getText().toString());
                errores=new ContadorDeErrores();
                errores.execute(texto.getText().toString());
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

    }

    class ContadorDePalabras extends AsyncTask<String,Integer,Void>{

        @Override
        protected Void doInBackground(String... params) {
            String cadena=params[0];
            int contador= cadena.split("\\s+|\n|,").length;
            publishProgress(contador);
            return null;
        }

        @Override
        protected void onProgressUpdate(Integer... values) {
            lblPalabas.setText(values[0].intValue()+"");
        }

    }

    class ContadorDeErrores extends AsyncTask<String,Integer,Void>{

        @Override
        protected Void doInBackground(String... params) {
            String cadena=params[0];

            StringTokenizer palabras=new StringTokenizer(cadena);//Cuenta el numero de palabras
            int errores=0;
            while(palabras.hasMoreTokens()){
                String palabra=palabras.nextToken();
                if(palabra.length()>3) {
                    if (palabra.charAt(palabra.length() - 1) == 'n' && palabra.charAt(palabra.length() - 2) == 'o' &&
                            palabra.charAt(palabra.length() - 3) == 'i' && palabra.charAt(palabra.length() - 4) == 'c') {
                        errores++;
                    }
                }
            }

            publishProgress(errores);
            return null;
        }

        @Override
        protected void onProgressUpdate(Integer... values) {
            lblErrores.setText(values[0].intValue()+"");
        }

    }

}
