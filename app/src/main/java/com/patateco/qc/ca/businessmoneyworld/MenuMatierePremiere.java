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
                    photoMatiere = new int[] {R.drawable.coppertube,R.drawable.iron,R.drawable.zinc};

                    nomMatiere = new String[] {};
                    break;
                case R.drawable.icon_australia:
                    photoMatiere = new int[] {};

                    nomMatiere = new String[] {};
                    break;

                case R.drawable.icon_brazil:
                    photoMatiere = new int[] {};

                    nomMatiere = new String[] {};
                    break;

                case R.drawable.canada_icon:
                    photoMatiere = new int[] {};

                    nomMatiere = new String[] {};
                    break;

                case R.drawable.icon_china:
                    photoMatiere = new int[] {};

                    nomMatiere = new String[] {};
                    break;

                case R.drawable.icon_colombia:
                    photoMatiere = new int[] {};

                    nomMatiere = new String[] {};
                    break;

                case R.drawable.icon_cuba:
                    photoMatiere = new int[] {};

                    nomMatiere = new String[] {};
                    break;

                case R.drawable.icon_drc:
                    photoMatiere = new int[] {};

                    nomMatiere = new String[] {};
                    break;

                case R.drawable.icon_france:
                    photoMatiere = new int[] {};

                    nomMatiere = new String[] {};
                    break;

                case R.drawable.icon_germany:
                    photoMatiere = new int[] {};

                    nomMatiere = new String[] {};
                    break;

                case R.drawable.icon_india:
                    photoMatiere = new int[] {};

                    nomMatiere = new String[] {};
                    break;

                case R.drawable.icon_iran:
                    photoMatiere = new int[] {};

                    nomMatiere = new String[] {};
                    break;

                case R.drawable.icon_italie:
                    photoMatiere = new int[] {};

                    nomMatiere = new String[] {};
                    break;

                case R.drawable.icon_japan:
                    photoMatiere = new int[] {};

                    nomMatiere = new String[] {};
                    break;

                case R.drawable.icon_mexico:
                    photoMatiere = new int[] {};

                    nomMatiere = new String[] {};
                    break;

                case R.drawable.icon_morroco:
                    photoMatiere = new int[] {};

                    nomMatiere = new String[] {};
                    break;

                case R.drawable.icon_norway:
                    photoMatiere = new int[] {};

                    nomMatiere = new String[] {};
                    break;

                case R.drawable.icon_rsa:
                    photoMatiere = new int[] {};

                    nomMatiere = new String[] {};
                    break;


                case R.drawable.icon_russia:
                    photoMatiere = new int[] {};

                    nomMatiere = new String[] {};
                    break;

                case R.drawable.icon_saudia_arabia:
                    photoMatiere = new int[] {};

                    nomMatiere = new String[] {};
                    break;

                case R.drawable.icon_spain:
                    photoMatiere = new int[] {};

                    nomMatiere = new String[] {};
                    break;

                case R.drawable.icon_sweden:
                    photoMatiere = new int[] {};

                    nomMatiere = new String[] {};
                    break;

                case R.drawable.icon_uk:
                    photoMatiere = new int[] {};

                    nomMatiere = new String[] {};
                    break;

                case R.drawable.icon_usa:
                    photoMatiere = new int[] {};

                    nomMatiere = new String[] {};
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




