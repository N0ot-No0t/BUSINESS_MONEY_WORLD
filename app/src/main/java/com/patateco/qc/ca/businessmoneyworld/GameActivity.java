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
    private ImageView selectedCountry;
    protected int selectedCountryCode;

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
                System.out.println("CC in GA "+selectedCountryCode);
                intent.putExtra("selectedCountry",selectedCountryCode);
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



        selectedCountry = (ImageView) this.findViewById(R.id.selectedCountry);


        ImageButton btnArgentina = (ImageButton) this.findViewById(R.id.btnArgentine);
        btnArgentina.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                selectedCountry.setImageResource(R.drawable.icon_argentina);
                selectedCountryCode = R.drawable.icon_argentina;

                System.out.println("CC in GA "+selectedCountryCode);

            }
        });


        ImageButton btnAustralia = (ImageButton) this.findViewById(R.id.btnAustralie);
        btnAustralia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                selectedCountry.setImageResource(R.drawable.icon_australia);
                selectedCountryCode = R.drawable.icon_australia;

            }
        });

        ImageButton btnBrazil = (ImageButton) this.findViewById(R.id.btnBresil);
        btnBrazil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                selectedCountry.setImageResource(R.drawable.icon_brazil);
                selectedCountryCode = R.drawable.icon_brazil;
            }
        });

        ImageButton btnCanada = (ImageButton) this.findViewById(R.id.btnCanada);
        btnCanada.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                selectedCountry.setImageResource(R.drawable.canada_icon);
                selectedCountryCode = R.drawable.canada_icon;

            }
        });

        ImageButton btnChina = (ImageButton) this.findViewById(R.id.btnChine);
        btnChina.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                selectedCountry.setImageResource(R.drawable.icon_china);
                selectedCountryCode = R.drawable.icon_china;

            }
        });

        ImageButton btnColombia = (ImageButton) this.findViewById(R.id.btnColombie);
        btnColombia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                selectedCountry.setImageResource(R.drawable.icon_colombia);
                selectedCountryCode = R.drawable.icon_colombia;

            }
        });

        ImageButton btnCuba = (ImageButton) this.findViewById(R.id.btnCuba);
        btnCuba.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                selectedCountry.setImageResource(R.drawable.icon_cuba);
                selectedCountryCode = R.drawable.icon_cuba;

            }
        });


        ImageButton btnCongo = (ImageButton) this.findViewById(R.id.btnCongo);
        btnCongo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                selectedCountry.setImageResource(R.drawable.icon_drc);
                selectedCountryCode = R.drawable.icon_drc;

            }
        });

        ImageButton btnFrance = (ImageButton) this.findViewById(R.id.btnFrance);
        btnFrance.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                selectedCountry.setImageResource(R.drawable.icon_france);
                selectedCountryCode = R.drawable.icon_france;

            }
        });


        ImageButton btnGermany = (ImageButton) this.findViewById(R.id.btnAllemagne);
        btnGermany.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                selectedCountry.setImageResource(R.drawable.icon_germany);
                selectedCountryCode = R.drawable.icon_germany;

            }
        });

        ImageButton btnIndia = (ImageButton) this.findViewById(R.id.btnInde);
        btnIndia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                selectedCountry.setImageResource(R.drawable.icon_india);
                selectedCountryCode = R.drawable.icon_india;

            }
        });

        ImageButton btnIran = (ImageButton) this.findViewById(R.id.btnIran);
        btnIran.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                selectedCountry.setImageResource(R.drawable.icon_iran);
                selectedCountryCode = R.drawable.icon_iran;

            }
        });

        ImageButton btnItaly = (ImageButton) this.findViewById(R.id.btnItalie);
        btnItaly.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                selectedCountry.setImageResource(R.drawable.icon_italie);
                selectedCountryCode = R.drawable.icon_italie;

            }
        });

        ImageButton btnJapan = (ImageButton) this.findViewById(R.id.btnJapon);
        btnJapan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                selectedCountry.setImageResource(R.drawable.icon_japan);
                selectedCountryCode = R.drawable.icon_japan;

            }
        });

        ImageButton btnMexico = (ImageButton) this.findViewById(R.id.btnMexique);
        btnMexico.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                selectedCountry.setImageResource(R.drawable.icon_mexico);
                selectedCountryCode = R.drawable.icon_mexico;

            }
        });

        ImageButton btnMorocco = (ImageButton) this.findViewById(R.id.btnMaroc);
        btnMorocco.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                selectedCountry.setImageResource(R.drawable.icon_morroco);
                selectedCountryCode = R.drawable.icon_morroco;

            }
        });

        ImageButton btnNorway = (ImageButton) this.findViewById(R.id.btnNorvege);
        btnNorway.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                selectedCountry.setImageResource(R.drawable.icon_norway);
                selectedCountryCode = R.drawable.icon_norway;

            }
        });

        ImageButton btnSouthAfrica = (ImageButton) this.findViewById(R.id.btnAfriqueS);
        btnSouthAfrica.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                selectedCountry.setImageResource(R.drawable.icon_rsa);
                selectedCountryCode = R.drawable.icon_rsa;

            }
        });

        ImageButton btnRussia = (ImageButton) this.findViewById(R.id.btnRussie);
        btnRussia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                selectedCountry.setImageResource(R.drawable.icon_russia);
                selectedCountryCode = R.drawable.icon_russia;

            }
        });

        ImageButton btnSaudiArabia = (ImageButton) this.findViewById(R.id.btnArabieS);
        btnSaudiArabia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                selectedCountry.setImageResource(R.drawable.icon_saudia_arabia);
                selectedCountryCode = R.drawable.icon_saudia_arabia;

            }
        });

        ImageButton btnSpain = (ImageButton) this.findViewById(R.id.btnEspagne);
        btnSpain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                selectedCountry.setImageResource(R.drawable.icon_spain);
                selectedCountryCode = R.drawable.icon_spain;

            }
        });

        ImageButton btnSweden = (ImageButton) this.findViewById(R.id.btnSuede);
        btnSweden.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                selectedCountry.setImageResource(R.drawable.icon_sweden);
                selectedCountryCode = R.drawable.icon_sweden;

            }
        });

        ImageButton btnUK = (ImageButton) this.findViewById(R.id.btnUK);
        btnUK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                selectedCountry.setImageResource(R.drawable.icon_uk);
                selectedCountryCode = R.drawable.icon_uk;

            }
        });

        ImageButton btnUS = (ImageButton) this.findViewById(R.id.btnUS);
        btnUS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                selectedCountry.setImageResource(R.drawable.icon_usa);
                selectedCountryCode = R.drawable.icon_usa;

            }
        });



    }

}
