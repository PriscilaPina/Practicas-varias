package com.example.temporal2.eva3_8_asynktask;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class Principal extends AppCompatActivity {
    TextView lblMostrar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);
        lblMostrar=(TextView)findViewById(R.id.lblMostrar);
        miClase miTask= new miClase();
        miTask.execute(15);



    }

    class miClase extends AsyncTask <Integer,Integer,Void> {
        @Override
        protected void onPreExecute() {//aqui si se puede modificar la UI
            super.onPreExecute();
            lblMostrar.append("Inicio");
            lblMostrar.append("\n");
        }

        //Equivale al Run de Thread
        @Override
        protected Void doInBackground(Integer... integers) {//No puede modificar la UI
            if (integers.length > 0) {
                int Val = integers[0];//Es recomendable verificar la longitud del arreglo
                for (int i = 1; i <= Val; i++) {
                    try{
                        Thread.sleep(1000);
                    }catch(Exception e){
                        e.printStackTrace();
                    }
                    Log.e("DO IN BACKGROUND ", "i= " + i);
                    publishProgress(i);
                }
            }
            return null;
        }

        @Override
        protected void onProgressUpdate(Integer... values) {//Si puede modificar la UI
            super.onProgressUpdate(values);
            if (values.length > 0) {
                int Val = values[0];
                lblMostrar.append("i= " + Val);
                lblMostrar.append("\n");

            }
        }
            @Override
            protected void onPostExecute (Void aVoid){// Si puede modificar la UI
                super.onPostExecute(aVoid);
                lblMostrar.append("Fin");
            }
        }


}
