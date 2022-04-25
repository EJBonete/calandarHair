package com.proyecto.IFP;

// Video usado: https://www.youtube.com/watch?v=NK_-phxyIAM

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.provider.CalendarContract;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class NuevaCitaActivity extends AppCompatActivity {


    protected Button boton1; // atras
    protected Button boton2; // Añadir
    protected EditText nombre;
    protected EditText trabajo;
    protected EditText otros;

    private Intent pasarPantalla;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nueva_cita);


        boton1 = (Button) findViewById(R.id.button1_Nueva); // Hola - mundo
        boton2 = (Button) findViewById(R.id.button2_Nueva);
        nombre = (EditText) findViewById(R.id.EditText1_Nueva);
        trabajo = (EditText) findViewById(R.id.EditText2_Nueva);
        otros = (EditText) findViewById(R.id.EditText3_Nueva);

        boton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pasarPantalla = new Intent(NuevaCitaActivity.this, AccesoActivity.class);
                finish();
                startActivity(pasarPantalla);
            }
        });
        boton2.setOnClickListener(new View.OnClickListener() {
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