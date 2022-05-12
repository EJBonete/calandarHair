package com.proyecto.IFP;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


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

    private EditText box1;
    private TextView label1;
    private EditText box2;
    private EditText box3;
    private EditText box4;
    private TextView label2;
    private DataBaseSQL db;
    private int id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_edicion_cita);

        // Elimina barra superior UI
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();

        db = new DataBaseSQL(this);

        box1=(EditText) findViewById(R.id.editText_name_edicionCitas);
        label1=(TextView)  findViewById(R.id.hora_edicionCitas);
        box2=(EditText) findViewById(R.id.editText_service_edicionCita);
        box3=(EditText) findViewById(R.id.editText_contact_edicionCitas);
        box4=(EditText) findViewById(R.id.editText_others_edicionCitas);
        label2=(TextView) findViewById(R.id.fecha_edicionCitas);

        extra = getIntent().getExtras();
        if (extra != null) {
            id=extra.getInt("id");
            datoNombre = extra.getString("NOMBRE");
            datoTelefono = extra.getString("telefono");
            datoServicio = extra.getString("servicio");
            datoFecha = extra.getString("fecha");
            datoHora = extra.getString("hora");
            datoObservaciones = extra.getString("observaciones");
            box1.setText(datoNombre);
            label1.setText(datoHora);
            box2.setText(datoServicio);
            box3.setText(datoTelefono);
            box4.setText(datoObservaciones);
            label2.setText(datoFecha);

        }


        //borrar cita
        boton1 = (Button) findViewById(R.id.button_1_drop_edicionCitas);
        boton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pasarPantalla = new Intent(EdicionCitaActivity.this, AccesoActivity.class);
                finish();
                startActivity(pasarPantalla);

                //este id aun esta vacio.
                db.deleteCita(id);



            }
        });

        //atras
        boton2 = (Button) findViewById(R.id.button_2_back_edicionCitas);
        boton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pasarPantalla = new Intent(EdicionCitaActivity.this, AccesoActivity.class);
                finish();
                startActivity(pasarPantalla);
            }
        });

        //guardar citas
        boton3 = (Button) findViewById(R.id.button_3_save_edicionCitas);
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