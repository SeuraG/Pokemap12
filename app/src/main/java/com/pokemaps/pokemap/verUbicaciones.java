package com.pokemaps.pokemap;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;
import com.pokemaps.pokemap.model.Ubicacion;

import java.util.ArrayList;
import java.util.List;

public class verUbicaciones extends AppCompatActivity {
    EditText txtNom, txtUbi, txtNick, txtCiudad;
    Button  btnBusc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ver_ubicaciones);
        txtNick = (EditText) findViewById(R.id.txtNi);
        txtNom = (EditText) findViewById(R.id.txtNo);
        txtUbi = (EditText) findViewById(R.id.txtUb);
        txtCiudad = (EditText) findViewById(R.id.txtCi);

        btnBusc = (Button) findViewById(R.id.button_Cons);
        btnBusc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final int[] cont = {0};
                DatabaseReference bbdd = FirebaseDatabase.getInstance().getReference("Ubicacion");

                String NICKNAME = txtNick.getText().toString().trim().toUpperCase();
                Query q=bbdd.orderByChild("nickname").equalTo(NICKNAME);


                q.addChildEventListener(new ChildEventListener() {
                    @Override
                    public void onChildAdded(@NonNull DataSnapshot dataSnapshot, @Nullable String previousChildName) {

                        for(DataSnapshot datasnapshot: dataSnapshot.getChildren()){
                            cont[0]++;
                            System.out.println(dataSnapshot.getValue());

                            Ubicacion miP = dataSnapshot.getValue(Ubicacion.class);
                            txtNom.setText(miP.getNombre().toString());
                            txtUbi.setText(miP.getpUbicacion().toString());
                            txtCiudad.setText(miP.getCiudad().toString());
                            Toast.makeText(verUbicaciones.this, "ENCONTRADO !!! ", Toast.LENGTH_LONG).show();
                            break;
                        }
                    }

                    @Override
                    public void onChildChanged(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {

                    }

                    @Override
                    public void onChildRemoved(@NonNull DataSnapshot snapshot) {

                    }

                    @Override
                    public void onChildMoved(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {

                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                });

                if(cont[0] ==0)
                {
                    Toast.makeText(verUbicaciones.this, "NO EXISTE Registro!!! ", Toast.LENGTH_LONG).show();
                }
            }




        });
    }

}