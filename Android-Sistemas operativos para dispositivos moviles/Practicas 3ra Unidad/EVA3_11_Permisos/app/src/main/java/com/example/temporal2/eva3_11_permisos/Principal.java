package com.example.temporal2.eva3_11_permisos;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.security.Permission;

public class Principal extends AppCompatActivity {
    Intent inMarcar;
    TextView lblTel;
    EditText txtTel;
    final static int miPermiso=1;
    boolean Bande =false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);
        lblTel= (TextView)findViewById(R.id.lblTel);
        txtTel=(EditText)findViewById(R.id.txtTel);
        //Verificar permisos
        if (ContextCompat.checkSelfPermission(this,
                Manifest.permission.CALL_PHONE)
                != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this,
                    new String[]{Manifest.permission.CALL_PHONE},
                    miPermiso);
        }


        }
    public void Marcar(View view) {
        if (Bande) {


        String Tel = "tel:" + txtTel.getText().toString();
        inMarcar = new Intent(Intent.ACTION_CALL, Uri.parse(Tel));
        startActivity(inMarcar);
    }else {
            Toast.makeText(this,"No tienes permisos",Toast.LENGTH_LONG).show();
        }


    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        String Permiso= permissions[0];
        int Result=grantResults[0];

        if(requestCode==miPermiso){
            Toast.makeText(this,Permiso,Toast.LENGTH_SHORT).show();

        }if (Result==PackageManager.PERMISSION_GRANTED){

            Bande=true;
            Toast.makeText(this,"Permiso autorizado",Toast.LENGTH_LONG).show();
        }else{
            Toast.makeText(this,"Permiso no autorizado",Toast.LENGTH_LONG).show();
        }
    }
}
