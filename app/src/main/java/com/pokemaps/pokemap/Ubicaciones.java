package com.pokemaps.pokemap;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.FirebaseApp;
import com.pokemaps.pokemap.model.Ubicacion;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Ubicaciones extends AppCompatActivity {
    EditText txtNom, txtUbi, txtNick, txtCiudad;
    Button btnIn;

    FirebaseDatabase FBData;
    DatabaseReference DBReference;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ubicaciones);
        txtNom = (EditText) findViewById(R.id.txtNo);
        txtUbi = (EditText) findViewById(R.id.txtUb);
        txtCiudad = (EditText) findViewById(R.id.txtCi);
        txtNick = (EditText) findViewById(R.id.txtNi);

        btnIn = (Button) findViewById(R.id.button_ING);
        btnIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String NOMBRE = txtNom.getText().toString().trim().toUpperCase();
                String UBICACION = txtUbi.getText().toString().trim().toUpperCase();
                String CIUDAD = txtCiudad.getText().toString().trim().toUpperCase();
                String NICKNAME = txtNick.getText().toString().trim().toUpperCase();
                if(NOMBRE.equals("")||UBICACION.equals("")||CIUDAD.equals("")||NICKNAME.equals(""))
                {
                    validar();
                }
                else {
                    Ubicacion P = new Ubicacion();
                    P.setNombre(NOMBRE);
                    P.setCiudad(CIUDAD);
                    P.setpUbicacion(UBICACION);
                    P.setNickname(NICKNAME);
                    DBReference.child("Ubicacion").child(P.getNickname()).setValue(P);
                    Toast.makeText(Ubicaciones.this, "GUARDANDO !!!!!", Toast.LENGTH_LONG).show();
                    limpiar();
                }
            }
        });

        iniciar_firebase();

    } // FIN ONCREATE

    private void iniciar_firebase() {
        FirebaseApp.initializeApp(this);
        this.FBData = FirebaseDatabase.getInstance();
        this.DBReference = this.FBData.getReference();
    }

    private void limpiar() {
        this.txtNom.setText("");
        this.txtUbi.setText("");
        this.txtCiudad.setText("");
        this.txtNick.setText("");
    }

    private void validar() {
        if(txtNom.getText().toString().equals(""))
        {
            txtNom.setError("Escriba Nombre");
        }
        if(txtUbi.getText().toString().equals(""))
        {
            txtUbi.setError("Escriba Direccion");
        }
        if(txtCiudad.getText().toString().equals(""))
        {
            txtCiudad.setError("Escriba Ciudad");
        }
        if(txtNick.getText().toString().equals(""))
        {
            txtNick.setError("Escriba apodo");
        }
    }
}