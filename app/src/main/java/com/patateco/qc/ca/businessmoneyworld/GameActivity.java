package com.patateco.qc.ca.businessmoneyworld;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;


public class GameActivity extends AppCompatActivity {

    private ImageView imageView;
    private Button getImage;
    protected PinchZoomPan pinchZoomPan;
    private Bitmap bitmap;
    TextView montant;
    Personnage joueur = new Personnage(20,1000);
    Pays cuba = new Pays("dsad",1, "neutre");
    Pays canada = new Pays("dsad",1, "neutre");
    Pays usa = new Pays("dsad",1, "neutre");
    Pays mexique = new Pays("dsad",1, "neutre");
    Pays colombie = new Pays("dsad",1, "neutre");
    Pays bresil = new Pays("dsad",1, "neutre");
    Pays argentina = new Pays("dsad",1, "neutre");
    Pays espagne = new Pays("dsad",1, "neutre");
    Pays italie = new Pays("dsad",1, "neutre");
    Pays france = new Pays("dsad",1, "neutre");
    Pays angleterre = new Pays("dsad",1, "neutre");
    Pays allemagne = new Pays("dsad",1, "neutre");
    Pays suede = new Pays("dsad",1, "neutre");
    Pays norvege = new Pays("dsad",1, "neutre");
    Pays russie = new Pays("dsad",1, "neutre");
    Pays chine = new Pays("dsad",1, "neutre");
    Pays japon = new Pays("dsad",1, "neutre");
    Pays inde = new Pays("dsad",1, "neutre");
    Pays iran = new Pays("dsad",1, "neutre");
    Pays arabieSaoudite = new Pays("dsad",1, "neutre");
    Pays maroc = new Pays("dsad",1, "neutre");
    Pays RepublicDemocraticCongo = new Pays("dsad",1, "neutre");
    Pays afriqueSud = new Pays("dsad",1, "neutre");
    Pays Australie = new Pays("dsad",1, "neutre");


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        setContentView(R.layout.activity_game);



        final TextView txtTest = (TextView)findViewById(R.id.txtTest);
        montant = (TextView) findViewById(R.id.montant);
        int afficheMontant = joueur.getArgent();
        montant.setText(String.valueOf(afficheMontant));




        ImageButton btnSettings = (ImageButton) this.findViewById(R.id.btnSettings);
        btnSettings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txtTest.setText("Settings");
            }
        });

        ImageButton btnPers = (ImageButton) this.findViewById(R.id.btnPersonnage);

        btnPers.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txtTest.setText("Personnage");
                startActivity(new Intent(GameActivity.this,MenuPersonnage.class));

            }
        });

        ImageButton btnNews = (ImageButton) this.findViewById(R.id.btnNews);
        btnNews.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txtTest.setText("News");
            }
        });

        ImageButton btnAction = (ImageButton) this.findViewById(R.id.btnAction);
        btnAction.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txtTest.setText("Actions");
                startActivity(new Intent(GameActivity.this,MenuAction.class));
            }
        });

        ImageButton btnPays = (ImageButton) this.findViewById(R.id.btnPays);
        btnPays.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txtTest.setText("Pays");
                startActivity(new Intent(GameActivity.this,MenuPays.class));
            }
        });


        ImageButton btnNext = (ImageButton) this.findViewById(R.id.btnNext);
        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txtTest.setText("Next");
            }
        });









    }
}
