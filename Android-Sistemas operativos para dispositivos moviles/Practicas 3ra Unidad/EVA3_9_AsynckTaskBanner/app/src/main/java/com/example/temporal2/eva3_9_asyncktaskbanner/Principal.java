package com.example.temporal2.eva3_9_asyncktaskbanner;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;

public class Principal extends AppCompatActivity {
    ImageView Imagen;
    int cont =1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);
        Imagen=(ImageView)findViewById(R.id.Imagen);
        miClase miTask= new miClase();
        miTask.execute(3);

    }
    class miClase extends AsyncTask <Integer,Integer,Void> {
        @Override
        protected void onPreExecute() {//aqui si se puede modificar la UI
            super.onPreExecute();
            Imagen.setImageResource(R.drawable.f1);
        }

        //Equivale al Run de Thread
        @Override
        protected Void doInBackground(Integer... integers) {//No puede modificar la UI
            if (integers.length > 0) {
                int Val = integers[0];//Es recomendable verificar la longitud del arreglo
                while (true) {
                    try{
                        Thread.sleep(1000);
                    }catch(Exception e){
                        e.printStackTrace();
                    }
                }
            }
            return null;
        }

        @Override
        protected void onProgressUpdate(Integer... values) {//Si puede modificar la UI
            super.onProgressUpdate(values);
            switch (cont){
                case 1:
                    Imagen.setImageResource(R.drawable.f1);
                    break;
                case 2:
                    Imagen.setImageResource(R.drawable.f2);
                    break;
                case 3:
                    Imagen.setImageResource(R.drawable.f3);
                    break;

            }

            if(cont < 3)
                cont++;
            else
                cont =1;

        }
    };


        }


