package com.patateco.qc.ca.businessmoneyworld;

import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

/**
 * Created by Noot on 27/03/2018.
 */

public class MenuAction extends Activity {

    int[] photo = {R.drawable.hammer, R.drawable.stock, R.drawable.minerals};

    String[] noms = {"Matière première","StockMarket","Minéraux"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.pop_action);

        final ListView listAction = (ListView)findViewById(R.id.listAction);
        MyAdapter myAdapter = new MyAdapter(MenuAction.this,noms, photo);
        listAction.setAdapter(myAdapter);

        listAction.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {

                int imageId = photo[position];
                Drawable drawable = getResources().getDrawable(imageId);
                if(imageId == R.drawable.hammer){
                    startActivity(new Intent(MenuAction.this,MenuMatierePremiere.class));
                }
                if(imageId == R.drawable.stock){
                    startActivity(new Intent(MenuAction.this,MenuStockMarket.class));
                }
                if(imageId == R.drawable.minerals){
                    startActivity(new Intent(MenuAction.this,MenuMineraux.class));
                }

            }
        });




    }
}
