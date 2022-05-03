package com.proyecto.IFP;

// Video usado: https://www.youtube.com/watch?v=NK_-phxyIAM

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.provider.CalendarContract;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.proyecto.IFP.databinding.ActivityAccesoBinding;
import com.proyecto.IFP.databinding.ActivityNuevaCitaBinding;


public class NuevaCitaActivity extends AppCompatActivity {


    protected EditText nombre;
    protected EditText trabajo;
    protected EditText otros;
    private Intent pasarPantalla;

    private ActivityNuevaCitaBinding binding;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityNuevaCitaBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);


        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();

        //pagina para reparar entera, con la base de datos.
        nombre = binding.editTextNameNuevaCita;
        trabajo = binding.editTextContactNuevaCita;
        otros = binding.editTextServiceNuevaCita;

        binding.button1BackNuevacita.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pasarPantalla = new Intent(NuevaCitaActivity.this, AccesoActivity.class);
                finish();
                startActivity(pasarPantalla);
            }
        });
        binding.button1BackNuevacita.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!nombre.getText().toString().isEmpty() && !trabajo.getText().toString().isEmpty() /*&& !telefono.getText().toString().isEmpty()*/) {
                    Intent intent = new Intent(Intent.ACTION_INSERT);
                    intent.setData(CalendarContract.Events.CONTENT_URI);
                    intent.putExtra(CalendarContract.Events.TITLE, nombre.getText().toString());
                    intent.putExtra(CalendarContract.Events.EVENT_LOCATION, trabajo.getText().toString());
                    intent.putExtra(CalendarContract.Events.DESCRIPTION, otros.getText().toString());
                    intent.putExtra(CalendarContract.Events.ALL_DAY, false);
                    intent.putExtra(Intent.EXTRA_EMAIL, "clanbil@gmail.com, marcmonterdemolina@gmail.com");

                    if (intent.resolveActivity(getPackageManager()) != null) {
                        startActivity(intent);
                    } else {
                        Toast.makeText(NuevaCitaActivity.this, "Acción no soportada", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(NuevaCitaActivity.this, "Debes rellenar los datos Nombre y Trabajo", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}