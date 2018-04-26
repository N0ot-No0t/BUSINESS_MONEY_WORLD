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

    int selectedCountryCode;



    int[] photoMatiere;
    String[] nomMatiere;

    ArrayList<Integer> imageInventaire;
    ArrayList<String> nomImage;


        @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pop_matierepremiere);
            Bundle bundleImage = getIntent().getExtras();


            selectedCountryCode = bundleImage.getInt("selectedCountry");

            System.out.println("CC in MMP "+selectedCountryCode);

            //______________________________________________________________________________________


            switch(selectedCountryCode){

                case R.drawable.icon_argentina:
                    photoMatiere = new int[] {R.drawable.oil, R.drawable.iron, R.drawable.coppertube,R.drawable.wood};

                    nomMatiere = new String[] {"Pétrole","Fer","Cuivre","Bois"};
                    break;
                case R.drawable.icon_usa:
                    photoMatiere = new int[] {R.drawable.oil};

                    nomMatiere = new String[] {"Pétrole"};
                    break;

                case R.drawable.canada_icon:
                    photoMatiere = new int[] {R.drawable.wood};

                    nomMatiere = new String[] {"Bois"};
                    break;

                default:

                    photoMatiere = new int[] {};

                    nomMatiere = new String[] {};

                    break;

            }
            //______________________________________________________________________________________

            imageInventaire = (ArrayList<Integer>)bundleImage.getSerializable("listImage");
            nomImage = (ArrayList<String>)bundleImage.getSerializable("listNom");


        ListView listMatiere = (ListView)findViewById(R.id.listMatierepremiere);
        MyAdapter myAdapter = new MyAdapter(MenuMatierePremiere.this,nomMatiere,photoMatiere);
        listMatiere.setAdapter(myAdapter);
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







    }


    public void setSelectedCountry(int selectedCountryCode){

        this.selectedCountryCode = selectedCountryCode;

    }

    }




