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
import android.widget.Toast;

/**
 * Created by Lim on 2018-04-10.
 */

public class MenuMatierePremiere extends Activity {

    int[] photoMatiere = {R.drawable.oil, R.drawable.iron, R.drawable.coppertube,R.drawable.wood,R.drawable.rubber,R.drawable.aluminium,
            R.drawable.goldbrick, R.drawable.zinc,R.drawable.tungstene,R.drawable.silver,R.drawable.lithiums};

    String[] nomMatiere = {"Pétrole","Fer","Cuivre","Bois","Caoutchouc","Aluminium","Or","Zinc","Tungstène","Argent","Lithium"};



        @Override
    protected void onCreate(Bundle savedInstanceState) {

            super.onCreate(savedInstanceState);

            setContentView(R.layout.pop_matierepremiere);

            final ListView listMatiere = (ListView)findViewById(R.id.listMatierepremiere);
            MyAdapter myAdapter = new MyAdapter(MenuMatierePremiere.this,nomMatiere, photoMatiere);
            listMatiere.setAdapter(myAdapter);

            listMatiere.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {

                    int imageId = photoMatiere[position];
                    Drawable drawable = getResources().getDrawable(imageId);


            }
        });


        }
    }




