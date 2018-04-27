package com.patateco.qc.ca.businessmoneyworld;

import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Menu;
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

    Element fer = new Element("Fer",15.0, R.drawable.iron);
    Element petrole = new Element("Pétrole",10.0, R.drawable.oil);
    Element cuivre = new Element("Cuivre",15.0, R.drawable.coppertube);
    Element bois = new Element("Bois",15.0, R.drawable.wood);
    Element caoutchouc = new Element("Caoutchouc",15.0, R.drawable.rubber);
    Element aluminium = new Element("Aluminium",15.0, R.drawable.aluminium);
    Element or = new Element("Or",15.0, R.drawable.goldbrick);
    Element zinc = new Element("Zinc",15.0, R.drawable.zinc);
    Element tungstene = new Element("Tungstène",15.0, R.drawable.tungstene);
    Element argent = new Element("Argent",15.0, R.drawable.silver);
    Element Lithium = new Element("Lithium",15.0, R.drawable.lithiums);

    Element [] listeMatierePremiere;


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

                    listeMatierePremiere = new Element[] {cuivre, fer, zinc};

                    break;
                case R.drawable.icon_australia:
                    listeMatierePremiere = new Element[] {or,aluminium};
                    break;

                case R.drawable.icon_brazil:
                 listeMatierePremiere = new Element[] {fer, bois};
                    break;

                case R.drawable.canada_icon:
                    listeMatierePremiere = new Element[] {petrole, bois};
                    break;

                case R.drawable.icon_china:
                    listeMatierePremiere = new Element[] {fer,petrole};
                    break;

                case R.drawable.icon_colombia:
                    listeMatierePremiere = new Element[] {cuivre};
                    break;

                case R.drawable.icon_cuba:
                    listeMatierePremiere = new Element[] {bois};
                    break;

                case R.drawable.icon_drc:
//                    listeMatierePremiere = new Element[] {diamant};
                    break;

                case R.drawable.icon_france:
//                    listeMatierePremiere = new Element[] {fer,charbon};
                    break;

                case R.drawable.icon_germany:
                    listeMatierePremiere = new Element[] {petrole};
                    break;

                case R.drawable.icon_india:
//                    listeMatierePremiere = new Element[] {};
                    break;

                case R.drawable.icon_iran:
//                    listeMatierePremiere = new Element[] {};
                    break;

                case R.drawable.icon_italie:
                    listeMatierePremiere = new Element[] {zinc,petrole};
                    break;

                case R.drawable.icon_japan:
//                    listeMatierePremiere = new Element[] {fer, bois};
                    break;

                case R.drawable.icon_mexico:
                    listeMatierePremiere = new Element[] {or,zinc,aluminium};
                    break;

                case R.drawable.icon_morroco:
//                    listeMatierePremiere = new Element[] {};
                    break;

                case R.drawable.icon_norway:
                    listeMatierePremiere = new Element[] {petrole};
                    break;

                case R.drawable.icon_rsa:
//                    listeMatierePremiere = new Element[] {};
                    break;


                case R.drawable.icon_russia:
                    listeMatierePremiere = new Element[] {petrole,or};
                    break;

                case R.drawable.icon_saudia_arabia:
                    listeMatierePremiere = new Element[] {petrole};
                    break;

                case R.drawable.icon_spain:
//                    listeMatierePremiere = new Element[] {zinc,fer,plomb};
                    break;

                case R.drawable.icon_sweden:
//                    listeMatierePremiere = new Element[] {fer,cuivre,plomb,zinc};
                    break;

                case R.drawable.icon_uk:
                    listeMatierePremiere = new Element[] {petrole,fer,zinc};
                    break;

                case R.drawable.icon_usa:
                    listeMatierePremiere = new Element[] {petrole};
                    break;

                default:

                    listeMatierePremiere = new Element[] {};

                    break;

            }
            //______________________________________________________________________________________

            imageInventaire = (ArrayList<Integer>)bundleImage.getSerializable("listImage");
            nomImage = (ArrayList<String>)bundleImage.getSerializable("listNom");


        ListView listMatiere = (ListView)findViewById(R.id.listMatierepremiere);
        MyAdapter myAdapter = new MyAdapter(MenuMatierePremiere.this,nomMatiere,photoMatiere);
        TabAdapter tabAdapter = new TabAdapter(MenuMatierePremiere.this,listeMatierePremiere);
        listMatiere.setAdapter(tabAdapter);
        listMatiere.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {

                int imageId = listeMatierePremiere[position].getImage();
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




