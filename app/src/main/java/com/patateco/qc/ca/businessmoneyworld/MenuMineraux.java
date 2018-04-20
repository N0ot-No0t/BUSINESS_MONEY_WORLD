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
        CustomAdapter customAdapterMineraux = new CustomAdapter();
        listMineraux.setAdapter(customAdapterMineraux);
        listMineraux.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {

                int imageId = photoMineraux[position];
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
            return photoMineraux.length;
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
            //ImageView img = (ImageView)view.findViewById(R.id.img);
            //TextView nom = (TextView)view.findViewById(R.id.nom);

           // img.setImageResource(photoMineraux[i]);
            //nom.setText(nomMineraux[i]);

            return view;
        }
    }

}
