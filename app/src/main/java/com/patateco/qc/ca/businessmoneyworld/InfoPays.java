package com.patateco.qc.ca.businessmoneyworld;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

/**
 * Created by Adrian on 2018-05-08.
 */

public class InfoPays extends Activity {

    int position;


    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        Bundle bundle = getIntent().getExtras();

        ImageView imgPays = findViewById(R.id.imgPays);
        TextView txtPays = findViewById(R.id.nom);

        setContentView(R.layout.custom_layout);


        position = bundle.getInt("Pos");


        switch (position){


            case R.drawable.icon_australia:

                imgPays.setImageResource(R.drawable.icon_australia);
                txtPays.setText("australie");

                break;

        }

    }
}
