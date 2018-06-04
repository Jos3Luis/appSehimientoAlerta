package com.jl.seguimientoyalerta;

import android.app.Activity;
import android.app.Dialog;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.UiSettings;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
//heredaba de FragmentActivity
public class MapsActivity extends AppCompatActivity implements OnMapReadyCallback, GoogleMap.OnMarkerDragListener {

    private GoogleMap mMap;
    private Marker marker;

    private double latitud;
    private double longitud;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);

        latitud=-12.1041139;
        longitud=-77.0399295;

        int status = GooglePlayServicesUtil.isGooglePlayServicesAvailable(getApplicationContext());

        if (status== ConnectionResult.SUCCESS){
            // Obtain the SupportMapFragment and get notified when the map is ready to be used.
            SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                    .findFragmentById(R.id.map);
            mapFragment.getMapAsync(this);
        }else{
            Dialog dialogo=GooglePlayServicesUtil.getErrorDialog(status,(Activity)getApplicationContext(),10);
            dialogo.show();
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

        UiSettings uisettings=mMap.getUiSettings();
        uisettings.setZoomControlsEnabled(true);

        // Add a marker in Sydney and move the camera
        LatLng pto = new LatLng(latitud,longitud);
        marker=googleMap.addMarker(new MarkerOptions()
                .position(pto)
                .title("Seleccione su Posicion")
                .draggable(true)
            );

        //mMap.addMarker(new MarkerOptions().position(pto).title("Posicion Inicial"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(pto));
        float zoom=16;
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(pto,zoom));

        googleMap.setOnMarkerDragListener(this);

    }


    //arrastrar
    @Override
    public void onMarkerDragStart(Marker marker) {
        latitud= marker.getPosition().latitude;
        longitud= marker.getPosition().longitude;
    }

    @Override
    public void onMarkerDrag(Marker marker) {
        latitud= marker.getPosition().latitude;
        longitud= marker.getPosition().longitude;
    }

    @Override
    public void onMarkerDragEnd(Marker marker) {
        latitud= marker.getPosition().latitude;
        longitud= marker.getPosition().longitude;
    }
    public void clickBtnElegir(View v){
        Toast.makeText(MapsActivity.this, "Latitud: "+latitud+", Longitud: "+longitud, Toast.LENGTH_SHORT).show();
    }
}
