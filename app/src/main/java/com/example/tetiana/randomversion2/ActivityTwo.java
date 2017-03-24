package com.example.tetiana.randomversion2;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

public class ActivityTwo extends AppCompatActivity {

   TextView textViewResult;
    TextView textView3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_two);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

       textViewResult = (TextView) findViewById(R.id.textViewResult);
        textView3 = (TextView) findViewById(R.id.textView3);

        Intent intent = getIntent();
        String rezult = intent.getStringExtra("rezult");
        textViewResult.setText(rezult);


        Intent intentTwo = getIntent();
        String rezultTwo = intentTwo.getStringExtra("rezultTwo");
        textView3.setText(rezultTwo);

    }

}
