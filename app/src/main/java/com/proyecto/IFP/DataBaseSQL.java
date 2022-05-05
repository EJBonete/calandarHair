package com.proyecto.IFP;

import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.Calendar;

public class DataBaseSQL extends SQLiteOpenHelper {

    protected SQLiteDatabase db;


    public DataBaseSQL(Context context) {
        super(context, "citasBD", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE table tablacitas (id integer primary key autoincrement, nombre text, telefono text,servicio text, fecha text, observaciones text)");


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXIST citasBD");


    }

    public void insertarCita(String nombre, String telefono, String servicio, String fecha, String observaciones)
    {
        db= this.getReadableDatabase();
        db.execSQL("INSERT INTO tablacitas (nombre, telefono, servicio, fecha, observaciones) VALUES ('"+nombre+"','"+telefono+"','"+servicio+"','"+fecha+"','"+observaciones+"')");
        /*db.execSQL("INSERT INTO tablacitas (nombre) VALUES ('"+nombre+"')");
        db.execSQL("INSERT INTO tablacitas (telefono) VALUES ('"+telefono+"')");
        db.execSQL("INSERT INTO tablacitas (servicio) VALUES ('"+servicio+"')");
        db.execSQL("INSERT INTO tablacitas (fecha) VALUES ('"+fecha+"')");
        db.execSQL("INSERT INTO tablacitas (observaciones) VALUES ('"+observaciones+"')");*/

    }

    public int numeroCitas()
    {
        int num=0;
        db= this.getReadableDatabase();
        num= (int) DatabaseUtils.queryNumEntries(db, "tablacitas");
        return num;
    }

    //obtener del tlf la feacha actual.
    Calendar cc = Calendar.getInstance();
    int year = cc.get(Calendar.YEAR);
    int month = cc.get(Calendar.MONTH);
    int mDay = cc.get(Calendar.DAY_OF_MONTH);
    String fechaActual=mDay+"/"+(month+1)+"/"+year;

//obtener listado de citas del dia actual.
    public ArrayList<String> getDiaSelecionado() {
        ArrayList<String> arrayCitas = new ArrayList<>();
        Cursor res = null;
        String contenido = "";
        db = this.getReadableDatabase();
        res = db.rawQuery("SELECT * FROM tablacitas WHERE fecha='fechaActual'", null);
        res.moveToFirst();
        while (res.isAfterLast() == false) {
            contenido = res.getInt(res.getColumnIndex("id")) + ".-"
                    + res.getString(res.getColumnIndex("nombre")) + ".-"
                    + res.getString(res.getColumnIndex("telefono")) + ".-"
                    + res.getString(res.getColumnIndex("servicio")) + ".-"
                    + res.getString(res.getColumnIndex("fecha"))+ ".-"
                    + res.getString(res.getColumnIndex("observaciones"));

            //contenido = res.getString(res.getColumnIndex("nombre"));
            arrayCitas.add(contenido);
            res.moveToNext();
          //  System.out.println("-->" + contenido);
        }
        return arrayCitas;
    }



    public ArrayList<String> getAllCitas() {

        ArrayList<String> arrayCitas = new ArrayList<>();

        Cursor res = null;
        String contenido = "";
        db = this.getReadableDatabase();
        res = db.rawQuery("SELECT * FROM tablacitas", null);
        res.moveToFirst();
        while (res.isAfterLast() == false) {
            contenido = res.getInt(res.getColumnIndex("id")) + ".-" + res.getString(res.getColumnIndex("nombre")) + ".-" + res.getString(res.getColumnIndex("telefono")) + ".-" + res.getString(res.getColumnIndex("servicio")) + ".-" + res.getString(res.getColumnIndex("fecha"))+ ".-" + res.getString(res.getColumnIndex("observaciones"));
            //contenido = res.getString(res.getColumnIndex("nombre"));
            arrayCitas.add(contenido);
            res.moveToNext();
            System.out.println("-->" + contenido);
        }

        return arrayCitas;

    }




    public int getIdCita(String nombre) {
        int id=0;
        Cursor res = null;
        String contenido = "";
        if (numeroCitas() > 0) {
            db = this.getReadableDatabase();
            res = db.rawQuery("SELECT * FROM tablacitas WHERE nombre='"+nombre+"' ORDER BY id", null);
            res.moveToFirst();
            while (!res.isAfterLast()) {
                contenido = res.getString(res.getColumnIndex("id"));
                res.moveToNext();
                id=Integer.parseInt(contenido);
            }
        }
        return id;
    }

    //metodo borrar todas la notas de la tabla.
    public void deleteAllCitas() {
        db = this.getWritableDatabase();
        db.execSQL("DELETE FROM tablacitas");
    }
    //metodo borrar una nota de la tabla.
    public void deleteCita(int id) {
        db = this.getWritableDatabase();
        db.execSQL("DELETE FROM tablacitas WHERE id=" + id);
    }

    public void close()
    {
        db.close();
    }

}
