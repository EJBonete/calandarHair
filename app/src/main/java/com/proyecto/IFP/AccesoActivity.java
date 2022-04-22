package com.proyecto.IFP;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class AccesoActivity extends AppCompatActivity {


    protected Button boton1; // hoy
    protected Button boton2; // todas
    protected Button boton3; // Nueva cita
    private Intent pasarPantalla;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_acceso);

        boton1= (Button) findViewById(R.id.button1_acceso);
        boton2= (Button) findViewById(R.id.button2_acceso);
        boton3= (Button) findViewById(R.id.button3_acceso);

        boton1.setOnClickListener(new View.OnClickListener() {  // HOY
            @Override
            public void onClick(View view) {
                pasarPantalla = new Intent(AccesoActivity.this, DiasActivoActivity.class);
                finish();
                startActivity(pasarPantalla);
            }
        });



        boton2.setOnClickListener(new View.OnClickListener() {  // Todas
            @Override
            public void onClick(View view) {
                pasarPantalla = new Intent(AccesoActivity.this, TodasActivity.class);
                finish();
                startActivity(pasarPantalla);
            }
        });

        boton3.setOnClickListener(new View.OnClickListener() {  // Proximas
            @Override
            public void onClick(View view) {
                pasarPantalla = new Intent(AccesoActivity.this, NuevaCitaActivity.class);
                finish();
                startActivity(pasarPantalla);
            }
        });



    }

}