package com.proyecto.IFP;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import com.proyecto.IFP.databinding.ActivityNuevaCitaBinding;
import com.proyecto.IFP.databinding.ActivityTodasBinding;

import java.util.ArrayList;

public class TodasActivity extends AppCompatActivity {

    protected Button boton1; // Atras
    private ListView lista1;
    private Intent pasarPantalla;
    protected DataBaseSQL db;
    private ArrayList<String> filesTodas = new ArrayList<String>();
    private ArrayAdapter<String> adapter;

    private ActivityTodasBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_todas);

        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();

        db = new DataBaseSQL(this);
        boton1=(Button) findViewById(R.id.button_1_back_todas);
        lista1= (ListView) findViewById(R.id.list_view_1_todas);

        filesTodas = db.getAllCitas();

        adapter = new ArrayAdapter<String>(TodasActivity.this, android.R.layout.simple_list_item_1, filesTodas);
        lista1.setAdapter(adapter);







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