package com.proyecto.IFP;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class AccesoActivity extends AppCompatActivity {


    protected Button boton1; // loguin
    protected Button boton2; // registro
    private Intent pasarPantalla;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_acceso);
    }

}