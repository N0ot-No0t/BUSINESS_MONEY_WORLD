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
            "ITALY","JAPAN","MEXICO","MOROCCO","NORWAY","SOUTH AFRICA","RUSSIA","SAUDI ARABIA","SPAIN","SWEDEN","UNITED KINGDOM","UNITED STATED OF AMERICA"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pop_pays);

        ListView listpays = (ListView)findViewById(R.id.listpays);
        MyAdapter myAdapter = new MyAdapter(MenuPays.this, NAMES,IMAGES);
        listpays.setAdapter(myAdapter);


    }

}
