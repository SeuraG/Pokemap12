package com.pokemaps.pokemap;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class PrincipalUbicaciones extends AppCompatActivity{

    Button botonagregar;
    Button botonmostrar;
    Button botoneliminar;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ubicaciones);


        botonagregar = (Button) findViewById(R.id.buttonubiagregar);
        botonagregar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(PrincipalUbicaciones.this, Ubicaciones.class));
            }
        });
        botonmostrar = (Button) findViewById(R.id.btnmostrar);
        botonmostrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(PrincipalUbicaciones.this, verUbicaciones.class));
            }
        });
        botoneliminar = (Button) findViewById(R.id.btnElimnar);
        botoneliminar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(PrincipalUbicaciones.this, EliminarUbicacion.class));
            }
        });
    }
    }