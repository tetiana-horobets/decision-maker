package com.example.tetiana.randomversion2;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.result_screen);

        TextView resultText = (TextView) findViewById(R.id.resultText);
        String result = getIntent().getStringExtra("result");
        resultText.setText(result);
    }
}
