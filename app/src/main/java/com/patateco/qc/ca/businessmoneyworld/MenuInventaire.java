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


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pop_inventaire);

        Bundle bundleImage = getIntent().getExtras();
        imageInventaire = (ArrayList<Integer>)bundleImage.getSerializable("listImage");
        nomImage = (ArrayList<String>)bundleImage.getSerializable("listNom");


        ListView listInventaire = (ListView)findViewById(R.id.listInventaire);
        CustomAdapter customAdapterMatiere = new CustomAdapter();
        listInventaire.setAdapter(customAdapterMatiere);
        listInventaire.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {

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
            return imageInventaire.size();
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

            view = getLayoutInflater().inflate(R.layout.custom_layout_inventaire,null);
            ImageView img = (ImageView)view.findViewById(R.id.imgInventaire);
            TextView nom = (TextView)view.findViewById(R.id.nomInventaire);

            img.setImageResource(imageInventaire.get(i));
            nom.setText(nomImage.get(i));

            return view;
        }
    }

}