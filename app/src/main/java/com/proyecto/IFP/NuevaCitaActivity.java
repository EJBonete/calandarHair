package com.proyecto.IFP;

// Video usado: https://www.youtube.com/watch?v=NK_-phxyIAM

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import java.util.Calendar;


public class NuevaCitaActivity extends AppCompatActivity {

    protected Button boton1;
    protected Button boton2;
    protected EditText nombre;
    protected EditText trabajo;
    protected EditText telefono;
    protected TextView fecha;
    protected TextView hora;
    protected EditText observaciones;
    private String contentNombre;
    private String contentTrabajo = "";
    private String contentTelefono = "";
    private String contentFecha;
    private String contentHora;
    private String contentObservaciones = "";
    private DataBaseSQL db;
    private Intent pasarPantalla;
    private int dia, mes, anyo, horas, minutos, segundos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nueva_cita);
        //Este codigo oculta la barra superior.
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();

        boton1 = (Button) findViewById(R.id.button_1_back_nuevacita);
        boton2 = (Button) findViewById(R.id.button_2_save_nuevacita);
        nombre = (EditText) findViewById(R.id.editText_name_nuevaCita);
        trabajo = (EditText) findViewById(R.id.editText_service_nuevaCita);
        telefono = (EditText) findViewById(R.id.editText_contact_nuevaCita);

        fecha = (TextView) findViewById(R.id.editText_fecha_nuevaCita);
        hora= (TextView) findViewById(R.id.hora_nuevacita);

        observaciones = (EditText) findViewById((R.id.editText_others_nuevaCita));
        db = new DataBaseSQL(this);

//generamos en el editText la fecha para poder seleccionarla y mostrarla en el.
        fecha.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final Calendar c= Calendar.getInstance();
                dia=c.get(Calendar.DAY_OF_MONTH);
                mes=c.get(Calendar.MONTH);
                anyo=c.get(Calendar.YEAR);
                DatePickerDialog datePickerDialog= new DatePickerDialog(NuevaCitaActivity.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker datePicker, int year, int monthOfYear, int dayOfMonth) {
                        fecha.setText( year+"-"+ (monthOfYear+1) +"-"+ dayOfMonth);
                    }
                }, anyo, mes, dia);
                datePickerDialog.show();
            }
        });

        hora.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final Calendar c= Calendar.getInstance();
                horas=c.get(Calendar.HOUR_OF_DAY);
                minutos=c.get(Calendar.MINUTE);
                segundos=c.get(Calendar.SECOND);
                TimePickerDialog timePickerDialog= new TimePickerDialog(NuevaCitaActivity.this, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker timePicker, int horas, int minutos) {
                        hora.setText(horas+":"+minutos+":"+"00");
                    }
                }, horas, minutos, false);
                timePickerDialog.show();
                /*DatePickerDialog datePickerDialog= new DatePickerDialog(NuevaCitaActivity.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker datePicker, int year, int monthOfYear, int dayOfMonth) {
                        fecha.setText( year+"-"+ (monthOfYear+1) +"-"+ dayOfMonth);
                    }
                }*/


                ;





            }
        });









//boton para retroceder.
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
                //contentHora = "12:00:00";
                contentHora = hora.getText().toString();
                contentObservaciones = observaciones.getText().toString();
                if (contentNombre.equalsIgnoreCase("") || contentFecha.equalsIgnoreCase("")) {
                    Toast.makeText(NuevaCitaActivity.this, "Nombre y Fecha Obligatorio", Toast.LENGTH_SHORT).show();
                } else {
                    db.insertarCita(contentNombre, contentTelefono, contentTrabajo, contentFecha,contentHora ,contentObservaciones);
                    Toast.makeText(NuevaCitaActivity.this, "Cita creada correctamente", Toast.LENGTH_SHORT).show();
                    pasarPantalla = new Intent(NuevaCitaActivity.this, AccesoActivity.class);
                    finish();
                    startActivity(pasarPantalla);
                }
            }
        });
    }
}