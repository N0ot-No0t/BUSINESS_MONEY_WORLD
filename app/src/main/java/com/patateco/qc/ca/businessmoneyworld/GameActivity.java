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
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;


public class GameActivity extends AppCompatActivity {

    private ImageView imageView;
    private Button getImage;
protected PinchZoomPan pinchZoomPan;
    private Bitmap bitmap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        setContentView(R.layout.activity_game);

pinchZoomPan = (PinchZoomPan) findViewById(R.id.imgCarte);
//bitmap = (Bitmap) findViewById( R.id.imgCarte);

          final TextView txtTest = (TextView)findViewById(R.id.txtTest);



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
