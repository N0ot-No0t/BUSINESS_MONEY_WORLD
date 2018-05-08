package com.patateco.qc.ca.businessmoneyworld;

import android.app.Activity;
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
 * Created by Lim on 2018-04-17.
 */


public class MenuInventaire extends Activity {
      ArrayList<Integer> imageInventaire;
      ArrayList<String> nomImage;

      Element [] inventaire;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pop_inventaire);

        Bundle bundleImage = getIntent().getExtras();
        imageInventaire = (ArrayList<Integer>)bundleImage.getSerializable("listImage");
        nomImage = (ArrayList<String>)bundleImage.getSerializable("listNom");


        ListView listInventaire = (ListView)findViewById(R.id.listInventaire);
        //CustomAdapter customAdapterMatiere = new CustomAdapter();
        TabAdapter tabAdapter = new TabAdapter(MenuInventaire.this,inventaire);
        listInventaire.setAdapter(tabAdapter);
        listInventaire.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {

            }
        });







    }

}