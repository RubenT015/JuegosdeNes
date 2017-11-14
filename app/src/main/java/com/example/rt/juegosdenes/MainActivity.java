package com.example.rt.juegosdenes;

import android.app.ListActivity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<Juego> juegos;
    ListView lv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lv = (ListView)findViewById(R.id.lv);

        juegos = new ArrayList<>();
        juegos.add(new Juego("Mega Man","Capcom",1987,R.drawable.mega_man,R.raw.mega_man));
        juegos.add(new Juego("Blaster Master","Sunsoft",1988,R.drawable.blaster_master,R.raw.blaster_master));
        juegos.add(new Juego("Castlevania","Konami",1987,R.drawable.castlevania,R.raw.castlevania));
        juegos.add(new Juego("Contra","Konami",1988,R.drawable.contra,R.raw.contra));


        ArrayAdapterJuego arrayAdapter = new ArrayAdapterJuego(this,0,juegos );

        lv.setAdapter(arrayAdapter);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position,
                                    long id) {

                Intent i = new Intent(MainActivity.this, JuegoActivity.class);
                String message = "abc";
                i.putExtra("titulo",juegos.get(position).getNombre());
                i.putExtra("caratula",juegos.get(position).getCaratula());
                i.putExtra("musica",juegos.get(position).getMusica());
                //i.putExtra("style",R.style.Theme4);
                startActivity(i);
            }
        });
    }
}
