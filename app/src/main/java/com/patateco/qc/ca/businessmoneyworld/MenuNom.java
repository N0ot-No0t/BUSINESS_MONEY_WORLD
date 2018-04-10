package com.patateco.qc.ca.businessmoneyworld;

import android.app.Activity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.widget.EditText;
import android.widget.TextView;

/**
 * Created by Adrian on 2018-04-10.
 */

public class MenuNom extends Activity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.pop_nom);

        DisplayMetrics dm = new DisplayMetrics();

        getWindowManager().getDefaultDisplay().getMetrics(dm);

        int width = dm.widthPixels;

        int height = dm.heightPixels;

        getWindow().setLayout((int)(width*.8),(int)(height*.6));

        String name = null;
        if (name == null) {
            TextView textView = (TextView) findViewById(R.id.enterName);
            textView.setText("Enter your name: ");
            EditText inputTxt = (EditText) findViewById(R.id.persName);
            name = inputTxt.getText().toString();
        }
        TextView textView = (TextView) findViewById(R.id.nameDisplay);
        textView.setText(name);


    }


}
