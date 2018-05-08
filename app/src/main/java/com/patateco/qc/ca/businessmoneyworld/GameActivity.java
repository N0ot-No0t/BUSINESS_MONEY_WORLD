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

import Database.MyDBHandler;


public class GameActivity extends AppCompatActivity {

    MyDBHandler myDB;

    private ImageView imageView;
    private Button getImage;
    Personnage joueur = new Personnage("Joe", 18, 1, 1000);
    private Bitmap bitmap;
    private ImageView selectedCountry;
    protected int selectedCountryCode = 0;
    protected int selectedOtherCountryCode = 0;
    boolean selected = false;
    boolean otherCountrySelected = false;

    ArrayList<Integer> imageInventaire = new ArrayList<Integer>();
    ArrayList<String> nomImage = new ArrayList<String>();

    ArrayList<ImageButton> listeBtnPays = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        setContentView(R.layout.activity_game);

        myDB = new MyDBHandler(this);


        double argent = joueur.getCash();
        TextView montant = (TextView) findViewById(R.id.montant);
        montant.setText(String.valueOf(argent));


        Bitmap bitmap = null;

        //imageView.setImageBitmap(bitmap);

        //final TextView txtTest = (TextView)findViewById(R.id.txtTest);

        imageView = (ImageView) this.findViewById(R.id.imgPays);

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
                bundle.putSerializable("listImage", imageInventaire);
                bundle1.putSerializable("listNom", nomImage);
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
                bundle.putSerializable("listImage", imageInventaire);
                bundle1.putSerializable("listNom", nomImage);
                intent.putExtras(bundle);
                intent.putExtras(bundle1);
                System.out.println("CC in GA " + selectedCountryCode);
                intent.putExtra("selectedCountry", selectedCountryCode);
                startActivity(intent);
            }
        });

        ImageButton btnPays = (ImageButton) this.findViewById(R.id.btnPays);
        btnPays.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(GameActivity.this, MenuPays.class));
            }
        });


        ImageButton btnNext = (ImageButton) this.findViewById(R.id.btnNext);
        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });


        selectedCountry = (ImageView) this.findViewById(R.id.selectedCountry);


        ImageButton btnArgentina = (ImageButton) this.findViewById(R.id.btnArgentine);
        btnArgentina.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                selectedOtherCountryCode = R.drawable.icon_argentina;

                if(selectedCountryCode == 0) {
                    selectedCountry.setImageResource(R.drawable.icon_argentina);
                    selectedCountryCode = R.drawable.icon_argentina;
                }

                else if(selectedCountryCode == selectedOtherCountryCode){

                    selectedCountry.setImageResource(R.drawable.white);
                    selectedCountryCode = 0;

                }

                else if(selectedCountryCode != 0){

                    selectedCountryCode = selectedOtherCountryCode;
                    selectedCountry.setImageResource(selectedOtherCountryCode);


                }

                else {
                    selectedCountry.setImageResource(R.drawable.white);
                    selectedCountryCode = 0;

                }


                System.out.println("CC in GA " + selectedCountryCode);

            }
        });


        ImageButton btnAustralia = (ImageButton) this.findViewById(R.id.btnAustralie);
        btnAustralia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                selectedOtherCountryCode = R.drawable.icon_australia;

                if(selectedCountryCode == 0) {
                    selectedCountry.setImageResource(R.drawable.icon_australia);
                    selectedCountryCode = R.drawable.icon_australia;
                }

                else if(selectedCountryCode == selectedOtherCountryCode){

                    selectedCountry.setImageResource(R.drawable.white);
                    selectedCountryCode = 0;

                }

                else if(selectedCountryCode != 0){

                    selectedCountryCode = selectedOtherCountryCode;
                    selectedCountry.setImageResource(selectedOtherCountryCode);


                }

                else {
                    selectedCountry.setImageResource(R.drawable.white);
                    selectedCountryCode = 0;

                }

            }
        });

        ImageButton btnBrazil = (ImageButton) this.findViewById(R.id.btnBresil);
        btnBrazil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                selectedOtherCountryCode = R.drawable.icon_brazil;

                if(selectedCountryCode == 0) {
                    selectedCountry.setImageResource(R.drawable.icon_brazil);
                    selectedCountryCode = R.drawable.icon_brazil;
                }

                else if(selectedCountryCode == selectedOtherCountryCode){

                    selectedCountry.setImageResource(R.drawable.white);
                    selectedCountryCode = 0;

                }

                else if(selectedCountryCode != 0){

                    selectedCountryCode = selectedOtherCountryCode;
                    selectedCountry.setImageResource(selectedOtherCountryCode);


                }

                else {
                    selectedCountry.setImageResource(R.drawable.white);
                    selectedCountryCode = 0;

                }


            }
        });

        ImageButton btnCanada = (ImageButton) this.findViewById(R.id.btnCanada);
        btnCanada.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                selectedOtherCountryCode = R.drawable.canada_icon;

                if(selectedCountryCode == 0) {
                    selectedCountry.setImageResource(R.drawable.canada_icon);
                    selectedCountryCode = R.drawable.canada_icon;
                }

                else if(selectedCountryCode == selectedOtherCountryCode){

                    selectedCountry.setImageResource(R.drawable.white);
                    selectedCountryCode = 0;

                }

                else if(selectedCountryCode != 0){

                    selectedCountryCode = selectedOtherCountryCode;
                    selectedCountry.setImageResource(selectedOtherCountryCode);


                }

                else {
                    selectedCountry.setImageResource(R.drawable.white);
                    selectedCountryCode = 0;

                }


            }
        });

        ImageButton btnChina = (ImageButton) this.findViewById(R.id.btnChine);
        btnChina.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                selectedOtherCountryCode = R.drawable.icon_china;

                if(selectedCountryCode == 0) {
                    selectedCountry.setImageResource(R.drawable.icon_china);
                    selectedCountryCode = R.drawable.icon_china;
                }

                else if(selectedCountryCode == selectedOtherCountryCode){

                    selectedCountry.setImageResource(R.drawable.white);
                    selectedCountryCode = 0;

                }

                else if(selectedCountryCode != 0){

                    selectedCountryCode = selectedOtherCountryCode;
                    selectedCountry.setImageResource(selectedOtherCountryCode);


                }

                else {
                    selectedCountry.setImageResource(R.drawable.white);
                    selectedCountryCode = 0;

                }

            }
        });

        ImageButton btnColombia = (ImageButton) this.findViewById(R.id.btnColombie);
        btnColombia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                selectedOtherCountryCode = R.drawable.icon_colombia;

                if(selectedCountryCode == 0) {
                    selectedCountry.setImageResource(R.drawable.icon_colombia);
                    selectedCountryCode = R.drawable.icon_colombia;
                }

                else if(selectedCountryCode == selectedOtherCountryCode){

                    selectedCountry.setImageResource(R.drawable.white);
                    selectedCountryCode = 0;

                }

                else if(selectedCountryCode != 0){

                    selectedCountryCode = selectedOtherCountryCode;
                    selectedCountry.setImageResource(selectedOtherCountryCode);


                }

                else {
                    selectedCountry.setImageResource(R.drawable.white);
                    selectedCountryCode = 0;

                }

            }
        });

        ImageButton btnCuba = (ImageButton) this.findViewById(R.id.btnCuba);
        btnCuba.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                selectedOtherCountryCode = R.drawable.icon_cuba;

                if(selectedCountryCode == 0) {
                    selectedCountry.setImageResource(R.drawable.icon_cuba);
                    selectedCountryCode = R.drawable.icon_cuba;
                }

                else if(selectedCountryCode == selectedOtherCountryCode){

                    selectedCountry.setImageResource(R.drawable.white);
                    selectedCountryCode = 0;

                }

                else if(selectedCountryCode != 0){

                    selectedCountryCode = selectedOtherCountryCode;
                    selectedCountry.setImageResource(selectedOtherCountryCode);


                }

                else {
                    selectedCountry.setImageResource(R.drawable.white);
                    selectedCountryCode = 0;

                }

            }
        });


        ImageButton btnCongo = (ImageButton) this.findViewById(R.id.btnCongo);
        btnCongo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                selectedOtherCountryCode = R.drawable.icon_drc;

                if(selectedCountryCode == 0) {
                    selectedCountry.setImageResource(R.drawable.icon_drc);
                    selectedCountryCode = R.drawable.icon_drc;
                }

                else if(selectedCountryCode == selectedOtherCountryCode){

                    selectedCountry.setImageResource(R.drawable.white);
                    selectedCountryCode = 0;

                }

                else if(selectedCountryCode != 0){

                    selectedCountryCode = selectedOtherCountryCode;
                    selectedCountry.setImageResource(selectedOtherCountryCode);


                }

                else {
                    selectedCountry.setImageResource(R.drawable.white);
                    selectedCountryCode = 0;

                }

            }
        });

        ImageButton btnFrance = (ImageButton) this.findViewById(R.id.btnFrance);
        btnFrance.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                selectedOtherCountryCode = R.drawable.icon_france;

                if(selectedCountryCode == 0) {
                    selectedCountry.setImageResource(R.drawable.icon_france);
                    selectedCountryCode = R.drawable.icon_france;
                }

                else if(selectedCountryCode == selectedOtherCountryCode){

                    selectedCountry.setImageResource(R.drawable.white);
                    selectedCountryCode = 0;

                }

                else if(selectedCountryCode != 0){

                    selectedCountryCode = selectedOtherCountryCode;
                    selectedCountry.setImageResource(selectedOtherCountryCode);


                }

                else {
                    selectedCountry.setImageResource(R.drawable.white);
                    selectedCountryCode = 0;

                }

            }
        });


        ImageButton btnGermany = (ImageButton) this.findViewById(R.id.btnAllemagne);
        btnGermany.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                selectedOtherCountryCode = R.drawable.icon_germany;

                if(selectedCountryCode == 0) {
                    selectedCountry.setImageResource(R.drawable.icon_germany);
                    selectedCountryCode = R.drawable.icon_germany;
                }

                else if(selectedCountryCode == selectedOtherCountryCode){

                    selectedCountry.setImageResource(R.drawable.white);
                    selectedCountryCode = 0;

                }

                else if(selectedCountryCode != 0){

                    selectedCountryCode = selectedOtherCountryCode;
                    selectedCountry.setImageResource(selectedOtherCountryCode);


                }

                else {
                    selectedCountry.setImageResource(R.drawable.white);
                    selectedCountryCode = 0;

                }

            }
        });

        ImageButton btnIndia = (ImageButton) this.findViewById(R.id.btnInde);
        btnIndia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                selectedOtherCountryCode = R.drawable.icon_india;

                if(selectedCountryCode == 0) {
                    selectedCountry.setImageResource(R.drawable.icon_india);
                    selectedCountryCode = R.drawable.icon_india;
                }

                else if(selectedCountryCode == selectedOtherCountryCode){

                    selectedCountry.setImageResource(R.drawable.white);
                    selectedCountryCode = 0;

                }

                else if(selectedCountryCode != 0){

                    selectedCountryCode = selectedOtherCountryCode;
                    selectedCountry.setImageResource(selectedOtherCountryCode);


                }

                else {
                    selectedCountry.setImageResource(R.drawable.white);
                    selectedCountryCode = 0;

                }

            }
        });

        ImageButton btnIran = (ImageButton) this.findViewById(R.id.btnIran);
        btnIran.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                selectedOtherCountryCode = R.drawable.icon_iran;

                if(selectedCountryCode == 0) {
                    selectedCountry.setImageResource(R.drawable.icon_iran);
                    selectedCountryCode = R.drawable.icon_iran;
                }

                else if(selectedCountryCode == selectedOtherCountryCode){

                    selectedCountry.setImageResource(R.drawable.white);
                    selectedCountryCode = 0;

                }

                else if(selectedCountryCode != 0){

                    selectedCountryCode = selectedOtherCountryCode;
                    selectedCountry.setImageResource(selectedOtherCountryCode);


                }

                else {
                    selectedCountry.setImageResource(R.drawable.white);
                    selectedCountryCode = 0;

                }

            }
        });

        ImageButton btnItaly = (ImageButton) this.findViewById(R.id.btnItalie);
        btnItaly.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                selectedOtherCountryCode = R.drawable.icon_iran;

                if(selectedCountryCode == 0) {
                    selectedCountry.setImageResource(R.drawable.icon_iran);
                    selectedCountryCode = R.drawable.icon_iran;
                }

                else if(selectedCountryCode == selectedOtherCountryCode){

                    selectedCountry.setImageResource(R.drawable.white);
                    selectedCountryCode = 0;

                }

                else if(selectedCountryCode != 0){

                    selectedCountryCode = selectedOtherCountryCode;
                    selectedCountry.setImageResource(selectedOtherCountryCode);


                }

                else {
                    selectedCountry.setImageResource(R.drawable.white);
                    selectedCountryCode = 0;

                }

            }
        });

        ImageButton btnJapan = (ImageButton) this.findViewById(R.id.btnJapon);
        btnJapan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                selectedOtherCountryCode = R.drawable.icon_japan;

                if(selectedCountryCode == 0) {
                    selectedCountry.setImageResource(R.drawable.icon_japan);
                    selectedCountryCode = R.drawable.icon_japan;
                }

                else if(selectedCountryCode == selectedOtherCountryCode){

                    selectedCountry.setImageResource(R.drawable.white);
                    selectedCountryCode = 0;

                }

                else if(selectedCountryCode != 0){

                    selectedCountryCode = selectedOtherCountryCode;
                    selectedCountry.setImageResource(selectedOtherCountryCode);


                }

                else {
                    selectedCountry.setImageResource(R.drawable.white);
                    selectedCountryCode = 0;

                }

            }
        });

        ImageButton btnMexico = (ImageButton) this.findViewById(R.id.btnMexique);
        btnMexico.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                selectedOtherCountryCode = R.drawable.icon_mexico;

                if(selectedCountryCode == 0) {
                    selectedCountry.setImageResource(R.drawable.icon_mexico);
                    selectedCountryCode = R.drawable.icon_mexico;
                }

                else if(selectedCountryCode == selectedOtherCountryCode){

                    selectedCountry.setImageResource(R.drawable.white);
                    selectedCountryCode = 0;

                }

                else if(selectedCountryCode != 0){

                    selectedCountryCode = selectedOtherCountryCode;
                    selectedCountry.setImageResource(selectedOtherCountryCode);


                }

                else {
                    selectedCountry.setImageResource(R.drawable.white);
                    selectedCountryCode = 0;

                }

            }
        });

        ImageButton btnMorocco = (ImageButton) this.findViewById(R.id.btnMaroc);
        btnMorocco.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                selectedOtherCountryCode = R.drawable.icon_morroco;

                if(selectedCountryCode == 0) {
                    selectedCountry.setImageResource(R.drawable.icon_morroco);
                    selectedCountryCode = R.drawable.icon_morroco;
                }

                else if(selectedCountryCode == selectedOtherCountryCode){

                    selectedCountry.setImageResource(R.drawable.white);
                    selectedCountryCode = 0;

                }

                else if(selectedCountryCode != 0){

                    selectedCountryCode = selectedOtherCountryCode;
                    selectedCountry.setImageResource(selectedOtherCountryCode);


                }

                else {
                    selectedCountry.setImageResource(R.drawable.white);
                    selectedCountryCode = 0;

                }

            }
        });

        ImageButton btnNorway = (ImageButton) this.findViewById(R.id.btnNorvege);
        btnNorway.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                selectedOtherCountryCode = R.drawable.icon_norway;

                if(selectedCountryCode == 0) {
                    selectedCountry.setImageResource(R.drawable.icon_norway);
                    selectedCountryCode = R.drawable.icon_norway;
                }

                else if(selectedCountryCode == selectedOtherCountryCode){

                    selectedCountry.setImageResource(R.drawable.white);
                    selectedCountryCode = 0;

                }

                else if(selectedCountryCode != 0){

                    selectedCountryCode = selectedOtherCountryCode;
                    selectedCountry.setImageResource(selectedOtherCountryCode);


                }

                else {
                    selectedCountry.setImageResource(R.drawable.white);
                    selectedCountryCode = 0;

                }

            }
        });

        ImageButton btnSouthAfrica = (ImageButton) this.findViewById(R.id.btnAfriqueS);
        btnSouthAfrica.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                selectedOtherCountryCode = R.drawable.icon_rsa;

                if(selectedCountryCode == 0) {
                    selectedCountry.setImageResource(R.drawable.icon_rsa);
                    selectedCountryCode = R.drawable.icon_rsa;
                }

                else if(selectedCountryCode == selectedOtherCountryCode){

                    selectedCountry.setImageResource(R.drawable.white);
                    selectedCountryCode = 0;

                }

                else if(selectedCountryCode != 0){

                    selectedCountryCode = selectedOtherCountryCode;
                    selectedCountry.setImageResource(selectedOtherCountryCode);


                }

                else {
                    selectedCountry.setImageResource(R.drawable.white);
                    selectedCountryCode = 0;

                }

            }
        });

        ImageButton btnRussia = (ImageButton) this.findViewById(R.id.btnRussie);
        btnRussia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                selectedOtherCountryCode = R.drawable.icon_russia;

                if(selectedCountryCode == 0) {
                    selectedCountry.setImageResource(R.drawable.icon_russia);
                    selectedCountryCode = R.drawable.icon_russia;
                }

                else if(selectedCountryCode == selectedOtherCountryCode){

                    selectedCountry.setImageResource(R.drawable.white);
                    selectedCountryCode = 0;

                }

                else if(selectedCountryCode != 0){

                    selectedCountryCode = selectedOtherCountryCode;
                    selectedCountry.setImageResource(selectedOtherCountryCode);


                }

                else {
                    selectedCountry.setImageResource(R.drawable.white);
                    selectedCountryCode = 0;

                }

            }
        });

        ImageButton btnSaudiArabia = (ImageButton) this.findViewById(R.id.btnArabieS);
        btnSaudiArabia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                selectedOtherCountryCode = R.drawable.icon_saudia_arabia;

                if(selectedCountryCode == 0) {
                    selectedCountry.setImageResource(R.drawable.icon_saudia_arabia);
                    selectedCountryCode = R.drawable.icon_saudia_arabia;
                }

                else if(selectedCountryCode == selectedOtherCountryCode){

                    selectedCountry.setImageResource(R.drawable.white);
                    selectedCountryCode = 0;

                }

                else if(selectedCountryCode != 0){

                    selectedCountryCode = selectedOtherCountryCode;
                    selectedCountry.setImageResource(selectedOtherCountryCode);


                }

                else {
                    selectedCountry.setImageResource(R.drawable.white);
                    selectedCountryCode = 0;

                }

            }
        });

        ImageButton btnSpain = (ImageButton) this.findViewById(R.id.btnEspagne);
        btnSpain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                selectedOtherCountryCode = R.drawable.icon_spain;

                if(selectedCountryCode == 0) {
                    selectedCountry.setImageResource(R.drawable.icon_spain);
                    selectedCountryCode = R.drawable.icon_spain;
                }

                else if(selectedCountryCode == selectedOtherCountryCode){

                    selectedCountry.setImageResource(R.drawable.white);
                    selectedCountryCode = 0;

                }

                else if(selectedCountryCode != 0){

                    selectedCountryCode = selectedOtherCountryCode;
                    selectedCountry.setImageResource(selectedOtherCountryCode);


                }

                else {
                    selectedCountry.setImageResource(R.drawable.white);
                    selectedCountryCode = 0;

                }

            }
        });

        ImageButton btnSweden = (ImageButton) this.findViewById(R.id.btnSuede);
        btnSweden.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                selectedOtherCountryCode = R.drawable.icon_sweden;

                if(selectedCountryCode == 0) {
                    selectedCountry.setImageResource(R.drawable.icon_sweden);
                    selectedCountryCode = R.drawable.icon_sweden;
                }

                else if(selectedCountryCode == selectedOtherCountryCode){

                    selectedCountry.setImageResource(R.drawable.white);
                    selectedCountryCode = 0;

                }

                else if(selectedCountryCode != 0){

                    selectedCountryCode = selectedOtherCountryCode;
                    selectedCountry.setImageResource(selectedOtherCountryCode);


                }

                else {
                    selectedCountry.setImageResource(R.drawable.white);
                    selectedCountryCode = 0;

                }

            }
        });

        ImageButton btnUK = (ImageButton) this.findViewById(R.id.btnUK);
        btnUK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                selectedOtherCountryCode = R.drawable.icon_uk;

                if(selectedCountryCode == 0) {
                    selectedCountry.setImageResource(R.drawable.icon_uk);
                    selectedCountryCode = R.drawable.icon_uk;
                }

                else if(selectedCountryCode == selectedOtherCountryCode){

                    selectedCountry.setImageResource(R.drawable.white);
                    selectedCountryCode = 0;

                }

                else if(selectedCountryCode != 0){

                    selectedCountryCode = selectedOtherCountryCode;
                    selectedCountry.setImageResource(selectedOtherCountryCode);


                }

                else {
                    selectedCountry.setImageResource(R.drawable.white);
                    selectedCountryCode = 0;

                }

            }
        });

        ImageButton btnUS = (ImageButton) this.findViewById(R.id.btnUS);
        btnUS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                selectedOtherCountryCode = R.drawable.icon_usa;

                if(selectedCountryCode == 0) {
                    selectedCountry.setImageResource(R.drawable.icon_usa);
                    selectedCountryCode = R.drawable.icon_usa;
                }

                else if(selectedCountryCode == selectedOtherCountryCode){

                    selectedCountry.setImageResource(R.drawable.white);
                    selectedCountryCode = 0;

                }

                else if(selectedCountryCode != 0){

                    selectedCountryCode = selectedOtherCountryCode;
                    selectedCountry.setImageResource(selectedOtherCountryCode);


                }

                else {
                    selectedCountry.setImageResource(R.drawable.white);
                    selectedCountryCode = 0;

                }

            }
        });


    }

}
