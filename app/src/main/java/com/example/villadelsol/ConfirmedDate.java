package com.example.villadelsol;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class ConfirmedDate extends AppCompatActivity {
    TextView Cnombre1, Ccorreo1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirmed_date);
        Cnombre1=findViewById(R.id.textView70);
        Ccorreo1=findViewById(R.id.textView71);

        Bundle parametros = this.getIntent().getExtras();
        if(parametros!=null){
            String nombre=parametros.getString("nombre");
            String correo=parametros.getString("correo");


            Cnombre1.setText("Estimado: "+nombre);
            Ccorreo1.setText("Favor de verificar su bandeja de correo electronico ("+correo+") para mas detalles" +
                    "sobre la operacion que ha realizado.");
        }
    }

    public void home(View view) {
        Intent intent = new Intent(this,Menu.class);
        startActivity(intent);
        finish();
    }
}