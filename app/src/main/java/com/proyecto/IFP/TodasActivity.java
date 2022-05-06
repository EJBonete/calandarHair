package com.proyecto.IFP;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import com.proyecto.IFP.databinding.ActivityNuevaCitaBinding;
import com.proyecto.IFP.databinding.ActivityTodasBinding;

public class TodasActivity extends AppCompatActivity {

    protected Button boton1; // Atras
    private ListView lista1;
    private Intent pasarPantalla;

    private ActivityTodasBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_todas);

        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();

        boton1=(Button) findViewById(R.id.button_1_back_todas);
        lista1= (ListView) findViewById(R.id.list_view_1_todas);




        boton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pasarPantalla = new Intent(TodasActivity.this, AccesoActivity.class);
                finish();
                startActivity(pasarPantalla);
            }
        });



    }
}