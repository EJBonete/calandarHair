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
    private Bundle extra;
    private String datoNombre = "";
    private String datoTelefono = "";
    private String datoServicio = "";
    private String datoFecha = "";
    private String datoHora = "";
    private String datoObservaciones = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_edicion_cita);

        // Elimina barra superior UI
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();

        extra = getIntent().getExtras();
        if (extra != null) {

            datoNombre = extra.getString("nombre");
            datoTelefono = extra.getString("telefono");
            datoServicio = extra.getString("servicio");
            datoFecha = extra.getString("fecha");
            datoHora = extra.getString("hora");
            datoObservaciones = extra.getString("observaciones");
        }

        boton1 = (Button) findViewById(R.id.button_2_back_nuevaCita);
        boton2 = (Button) findViewById(R.id.button_2_save_nuevaCita);
        boton3 = (Button) findViewById(R.id.button_2_back_nuevaCita);

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