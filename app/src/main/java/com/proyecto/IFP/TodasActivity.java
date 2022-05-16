package com.proyecto.IFP;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.proyecto.IFP.databinding.ActivityNuevaCitaBinding;
import com.proyecto.IFP.databinding.ActivityTodasBinding;

import java.util.ArrayList;

public class TodasActivity extends AppCompatActivity {

    protected Button boton1; // Atras
    private ListView lista1;
    private Intent pasarPantalla;
    protected DataBaseSQL db;
    private ArrayList<String> files = new ArrayList<String>();
    private ArrayAdapter<String> adapter;
    private String contenidoItem;
    private String[] partes;

    private ActivityTodasBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_todas);

        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();

        boton1=(Button) findViewById(R.id.button_1_back_todas);
        lista1= (ListView) findViewById(R.id.list_view_1_todas);
        db = new DataBaseSQL(this);
        files = db.getAllCitas();
        adapter = new ArrayAdapter<String>(TodasActivity.this, android.R.layout.simple_list_item_1, files);
        lista1.setAdapter(adapter);

        lista1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                contenidoItem = adapterView.getItemAtPosition(i).toString();
                //Toast.makeText(TodasActivity.this, "Contenido Cita: " + contenidoItem, Toast.LENGTH_SHORT).show();

                //obtenemos el contenido del Item

                partes=contenidoItem.split("---");

                if(partes.length>1){

                    int idCita = Integer.parseInt(partes[6]); // lo pasamos a int


                    pasarPantalla = new Intent(TodasActivity.this, EdicionCitaActivity.class);
                    pasarPantalla.putExtra("fecha", partes[0]);
                    pasarPantalla.putExtra("hora",partes[1]);
                    pasarPantalla.putExtra("NOMBRE", partes[2]);
                    pasarPantalla.putExtra("telefono", partes[3]);
                    pasarPantalla.putExtra("servicio", partes[4]);
                    pasarPantalla.putExtra("observaciones", partes[5]);
                    pasarPantalla.putExtra("id", idCita);

                    startActivity(pasarPantalla);
                }
            }
        });


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