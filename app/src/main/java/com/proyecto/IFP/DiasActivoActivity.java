package com.proyecto.IFP;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.proyecto.IFP.databinding.ActivityAccesoBinding;
import com.proyecto.IFP.databinding.ActivityHoyBinding;

public class DiasActivoActivity extends AppCompatActivity {

    private Intent pasarPantalla;
    //protected Button boton1;
    private ActivityHoyBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityHoyBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();
       // boton1= (Button) findViewById(R.id.button_1_back_hoy);

        binding.button1BackHoy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pasarPantalla = new Intent(DiasActivoActivity.this, AccesoActivity.class);
                finish();
                startActivity(pasarPantalla);
            }
        });


    }
}