package com.jl.seguimientoyalerta;

import android.Manifest;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import java.util.ArrayList;

public class ActividadActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actividad);
    }
    public void clickElegir(View v) {
        Intent obj = new Intent(ActividadActivity.this, MapsActivity.class);
        startActivity(obj);
    }
    public void clickObtenerActual(View v) {
        /*ArrayList<String> permissions=new ArrayList<>();
        PermissionUtils permissionUtils;

        permissionUtils=new PermissionUtils(ActividadActivity.this);

        permissions.add(Manifest.permission.ACCESS_FINE_LOCATION);
        permissions.add(Manifest.permission.ACCESS_COARSE_LOCATION);

        permissionUtils.check_permission(permissions,"Need GPS permission for getting your location",1);*/
    }


}
