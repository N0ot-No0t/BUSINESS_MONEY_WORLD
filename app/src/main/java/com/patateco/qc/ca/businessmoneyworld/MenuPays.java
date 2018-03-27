package com.patateco.qc.ca.businessmoneyworld;

import android.app.Activity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

/**
 * Created by Noot on 27/03/2018.
 */

public class MenuPays extends Activity {
    int[] IMAGES = {R.drawable.canada_icon, R.drawable.avatar, R.drawable.news,R.drawable.pays,R.drawable.settings};
    String[] NAMES = {"CANADA","TEST","NEWS","PAYS","SETTINGS"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pop_pays);

        ListView listpays = (ListView)findViewById(R.id.listpays);
        CustomAdapter customAdapter = new CustomAdapter();
        listpays.setAdapter(customAdapter);

//        DisplayMetrics dm = new DisplayMetrics();
//
//        getWindowManager().getDefaultDisplay().getMetrics(dm);
//
//        int width = dm.widthPixels;
//
//        int height = dm.heightPixels;
//
//        getWindow().setLayout((int)(width*1),(int)(height*.8));

    }

    class CustomAdapter extends BaseAdapter{

        @Override
        public int getCount() {
            return IMAGES.length;
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
            ImageView imgPays = (ImageView)view.findViewById(R.id.imgPays);
            TextView nomPays = (TextView)view.findViewById(R.id.nomPays);

            imgPays.setImageResource(IMAGES[i]);
            nomPays.setText(NAMES[i]);

            return view;
        }
    }
}
