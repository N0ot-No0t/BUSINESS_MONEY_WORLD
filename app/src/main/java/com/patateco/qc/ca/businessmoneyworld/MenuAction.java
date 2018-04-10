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
 * Created by Noot on 27/03/2018.
 */

public class MenuAction extends Activity {

    int[] photo = {R.drawable.hammer, R.drawable.stock, R.drawable.minerals};

    String[] noms = {"Matière première","Minéraux","StockMarket"};
    Drawable drawable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pop_action);

        ListView listAction = (ListView)findViewById(R.id.listAction);
        CustomAdapter customAdapterA = new CustomAdapter();
        listAction.setAdapter(customAdapterA);
        listAction.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {

                int imageId = photo[position];
                Drawable drawable = getResources().getDrawable(imageId);
                if(imageId == R.drawable.hammer){
                    Toast.makeText(MenuAction.this,noms[position],Toast.LENGTH_SHORT).show();
                }
                if(imageId == R.drawable.stock){

                }
                if(imageId == R.drawable.minerals){

                }

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
            return photo.length;
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
            ImageView img = (ImageView)view.findViewById(R.id.img);
            TextView nom = (TextView)view.findViewById(R.id.nom);

            img.setImageResource(photo[i]);
            nom.setText(noms[i]);

            return view;
        }
    }
}
