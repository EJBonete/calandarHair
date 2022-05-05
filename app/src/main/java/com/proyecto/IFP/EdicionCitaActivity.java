package com.proyecto.IFP;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class EdicionCitaActivity extends AppCompatActivity {

    private Button boton1;
    private Button boton2;
    private Button boton3;
    private Intent pasarPantalla;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edicion_cita);
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();

        boton1 = (Button) findViewById(R.id.button_1_back_edicionCitas);
        boton2 = (Button) findViewById(R.id.button_2_save_nuevacita);
        boton3 = (Button) findViewById(R.id.button_3_drop_edicionCitas);

        boton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pasarPantalla = new Intent(EdicionCitaActivity.this, AccesoActivity.class);
                finish();
                startActivity(pasarPantalla);
            }
        });

        boton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pasarPantalla = new Intent(EdicionCitaActivity.this, AccesoActivity.class);
                finish();
                startActivity(pasarPantalla);
            }
        });

        boton3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pasarPantalla = new Intent(EdicionCitaActivity.this, AccesoActivity.class);
                finish();
                startActivity(pasarPantalla);
            }
        });

        //boton atras donde regresamos, deberiamos regresar a la activity de la que venimos. ¿Como?
        //un condicional?


    }


}