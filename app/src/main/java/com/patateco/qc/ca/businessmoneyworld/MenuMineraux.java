package com.patateco.qc.ca.businessmoneyworld;

import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RemoteViews;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Lim on 2018-04-10.
 */

public class MenuMineraux extends Activity {
    int[] photoMineraux = {R.drawable.diamond, R.drawable.ruby, R.drawable.emerald, R.drawable.amethyst};

    String[] nomMineraux = {"Diamant","Ruby","Emeraude","Amethyste"};
    ArrayList<Integer> imageInventaire;
    ArrayList<String> nomImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pop_mineraux);
        Bundle bundleImage = getIntent().getExtras();
        imageInventaire = (ArrayList<Integer>)bundleImage.getSerializable("listImage");
        nomImage = (ArrayList<String>)bundleImage.getSerializable("listNom");



        ListView listMineraux = (ListView)findViewById(R.id.listmineraux);
        MyAdapter myAdapter = new MyAdapter(MenuMineraux.this,nomMineraux,photoMineraux);
        listMineraux.setAdapter(myAdapter);
        listMineraux.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {

                int imageId = photoMineraux[position];
                Drawable drawable = getResources().getDrawable(imageId);
            }
        });



    }

}
