package com.example.villadelsol;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);

        //Agregar animaciones
        Animation animation1 = AnimationUtils.loadAnimation(this, R.anim.desplazamiento_arriba);
        Animation animation2 = AnimationUtils.loadAnimation(this, R.anim.desplazamiento_abajo);

        TextView texto = findViewById(R.id.texto);
        ImageView logobienvenida = findViewById(R.id.logov);
        logobienvenida.setAnimation(animation1);
        texto.setAnimation(animation2);

        TimerTask tarea = new TimerTask() {
            @Override
            public void run() {
                Intent intent = new Intent(MainActivity.this,Menu.class);
                startActivity(intent);
                finish();
            }
        };
        Timer tiempo=new Timer();
        tiempo.schedule(tarea,5000);
    }
    public void logobienvenida(View view){
        Intent intent_inicio = new Intent(this,ActividadInicio.class);
        startActivity(intent_inicio);

    }
}