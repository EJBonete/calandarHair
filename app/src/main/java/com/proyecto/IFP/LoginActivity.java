package com.proyecto.IFP;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

public class LoginActivity extends AppCompatActivity {

    protected TextView label1;
    protected TextView label2;
    protected EditText box1; // user
    protected EditText box2; // pwd


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        label1 = (TextView) findViewById((R.id.label_loggin));
        label2 = (TextView) findViewById((R.id.label1_loggin));
        box1 = (EditText) findViewById(R.id.box_loggin);
        box2 = (EditText) findViewById(R.id.box1_loggin);


    }
}