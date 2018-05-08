package com.patateco.qc.ca.businessmoneyworld;


import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import java.util.ArrayList;



/**
 * Created by Noot on 13/03/2018.
 */




public class MenuPersonnage extends Activity {
    ArrayList<Integer> imageInventaire;
    ArrayList<String> nomImage;


    private  Button btnSaveName;
    private EditText editTxtName;
    private TextView txtName;
    private Button btnInventaire;


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



        btnSaveName= (Button) findViewById(R.id.btnSave);
        editTxtName = (EditText) findViewById(R.id.editTextName);
        txtName = (TextView) findViewById(R.id.txtName);
        btnInventaire = (Button) findViewById(R.id.btnInventaire);

        btnInventaire.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


            }
        });



        btnSaveName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                saveInfo(v);
                displayName(v);
            }
        });}


    //save user info
    public void saveInfo(View view){
        SharedPreferences sharedPref = getSharedPreferences("userName",Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();


        editor.putString("username",editTxtName.getText().toString());
        editor.apply();

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


        Toast.makeText(this, "Saved!", Toast.LENGTH_LONG).show();
    }
    //get saved data
    public void displayName(View view){
        SharedPreferences sharedPref = getSharedPreferences("userName",Context.MODE_PRIVATE);
        String name = sharedPref.getString("userName",editTxtName.getText().toString());
        txtName.setText(name);
        editTxtName.setVisibility(View.GONE);
    }

}
