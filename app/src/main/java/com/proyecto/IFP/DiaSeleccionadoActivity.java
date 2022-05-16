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

import java.util.ArrayList;
import java.util.Calendar;

public class DiaSeleccionadoActivity extends AppCompatActivity {
    private ListView list1;
    private Button boton1;
    private Intent pasarPantalla;
    protected DataBaseSQL db;
    private ArrayList<String> files = new ArrayList<String>();
    private ArrayAdapter<String> adapter;

    private String contenidoItem;
    //private String contenidoId;
    private int idP;
    private String[] partes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();
        setContentView(R.layout.activity_hoy);

       db = new DataBaseSQL(this);
        boton1 = (Button) findViewById(R.id.button_1_back_hoy);
        list1 = (ListView) findViewById(R.id.listview_hoy);


        //en esta parte insertamos las notas includias en el array en el ViewList.
        files = db.getDiaSelecionado();//este metodo no esta listo para funcionar



        adapter = new ArrayAdapter<String>(DiaSeleccionadoActivity.this, android.R.layout.simple_list_item_1, files);
        list1.setAdapter(adapter);



        //una pulsacion
        list1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                contenidoItem = parent.getItemAtPosition(position).toString();
                Toast.makeText(DiaSeleccionadoActivity.this, "Contenido Cita: " + contenidoItem, Toast.LENGTH_SHORT).show();

                //obtenemos el contenido del Item
               // contenidoItem = parent.getItemAtPosition(position).toString();
                partes=contenidoItem.split("/");
                //System.out.println("-->"+ partes[0]);

                if(partes.length>1){
                    idP = db.getIdCita(contenidoItem);




                    pasarPantalla = new Intent(DiaSeleccionadoActivity.this, EdicionCitaActivity.class);
                    pasarPantalla.putExtra("id", partes[6]);
                    pasarPantalla.putExtra("hora",partes[0]);
                    pasarPantalla.putExtra("fecha", partes[1]);
                    pasarPantalla.putExtra("NOMBRE", partes[2]);
                    pasarPantalla.putExtra("telefono", partes[3]);
                    pasarPantalla.putExtra("servicio", partes[4]);


                    pasarPantalla.putExtra("observaciones", partes[5]);

                    startActivity(pasarPantalla);
                }




                //pasamos el contenido al ver activity





            }


        });
        //boton de retroceso a acceso
        boton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pasarPantalla = new Intent(DiaSeleccionadoActivity.this, AccesoActivity.class);
                finish();
                startActivity(pasarPantalla);
            }
        });


    }
}
/*
        //una pulsación prolongada para ir a la edicion, .
        list1.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {

                //obtenemos el contenido del Item
                contenidoItem = parent.getItemAtPosition(position).toString();
                idP = db.getIdCita(contenidoItem);
                //pasamos el contenido al ver activity
                pasarPantalla = new Intent(DiaSeleccionadoActivity.this, EdicionCitaActivity.class);
                pasarPantalla.putExtra("id", idP);
                pasarPantalla.putExtra("nombre", contenidoItem);
                pasarPantalla.putExtra("servicio", contenidoItem);
                pasarPantalla.putExtra("hora",contenidoItem);
                pasarPantalla.putExtra("fecha", contenidoItem);
                pasarPantalla.putExtra("observaciones", contenidoItem);
                startActivity(pasarPantalla);
                return true;
            }
        });
        */