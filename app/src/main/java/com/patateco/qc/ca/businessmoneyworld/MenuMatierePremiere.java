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
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by Lim on 2018-04-10.
 */

public class MenuMatierePremiere extends Activity {

    int[] photoMatiere = {R.drawable.oil, R.drawable.iron, R.drawable.coppertube,R.drawable.wood,R.drawable.rubber,R.drawable.aluminium,
            R.drawable.goldbrick, R.drawable.zinc,R.drawable.tungstene,R.drawable.silver,R.drawable.lithiums};

    String[] nomMatiere = {"Pétrole","Fer","Cuivre","Bois","Caoutchouc","Aluminium","Or","Zinc","Tungstène","Argent","Lithium"};
    ArrayList<Integer> imageInventaire;
    ArrayList<String> nomImage;


        @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pop_matierepremiere);
            Bundle bundleImage = getIntent().getExtras();
            imageInventaire = (ArrayList<Integer>)bundleImage.getSerializable("listImage");
            nomImage = (ArrayList<String>)bundleImage.getSerializable("listNom");


        ListView listMatiere = (ListView)findViewById(R.id.listMatierepremiere);
        CustomAdapter customAdapterMatiere = new CustomAdapter();
        listMatiere.setAdapter(customAdapterMatiere);
        listMatiere.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {

                int imageId = photoMatiere[position];
                Drawable drawable = getResources().getDrawable(imageId);


                String matiere="";

                switch (position){
                    case 0 : matiere = "Pétrole"; break;
                    case 1 : matiere = "Fer"; break;
                    case 2 : matiere = "Cuivre"; break;
                    case 3 : matiere = "Bois"; break;
                    case 4 : matiere = "Caoutchouc"; break;
                    case 5 : matiere = "Aluminium"; break;
                    case 6 : matiere = "Or"; break;
                    case 7 : matiere = "Zinc"; break;
                    case 8 : matiere = "Tungstène"; break;
                    case 9 : matiere = "Argent"; break;
                    case 10 : matiere = "Lithium";

                }
                Intent intent = new Intent(MenuMatierePremiere.this, MenuAchat.class);
                intent = intent.putExtra("objet",matiere);
                Bundle bundle = new Bundle();
                Bundle bundle1 = new Bundle();
                bundle.putSerializable("listImage",imageInventaire);
                bundle1.putSerializable("listNom",nomImage);
                intent.putExtras(bundle);
                intent.putExtras(bundle1);
                startActivity(intent);
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
            return photoMatiere.length;
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

            img.setImageResource(photoMatiere[i]);
            nom.setText(nomMatiere[i]);

            return view;
        }
    }

    }




