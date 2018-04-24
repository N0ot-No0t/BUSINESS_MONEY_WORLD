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

/**
 * Created by Lim on 2018-04-10.
 */

public class MenuMineraux extends Activity {
    int[] photoMineraux = {R.drawable.diamond, R.drawable.ruby, R.drawable.emerald, R.drawable.amethyst};

    String[] nomMineraux = {"Diamant","Rubis","Emeraude","Amethyste"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pop_mineraux);

        ListView listMineraux = (ListView)findViewById(R.id.listmineraux);
        MyAdapter minerauxAdapter = new MyAdapter(MenuMineraux.this,nomMineraux,photoMineraux);
        listMineraux.setAdapter(minerauxAdapter);
        listMineraux.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {

                int imageId = photoMineraux[position];
                Drawable drawable = getResources().getDrawable(imageId);


            }
        });


//        DisplayMetrics dm = new DisplayMetrics();
//
//        getWindowManager().getDefaultDisplay().getMetrics(dm);
//
//        int width = dm.widthPixels;
//
//        int height = dm.heightPixels;
//
//        getWindow().setLayout((int)(width*.8),(int)(height*.6));



    }

}
