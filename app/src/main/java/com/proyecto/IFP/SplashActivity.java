package com.proyecto.IFP;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import java.util.Timer;
import java.util.TimerTask;

public class SplashActivity extends AppCompatActivity {

    private Intent pasarPantalla;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();

        TimerTask tt= new TimerTask() {
            @Override
            public void run() {
                pasarPantalla= new Intent(SplashActivity.this,AccesoActivity.class);
                finish();
                startActivity(pasarPantalla);
            }
        };

        Timer t= new Timer();
        t.schedule(tt, 3000); // 3 segundos para ejecutar tt


    }
}