package com.patateco.qc.ca.businessmoneyworld;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.graphics.Bitmap;
import android.net.Uri;
import android.nfc.Tag;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;


public class GameActivity extends AppCompatActivity {

    private ImageView imageView;
    private Button getImage;
    Personnage joueur = new Personnage("Joe",18,1,1000);
    private Bitmap bitmap;

    ArrayList<Integer> imageInventaire = new ArrayList<Integer>();
    ArrayList<String> nomImage = new ArrayList<String>();

    ArrayList<ImageButton> listeBtnPays = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        setContentView(R.layout.activity_game);

        double argent = joueur.getCash();
        TextView montant = (TextView)findViewById(R.id.montant);
        montant.setText(String.valueOf(argent));




        Bitmap bitmap = null;

        //imageView.setImageBitmap(bitmap);

          //final TextView txtTest = (TextView)findViewById(R.id.txtTest);

          imageView =(ImageView) this.findViewById(R.id.img);

        ImageButton btnSettings = (ImageButton) this.findViewById(R.id.btnSettings);
        btnSettings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        ImageButton btnPers = (ImageButton) this.findViewById(R.id.btnPersonnage);

        btnPers.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                imageInventaire.add(R.drawable.aluminium);
                nomImage.add("aluminium");
                Intent intent = new Intent(GameActivity.this, MenuPersonnage.class);
                Bundle bundle = new Bundle();
                Bundle bundle1 = new Bundle();
                bundle.putSerializable("listImage",imageInventaire);
                bundle1.putSerializable("listNom",nomImage);
                intent.putExtras(bundle);
                intent.putExtras(bundle1);
                startActivity(intent);
            }
        });

        ImageButton btnNews = (ImageButton) this.findViewById(R.id.btnNews);
        btnNews.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        ImageButton btnAction = (ImageButton) this.findViewById(R.id.btnAction);
        btnAction.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(GameActivity.this, MenuAction.class);
                Bundle bundle = new Bundle();
                Bundle bundle1 = new Bundle();
                bundle.putSerializable("listImage",imageInventaire);
                bundle1.putSerializable("listNom",nomImage);
                intent.putExtras(bundle);
                intent.putExtras(bundle1);
                startActivity(intent);
            }
        });

        ImageButton btnPays = (ImageButton) this.findViewById(R.id.btnPays);
        btnPays.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(GameActivity.this,MenuPays.class));
            }
        });


        ImageButton btnNext = (ImageButton) this.findViewById(R.id.btnNext);
        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });





















    }


    public ImageButton creerListener(int btn){

        ImageButton imgBtn = (ImageButton) this.findViewById(R.id.nom);

        imgBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //txtTest.setText(imgBtn.getTag());
            }
        });

        return imgBtn;

    }

}
