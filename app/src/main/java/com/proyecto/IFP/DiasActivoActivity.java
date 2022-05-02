package com.proyecto.IFP;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class DiasActivoActivity extends AppCompatActivity {

    private Intent pasarPantalla;
    protected Button boton1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hoy);

        boton1= (Button) findViewById(R.id.button_1_back_hoy);

        boton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pasarPantalla = new Intent(DiasActivoActivity.this, AccesoActivity.class);
                finish();
                startActivity(pasarPantalla);
            }
        });


    }
}