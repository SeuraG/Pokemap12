package com.example.pokemap;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.provider.Settings;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Principal extends AppCompatActivity {

    Button botonperfil;
    Button botonmapa;
    SensorManager sensorManager;
    Sensor sensor;
    SensorEventListener sensorEventListener;
    AlertDialog alerta = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.principal);

        Bundle b = getIntent().getExtras();

        sensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
        sensor = sensorManager.getDefaultSensor(Sensor.TYPE_PROXIMITY);

        if (sensor == null)
            finish();
        sensorEventListener = new SensorEventListener() {
            @Override
            public void onSensorChanged(SensorEvent sensorEvent) {
                if (sensorEvent.values[0] < sensor.getMaximumRange()) {
                    getWindow().getDecorView().setBackgroundColor(Color.BLACK);

                } else {
                    getWindow().getDecorView().setBackgroundColor(Color.RED);
                }
            }

            @Override
            public void onAccuracyChanged(Sensor sensor, int i) {

            }
        };
        start();




        botonperfil = (Button) findViewById(R.id.ingreso_perfil);
        botonperfil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Principal.this, Perfil.class));
            }
        });

        botonmapa = (Button) findViewById(R.id.ingreso_mapa);
        botonmapa.setOnClickListener(new  View.OnClickListener(){

            @Override
            public void onClick(View view) {
                startActivity(new Intent(Principal.this,mapa.class));

            }
        }
        );
        getAlertaNotGps();
        }

    private void getAlertaNotGps() {
        final AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("Por favor encienda el GPS. Desea activarlo?")
                .setCancelable(false)
                .setTitle("GPS")
                .setPositiveButton("Si", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(@SuppressWarnings("unused")final DialogInterface dialog, @SuppressWarnings("unused")final int id) {
                        startActivity(new Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS));
                    }
                }).setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick( final DialogInterface dialog, @SuppressWarnings("unused")final int id) {
                dialog.cancel();
            }
        });
        alerta = builder.create();
        alerta.show();
    }

    public void start(){
            sensorManager.registerListener(sensorEventListener,sensor,2000*1000);
        }
        public  void stop(){
        sensorManager.unregisterListener(sensorEventListener);
    }

    @Override
    protected void onPause() {
        stop();
        super.onPause();
    }

    @Override
    protected void onResume() {
        start();
        super.onResume();
    }
}
