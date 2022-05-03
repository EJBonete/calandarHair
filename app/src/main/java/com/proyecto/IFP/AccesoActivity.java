package com.proyecto.IFP;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.proyecto.IFP.databinding.ActivityAccesoBinding;

public class AccesoActivity extends AppCompatActivity {



    private Intent pasarPantalla;
    private ActivityAccesoBinding binding;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityAccesoBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();

        binding.button1NewAcceso.setOnClickListener(new View.OnClickListener() {  // Nueva
            @Override
            public void onClick(View view) {
                pasarPantalla = new Intent(AccesoActivity.this, NuevaCitaActivity.class);
                finish();
                startActivity(pasarPantalla);
            }
        });

        binding.button2TodayAcceso.setOnClickListener(new View.OnClickListener() {  // Hoy
            @Override
            public void onClick(View view) {
                pasarPantalla = new Intent(AccesoActivity.this, DiasActivoActivity.class);
                finish();
                startActivity(pasarPantalla);
            }
        });

        binding.button3AlldatesAcceso.setOnClickListener(new View.OnClickListener() {  // Todas
            @Override
            public void onClick(View view) {
                pasarPantalla = new Intent(AccesoActivity.this, TodasActivity.class);
                finish();
                startActivity(pasarPantalla);
            }
        });


    }

}