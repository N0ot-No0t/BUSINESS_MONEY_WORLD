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
    int[] IMAGES = {R.drawable.icon_argentina,R.drawable.icon_australia,R.drawable.icon_brazil,R.drawable.canada_icon, R.drawable.icon_china, R.drawable.icon_colombia,R.drawable.icon_cuba,R.drawable.icon_drc,
            R.drawable.icon_france,R.drawable.icon_germany,R.drawable.icon_india,R.drawable.icon_iran,R.drawable.icon_italie,R.drawable.icon_japan,
            R.drawable.icon_mexico,R.drawable.icon_morroco,R.drawable.icon_norway,R.drawable.icon_rsa,R.drawable.icon_russia,
            R.drawable.icon_saudia_arabia,R.drawable.icon_spain,R.drawable.icon_sweden,R.drawable.icon_uk,R.drawable.icon_usa};

    String[] NAMES = {"ARGENTINA","AUSTRALIA","BRAZIL","CANADA","CHINA","COLOMBIA","CUBA","DEMOCRATIC REPUBLIC OF CONGO","FRANCE","GERMANY","INDIA","IRAN",
            "ITALY","JAPAN","MEXICO","MORROCO","NORWAY","SOUTH AFRICA","SAUDIA ARABIA","SPAIN","SWEDEN","UNITED KINGDOM","UNITED STATES OF AMERICA"};

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
            ImageView imgPays = (ImageView)view.findViewById(R.id.img);
            TextView nomPays = (TextView)view.findViewById(R.id.nom);

            imgPays.setImageResource(IMAGES[i]);
            nomPays.setText(NAMES[i]);

            return view;
        }
    }
}
