package com.example.rt.juegosdenes;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


import com.bumptech.glide.Glide;

import java.io.IOException;

public class JuegoActivity extends AppCompatActivity {

    TextView tvTitulo;
    ImageView ivCaratula;
    int musica;
    String tituloMusica;
    MediaPlayer mp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle bundle = getIntent().getExtras();
        setContentView(R.layout.activity_juego);
        tvTitulo= (TextView)findViewById(R.id.tvTitulo);
        tvTitulo.setText(bundle.getString("nombre"));
        ivCaratula= (ImageView)findViewById(R.id.ivCaratula);

        tituloMusica=bundle.getString("tituloMusica");
        //ivCaratula.setImageResource(bundle.getInt("caratula"));


        Glide.with(this).load(bundle.getInt("caratula")).into(ivCaratula);

        musica=bundle.getInt("musica");
        mp = MediaPlayer.create(getApplicationContext(), musica);
    }


    public void reproducirMusica(View v) throws IOException                     {
        if(mp.isPlaying()){
            mp.stop();
            mp.prepare();
            mp.seekTo(0);
        }
        else{
            mp.start();
            Toast.makeText(this,tituloMusica,Toast.LENGTH_LONG).show();
        }
        //finish();
    }
    public void onBackPressed() {
        mp.stop();
        mp.release();
        mp = null;
        finish();
        return;
    }
}
