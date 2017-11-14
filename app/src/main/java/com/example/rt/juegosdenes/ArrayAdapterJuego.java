package com.example.rt.juegosdenes;





import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class ArrayAdapterJuego extends ArrayAdapter<Juego> {
    private Context context;
    private ArrayList<Juego> juegos;

    //https://www.sitepoint.com/custom-data-layouts-with-your-own-android-arrayadapter/

    //constructor, call on creation
    public ArrayAdapterJuego(Context context, int resource, ArrayList<Juego> juegos) {
        super(context, resource, juegos);

        this.context = context;
        this.juegos = juegos;
    }

    //called when rendering the list
    public View getView(int position, View convertView, ViewGroup parent) {
        Juego property = juegos.get(position);

        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.lista_layout, null);

        TextView tvTitulo = (TextView) view.findViewById(R.id.tvTitulo);
        TextView tvDes = (TextView) view.findViewById(R.id.tvDes);
        TextView tvAnio = (TextView) view.findViewById(R.id.tvAnio);
        ImageView ivCaratula = (ImageView) view.findViewById(R.id.ivCaratula);

        tvTitulo.setText(property.getNombre());
        tvDes.setText(property.getDesarrollador());
        tvAnio.setText(Integer.toString(property.getAnio()));

        //version que estalla
        //ivCaratula.setImageResource(property.getCaratula());

        //ajustado sin glide
        //ivCaratula.setImageBitmap(decodeSampledBitmapFromResource(context.getResources(), property.getCaratula(), 100, 100));

        //ajustado con glide
        //https://developer.android.com/topic/performance/graphics/index.html

        Glide.with(context).load(property.getCaratula()).into(ivCaratula);
        return view;
    }

    public int calculateInSampleSize(BitmapFactory.Options options, int reqWidth, int reqHeight) {
        final int height = options.outHeight;
        final int width = options.outWidth;
        int inSampleSize = 1;

        if (height > reqHeight || width > reqWidth) {

            final int halfHeight = height / 2;
            final int halfWidth = width / 2;

            while ((halfHeight / inSampleSize) >= reqHeight
                    && (halfWidth / inSampleSize) >= reqWidth) {
                inSampleSize *= 2;
            }
        }

        return inSampleSize;
    }

    public Bitmap decodeSampledBitmapFromResource(Resources res, int resId,int reqWidth, int reqHeight) {

        final BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeResource(res, resId, options);

        options.inSampleSize = calculateInSampleSize(options, reqWidth, reqHeight);

        options.inJustDecodeBounds = false;
        return BitmapFactory.decodeResource(res, resId, options);
    }
}
