package com.pokemaps.pokemap;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.FirebaseApp;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.pokemaps.pokemap.model.Ubicacion;

public class EliminarUbicacion  extends AppCompatActivity {
    EditText txtNom, txtUbi, txtNick, txtCiudad;
    Button  btnElim;

    FirebaseDatabase FBData;
    DatabaseReference DBReference;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.elimarubi);

        txtNom = (EditText) findViewById(R.id.txtNo);
        txtUbi = (EditText) findViewById(R.id.txtUb);
        txtCiudad = (EditText) findViewById(R.id.txtCi);
        txtNick = (EditText) findViewById(R.id.txtNi);


        btnElim = (Button) findViewById(R.id.button_ELIM);
        btnElim.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String NICKNAME = txtNick.getText().toString().trim().toUpperCase();
                if(NICKNAME.equals(""))
                {
                    validar();
                }
                else {
                    DBReference.child("Ubicacion").child(NICKNAME).removeValue();
                    Toast.makeText(EliminarUbicacion.this, "ELIMINANDO !!!!!", Toast.LENGTH_LONG).show();
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
        this.txtNick.setText("");
    }

    private void validar() {
        if(txtNick.getText().toString().equals(""))
        {
            txtNick.setError("Escriba Apodo de Pokemon!!!");
        }

    }
}