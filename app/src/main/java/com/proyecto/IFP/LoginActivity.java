package com.proyecto.IFP;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class LoginActivity extends AppCompatActivity {
    protected TextView label1; //.....izurza
    protected TextView label2; // Comentario Nacho Marz
    protected EditText box; // user
    protected EditText box1; // pwd
    protected Button boton1; // loguin
    protected Button boton2; // registro
    private Intent pasarPantalla;

    // PRUEBA COMENTARIO MARC




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        label1 = (TextView) findViewById((R.id.label_loggin));
        label2 = (TextView) findViewById((R.id.label1_loggin));
        box = (EditText) findViewById(R.id.box_loggin);
        box1 = (EditText) findViewById(R.id.box1_loggin);
        boton1= (Button) findViewById(R.id.button2_acceso);
        boton2= (Button) findViewById(R.id.button1_acceso);

        boton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pasarPantalla = new Intent(LoginActivity.this, AccesoActivity.class);
                finish();
                startActivity(pasarPantalla); // SplashActivity es la main, pero si lo pongo aqui no va



            }
            });
    }
}