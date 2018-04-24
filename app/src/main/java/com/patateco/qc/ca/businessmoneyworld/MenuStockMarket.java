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
        MyAdapter myAdapter = new MyAdapter(MenuStockMarket.this,nomStock,photoStock);
        listStock.setAdapter(myAdapter);
        listStock.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {

                int imageId = photoStock[position];
                Drawable drawable = getResources().getDrawable(imageId);


            }
        });


    }
}
