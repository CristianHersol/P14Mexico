package com.example.alumno_1.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity {

    ImageView imgCiudades, imgEstados;
    ImageButton imgbSalir;
    Spinner spnEstados;
    ListView lstCiudades;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imgCiudades = (ImageView) findViewById(R.id.imgCiudades);
        imgEstados = (ImageView) findViewById(R.id.imgEstados);
        imgbSalir = (ImageButton) findViewById(R.id.imageButton);
        lstCiudades = (ListView) findViewById(R.id.lstCiudades);
        spnEstados = (Spinner) findViewById(R.id.spnEstados);

        imgEstados.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent infoEscudo = new Intent(view.getContext(),Escudo.class);
                startActivity(infoEscudo);
            }
        });

        imgbSalir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
                Intent intent = new Intent(Intent.ACTION_MAIN);
                intent.addCategory(Intent.CATEGORY_HOME);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
            }
        });

        ArrayAdapter Estados = ArrayAdapter.createFromResource(this, R.array.Estados, android.R.layout.simple_spinner_dropdown_item);
        spnEstados.setAdapter(Estados);

        spnEstados.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> lista, View view, int position, long id) {

                if (lista.getItemAtPosition(position).equals("México")){
                    ArrayAdapter listaMexico = ArrayAdapter.createFromResource(MainActivity.this, R.array.México, android.R.layout.simple_gallery_item);
                    lstCiudades.setAdapter(listaMexico);
                    imgEstados.setImageResource(R.drawable.mexico);
                    imgCiudades.setImageResource(R.drawable.mexicoini);
                }
                if (lista.getItemAtPosition(position).equals("Nayarit")){
                    ArrayAdapter listaNayarit = ArrayAdapter.createFromResource(MainActivity.this, R.array.Nayarit, android.R.layout.simple_gallery_item);
                    lstCiudades.setAdapter(listaNayarit);
                    imgEstados.setImageResource(R.drawable.nayarit);
                    imgCiudades.setImageResource(R.drawable.mapanayarit);
                    CdNayarit();
                }
                if (lista.getItemAtPosition(position).equals("Guanajuato")){
                    ArrayAdapter listaGuanajuato = ArrayAdapter.createFromResource(MainActivity.this, R.array.Guanajuato, android.R.layout.simple_gallery_item);
                    lstCiudades.setAdapter(listaGuanajuato);
                    imgEstados.setImageResource(R.drawable.guanajuatoe);
                    imgCiudades.setImageResource(R.drawable.mapaguana);
                    CdGuanajuato();
                }
                if (lista.getItemAtPosition(position).equals("Yucatán")){
                    ArrayAdapter listaYucatán = ArrayAdapter.createFromResource(MainActivity.this, R.array.Yucatán, android.R.layout.simple_gallery_item);
                    lstCiudades.setAdapter(listaYucatán);
                    imgEstados.setImageResource(R.drawable.yucatan);
                    imgCiudades.setImageResource(R.drawable.mapayucatan);
                    CdYucatan();
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }

    public void CdNayarit(){
        lstCiudades.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long l) {
                switch (position){
                    case 0: imgCiudades.setImageResource(R.drawable.tepicna);break;
                    case 1: imgCiudades.setImageResource(R.drawable.sayulitana);break;
                    case 2: imgCiudades.setImageResource(R.drawable.guayabitosna);break;
                }
            }
        });
    }

    public void CdGuanajuato(){
        lstCiudades.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long l) {
                switch (position){
                    case 0: imgCiudades.setImageResource(R.drawable.guanajuatogu);break;
                    case 1: imgCiudades.setImageResource(R.drawable.leongu);break;
                    case 2: imgCiudades.setImageResource(R.drawable.irapuatogu);break;
                }
            }
        });
    }

    public void CdYucatan(){
        lstCiudades.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long l) {
                switch (position){
                    case 0: imgCiudades.setImageResource(R.drawable.meridayu);break;
                    case 1: imgCiudades.setImageResource(R.drawable.progresoyu);break;
                    case 2: imgCiudades.setImageResource(R.drawable.izamalyu);break;
                }
            }
        });
    }
}
