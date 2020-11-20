package com.pokemaps.pokemap;

import androidx.fragment.app.FragmentActivity;

import android.app.Activity;
import android.app.Dialog;
import android.os.Bundle;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

public class mapa extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private Marker marcador;
    double lat = 0.0;
    double ing = 0.0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mapa);

        int estado = GooglePlayServicesUtil.isGooglePlayServicesAvailable(getApplicationContext());
        if (estado == ConnectionResult.SUCCESS) {
            // Obtain the SupportMapFragment and get notified when the map is ready to be used.
            SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                    .findFragmentById(R.id.map);
            mapFragment.getMapAsync(this);
        } else {
            Dialog mens = GooglePlayServicesUtil.getErrorDialog(estado, (Activity) getApplicationContext(), 10);
        }
    }

    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        mMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);
        mMap.getUiSettings().setZoomControlsEnabled(true);
        Antut(googleMap);
    }
    public void Antut (GoogleMap googleMap){
        mMap = googleMap;
        final LatLng punto1 = new LatLng(-30.603433, -71.203426);
        mMap.addMarker(new MarkerOptions().position(punto1).title("PokeOvalle").icon(BitmapDescriptorFactory.fromResource(R.drawable.centro)).anchor(0.0f, 1.0f));
        float zoomnivel = 14;
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(punto1,zoomnivel));
        final LatLng punto2 = new LatLng(-30.6028004,-71.1986921);
        mMap.addMarker(new MarkerOptions().position(punto2).title("Pikachu").icon(BitmapDescriptorFactory.fromResource(R.drawable.pikachumar)).anchor(0.0f, 1.0f));
        final LatLng punto3 = new LatLng(-30.606058, -71.209033);
        mMap.addMarker(new MarkerOptions().position(punto3).title("Bulbasaur").icon(BitmapDescriptorFactory.fromResource(R.drawable.bulbasaurm)).anchor(0.0f, 1.0f));
        final LatLng punto4 = new LatLng(-30.598641, -71.192286);
        mMap.addMarker(new MarkerOptions().position(punto4).title("Charmander").icon(BitmapDescriptorFactory.fromResource(R.drawable.charmanderm)).anchor(0.0f, 1.0f));
        final LatLng punto5 = new LatLng(-30.597999, -71.184907);
        mMap.addMarker(new MarkerOptions().position(punto5).title("Squirtle").icon(BitmapDescriptorFactory.fromResource(R.drawable.squirtlem)).anchor(0.0f, 1.0f));
    }
}