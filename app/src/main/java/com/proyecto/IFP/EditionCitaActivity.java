package com.proyecto.IFP;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.proyecto.IFP.databinding.ActivityAccesoBinding;
import com.proyecto.IFP.databinding.ActivityEdicionCitaBinding;

public class EditionCitaActivity extends AppCompatActivity {

    private ActivityEdicionCitaBinding binding;
    private Intent pasarPantalla;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityEdicionCitaBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();

        //guarda la edición de la cita
        binding.button2SaveEdicionCitas.setOnClickListener(new View.OnClickListener() {  // Nueva
            @Override
            public void onClick(View view) {



            }
        });
        //regresamos a la actividad acceso
        binding.button1BackEdicionCitas.setOnClickListener(new View.OnClickListener() {  // Hoy
            @Override
            public void onClick(View view) {
                pasarPantalla = new Intent(EditionCitaActivity.this, AccesoActivity.class);
                finish();
                startActivity(pasarPantalla);
            }
        });
//borramos la cita
        binding.button3DropEdicionCitas.setOnClickListener(new View.OnClickListener() {  // Todas
            @Override
            public void onClick(View view) {

            }
        });

    }
}