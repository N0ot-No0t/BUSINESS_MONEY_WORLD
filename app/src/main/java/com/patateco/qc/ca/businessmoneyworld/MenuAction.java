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
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Noot on 27/03/2018.
 */

public class MenuAction extends Activity {

    int[] photo = {R.drawable.hammer, R.drawable.stock, R.drawable.minerals};

    String[] noms = {"Matière première","StockMarket","Minéraux"};
    Drawable drawable;

    ArrayList<Integer> imageInventaire;
    ArrayList<String> nomImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pop_action);

        Bundle bundleImage = getIntent().getExtras();
        imageInventaire = (ArrayList<Integer>)bundleImage.getSerializable("listImage");
        nomImage = (ArrayList<String>)bundleImage.getSerializable("listNom");

        ListView listAction = (ListView)findViewById(R.id.listAction);
        MyAdapter myAdapter = new MyAdapter(MenuAction.this,noms,photo);
        listAction.setAdapter(myAdapter);
        listAction.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {

                int imageId = photo[position];
                Drawable drawable = getResources().getDrawable(imageId);
                if(imageId == R.drawable.hammer){
                    Intent intent = new Intent(MenuAction.this,MenuMatierePremiere.class);
                    Bundle bundle = new Bundle();
                    Bundle bundle1 = new Bundle();
                    bundle.putSerializable("listImage",imageInventaire);
                    bundle1.putSerializable("listNom",nomImage);
                    intent.putExtras(bundle);
                    intent.putExtras(bundle1);
                    startActivity(intent);
                }
                if(imageId == R.drawable.stock){
                    Intent intent = new Intent(MenuAction.this, MenuStockMarket.class);
                    Bundle bundle = new Bundle();
                    Bundle bundle1 = new Bundle();
                    bundle.putSerializable("listImage",imageInventaire);
                    bundle1.putSerializable("listNom",nomImage);
                    intent.putExtras(bundle);
                    intent.putExtras(bundle1);
                    startActivity(intent);
                }
                if(imageId == R.drawable.minerals){
                    Intent intent = new Intent(MenuAction.this, MenuMineraux.class);
                    Bundle bundle = new Bundle();
                    Bundle bundle1 = new Bundle();
                    bundle.putSerializable("listImage",imageInventaire);
                    bundle1.putSerializable("listNom",nomImage);
                    intent.putExtras(bundle);
                    intent.putExtras(bundle1);
                    startActivity(intent);
                }

            }
        });





    }
}
