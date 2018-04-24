package com.patateco.qc.ca.businessmoneyworld;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.ArrayList;

/**
 * Created by Lim on 2018-04-17.
 */

    public class MenuAchat extends Activity {

        int nombreUnit= 0;
        ArrayList<Integer> imageInventaire = new ArrayList<Integer>();
        ArrayList<String> nomImage = new ArrayList<String>();

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.pop_achat);

            Bundle bundleImage = getIntent().getExtras();
            imageInventaire = (ArrayList<Integer>)bundleImage.getSerializable("listImage");
            nomImage = (ArrayList<String>)bundleImage.getSerializable("listNom");

            final TextView nomObjet = (TextView)findViewById(R.id.typeObjet);
            nomObjet.setText(getIntent().getExtras().getString("objet"));
            final TextView nbUnit = (TextView)findViewById(R.id.nbUnit);
            nbUnit.setText(String.valueOf(nombreUnit));


            Button buttonplus = (Button)findViewById(R.id.buttonplus);
            Button buttonmoins = (Button)findViewById(R.id.buttonmoins);
            Button btnAchat = (Button)findViewById(R.id.btnAchat);
            Button btnInventaire = (Button)findViewById(R.id.btnInventaire);

            buttonplus.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    nombreUnit = nombreUnit + 1;
                    nbUnit.setText(String.valueOf(nombreUnit));


                }
            });
            buttonmoins.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(nombreUnit > 0) {
                        nombreUnit = nombreUnit - 1;
                        nbUnit.setText(String.valueOf(nombreUnit));

                    }
                }
            });
            btnAchat.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(MenuAchat.this," Vous avez acheter "+nombreUnit+" unit de "+nomObjet.getText()+"",Toast.LENGTH_SHORT).show();
                    imageInventaire.add(R.drawable.oil);
                    nomImage.add(nomObjet.getText().toString());

                }
            });
            btnInventaire.setOnClickListener(new View.OnClickListener() {
                @Override
                    public void onClick(View v) {
                    Intent intent = new Intent(MenuAchat.this, MenuInventaire.class);
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


    }

