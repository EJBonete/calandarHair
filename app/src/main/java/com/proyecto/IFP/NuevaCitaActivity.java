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

    protected Button boton1;
    protected Button boton2;
    protected EditText nombre;
    protected EditText trabajo;
    protected EditText telefono;
    protected EditText fecha;
    protected EditText observaciones;
    private String contentNombre;
    private String contentTrabajo = "";
    private String contentTelefono = "";
    private String contentFecha;
    private String contentObservaciones = "";
    private DataBaseSQL db;
    private Intent pasarPantalla;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nueva_cita);


        boton1 = (Button) findViewById(R.id.button_1_back_nuevacita);
        boton2 = (Button) findViewById(R.id.button_2_save_nuevacita);
        nombre = (EditText) findViewById(R.id.editText_name_nuevaCita);
        trabajo = (EditText) findViewById(R.id.editText_service_nuevaCita);
        telefono = (EditText) findViewById(R.id.editText_contact_nuevaCita);
        fecha = (EditText) findViewById(R.id.editText_date_nuevaCita);
        observaciones = (EditText) findViewById((R.id.editText_others_nuevaCita));
        db = new DataBaseSQL(this);

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
            public void onClick(View view) {
                contentNombre = nombre.getText().toString();//label1.getText().toString(); // capturamos los del label1
                contentTelefono = telefono.getText().toString();
                contentTrabajo = trabajo.getText().toString();
                contentFecha = fecha.getText().toString();
                contentObservaciones = observaciones.getText().toString();
                if (contentNombre.equalsIgnoreCase("") || contentFecha.equalsIgnoreCase("")) {
                    Toast.makeText(NuevaCitaActivity.this, "Nombre y Fecha Obligatorio", Toast.LENGTH_SHORT).show();
                } else {
                    db.insertarCita(contentNombre, contentTelefono, contentTrabajo, contentFecha, contentObservaciones);
                    Toast.makeText(NuevaCitaActivity.this, "Nota creada correctamente", Toast.LENGTH_SHORT).show();
                }

            }
        });

    }
}