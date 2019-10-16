package com.example.proyectomapa;

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
import com.google.android.gms.maps.UiSettings;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class Mapa extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mapa);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
       int estado = GooglePlayServicesUtil.isGooglePlayServicesAvailable(getApplicationContext());
       if (estado == ConnectionResult.SUCCESS){
           SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                   .findFragmentById(R.id.map);
           mapFragment.getMapAsync(this);
       }
        else{
            Dialog mens = GooglePlayServicesUtil.getErrorDialog(estado,(Activity) getApplicationContext(), 10);
            mens.show();
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
        //tipo de mapa
        mMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);
        //Utilidades de  google maps
        UiSettings USet = mMap.getUiSettings();
        USet.setZoomControlsEnabled(true);
        // Add a marker in Sydney and move the camera
        LatLng Chile = new LatLng(-30.604494, -72.2047422);
        mMap.addMarker(new MarkerOptions().position(Chile).title("Marcador de Chile").
                icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN)));

        float zoomnivel = 16;
        mMap.moveCamera(CameraUpdateFactory.newLatLng(Chile));
    }
}
