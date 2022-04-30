package com.proyecto.IFP;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class TodasActivity extends AppCompatActivity {

    protected Button boton1; // Atras
    private Intent pasarPantalla;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_todas);

        boton1= (Button) findViewById(R.id.button_1_back_todas);

        boton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pasarPantalla = new Intent(TodasActivity.this, AccesoActivity.class);
                finish();
                startActivity(pasarPantalla);
            }
        });



    }
}