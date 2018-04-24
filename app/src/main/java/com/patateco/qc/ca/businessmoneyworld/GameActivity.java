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

    private Bitmap bitmap;

    ArrayList<ImageButton> listeBtnPays = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        setContentView(R.layout.activity_game);

        for (int i = 0; i < 25;i++){

            //listeBtnPays.get(i) = new ImageButton();

        }

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

                startActivity(new Intent(GameActivity.this,MenuPersonnage.class));
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

                startActivity(new Intent(GameActivity.this,MenuAction.class));

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
