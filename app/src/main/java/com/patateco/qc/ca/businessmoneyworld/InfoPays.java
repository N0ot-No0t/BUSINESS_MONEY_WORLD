package com.patateco.qc.ca.businessmoneyworld;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
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
        setContentView(R.layout.custom_layout);

        Bundle bundle = getIntent().getExtras();

        ImageView imgPays = findViewById(R.id.imgPays);

        TextView txtPays = findViewById(R.id.nom);



        TextView txtDescription = findViewById(R.id.txtDescription);

        ConstraintLayout constraintLayout = findViewById(R.id.constraintLayout2);
        constraintLayout.setBackgroundColor(Color.RED);




        position = bundle.getInt("Pos");

        System.out.println("####position: "+position);


        switch (position){


            case 0:
                constraintLayout.setBackgroundColor(Color.CYAN);
                imgPays.setImageResource(R.drawable.icon_argentina);
                txtPays.setText("Argentine");
                txtDescription.setText("Pays de l'Amérique du Sud avec l'espagnol comme langue officielle." +
                        "Le pays est très riche en matière de bois, de caoutchouc et en minéraux");

                break;
            case 3:
                constraintLayout.setBackgroundColor(Color.YELLOW);
                imgPays.setImageResource(R.drawable.canada_icon);
                txtPays.setText("Canada");
                txtDescription.setText("Pays de l'Amérique du Nord et voisin des États-Unis ayant comme langues officielles l'anglais de le français. Ce pays regorge de forêts naturelles qui s'étendent sur tout le territoire. Additionnellement, quelques réserves de pétrole y sont aussi présentes.");

                break;

        }

    }
}
