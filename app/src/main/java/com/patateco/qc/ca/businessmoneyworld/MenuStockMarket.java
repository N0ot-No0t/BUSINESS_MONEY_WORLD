package com.patateco.qc.ca.businessmoneyworld;

import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Lim on 2018-04-10.
 */

public class MenuStockMarket extends Activity {

    int[] photoStock = {R.drawable.microsoft, R.drawable.apple, R.drawable.cocacola, R.drawable.amazon,R.drawable.facebook, R.drawable.exxonmobil, R.drawable.intel, R.drawable.bankofamerica,
            R.drawable.ibm, R.drawable.ford, R.drawable.google, R.drawable.walmart,R.drawable.nike};

    String[] nomStock = {"Microsoft","Apple","Coca Cola","Amazono","Facebook","Exxon Mobil","Intel","Bank Of America","IBM",
            "Ford","Google","Walmart","Nike"};

    ArrayList<Integer> imageInventaire;
    ArrayList<String> nomImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pop_stockmarket);

        Bundle bundleImage = getIntent().getExtras();
        imageInventaire = (ArrayList<Integer>)bundleImage.getSerializable("listImage");
        nomImage = (ArrayList<String>)bundleImage.getSerializable("listNom");

        ListView listStock = (ListView)findViewById(R.id.liststockmarket);
       CustomAdapter customAdapterStock = new CustomAdapter();
        listStock.setAdapter(customAdapterStock);
        listStock.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {

                int imageId = photoStock[position];
                Drawable drawable = getResources().getDrawable(imageId);


            }
        });


        DisplayMetrics dm = new DisplayMetrics();

        getWindowManager().getDefaultDisplay().getMetrics(dm);

        int width = dm.widthPixels;

        int height = dm.heightPixels;

        getWindow().setLayout((int)(width*.8),(int)(height*.6));





    }
    class CustomAdapter extends BaseAdapter {

        @Override
        public int getCount() {
            return photoStock.length;
        }

        @Override
        public Object getItem(int i) {
            return null;
        }

        @Override
        public long getItemId(int i) {
            return 0;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {

            view = getLayoutInflater().inflate(R.layout.custom_layout,null);
            ImageView img = (ImageView)view.findViewById(R.id.img);
            TextView nom = (TextView)view.findViewById(R.id.nom);

            img.setImageResource(photoStock[i]);
            nom.setText(nomStock[i]);

            return view;
        }
    }
}
