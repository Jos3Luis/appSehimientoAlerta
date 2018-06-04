package com.jl.seguimientoyalerta;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button btn1,btn2,btnContactos,btn4,btn5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn1=(Button)findViewById(R.id.btn1);
        btn2=(Button)findViewById(R.id.btn2);
        btnContactos=(Button)findViewById(R.id.btn3);
        btn4=(Button)findViewById(R.id.btn4);
        btn5=(Button)findViewById(R.id.btn5);
    }
    public void clickContactos(View v) {
        Intent obj = new Intent(MainActivity.this, ActividadActivity.class);
        startActivity(obj);
    }
    public void clickActividad(View v) {
        Intent obj = new Intent(MainActivity.this, ActividadActivity.class);
        startActivity(obj);
    }
    public void clickAcercade(View v) {

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
         getMenuInflater().inflate(R.menu.menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id=item.getItemId();

        if (R.id.about==id){
            clickAcercade(null);
            return true;
        }else if (R.id.exit==id){
            finish();
        }


        return super.onOptionsItemSelected(item);
    }
}
