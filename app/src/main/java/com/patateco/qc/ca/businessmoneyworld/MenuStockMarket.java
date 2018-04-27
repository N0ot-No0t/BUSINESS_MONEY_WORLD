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


    Element [] listeStock;

    ArrayList<Integer> imageInventaire;
    ArrayList<String> nomImage;

    Element microsoft = new Element("Microsoft", 10, R.drawable.microsoft);
    Element apple = new Element("Apple", 10, R.drawable.apple);
    Element cocacola = new Element("Coca Cola", 10, R.drawable.cocacola);
    Element amazon = new Element("Amazon", 10, R.drawable.amazon);
    Element facebook = new Element("Facebook", 10, R.drawable.facebook);
    Element exxon = new Element("Exxon Mobil", 10, R.drawable.exxonmobil);
    Element intel = new Element("Intel", 10, R.drawable.intel);
    Element bankOfAmerica = new Element("Bank Of America", 10, R.drawable.bankofamerica);
    Element ibm = new Element("IBM", 10, R.drawable.ibm);
    Element ford = new Element("Ford", 10, R.drawable.ford);
    Element google = new Element("Google", 10, R.drawable.google);
    Element walmart = new Element("Walmart", 10, R.drawable.walmart);
    Element nike = new Element("Nike", 10, R.drawable.nike);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pop_stockmarket);

        Bundle bundleImage = getIntent().getExtras();
        imageInventaire = (ArrayList<Integer>)bundleImage.getSerializable("listImage");
        nomImage = (ArrayList<String>)bundleImage.getSerializable("listNom");

        ListView listStock = (ListView)findViewById(R.id.liststockmarket);
        //MyAdapter myAdapter = new MyAdapter(MenuStockMarket.this,nomStock,photoStock);
        TabAdapter tabAdapter = new TabAdapter(MenuStockMarket.this,listeStock);
        listStock.setAdapter(tabAdapter);
        listStock.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {

                int imageId = listeStock[position].getImage();
                Drawable drawable = getResources().getDrawable(imageId);


            }
        });


    }
}
