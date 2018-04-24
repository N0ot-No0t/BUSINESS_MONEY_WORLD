package com.patateco.qc.ca.businessmoneyworld;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.ArrayList;


/**
 * Created by Noot on 13/03/2018.
 */

public class MenuPersonnage extends Activity {
    ArrayList<Integer> imageInventaire;
    ArrayList<String> nomImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.pop_pers);

        Bundle bundleImage = getIntent().getExtras();
        imageInventaire = (ArrayList<Integer>)bundleImage.getSerializable("listImage");
        nomImage = (ArrayList<String>)bundleImage.getSerializable("listNom");


        DisplayMetrics dm = new DisplayMetrics();

        getWindowManager().getDefaultDisplay().getMetrics(dm);

        int width = dm.widthPixels;

        int height = dm.heightPixels;

        getWindow().setLayout((int)(width*.8),(int)(height*.6));

        Button btnNom = (Button) this.findViewById(R.id.btnNom);

        btnNom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(MenuPersonnage.this, MenuNom.class));
            }
        });

        Button btnInventaire = (Button)findViewById(R.id.btnInventaire);
        btnInventaire.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MenuPersonnage.this, MenuInventaire.class);
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
}
