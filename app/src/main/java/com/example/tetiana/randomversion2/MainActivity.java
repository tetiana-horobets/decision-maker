package com.example.tetiana.randomversion2;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    EditText inputLine;
    TextView textView2;
    Button buttonPlus;
    Button button2;
    Button button3;

    List<String> randomValues = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.myscreen);

        inputLine = (EditText) findViewById(R.id.inputLine);
        textView2 = (TextView) findViewById(R.id.textView2);
        buttonPlus = (Button) findViewById(R.id.buttonPlus);
        button2 = (Button) findViewById(R.id.button2);
        button3 = (Button) findViewById(R.id.button3);


        View.OnClickListener onClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                switch (view.getId()) {
                    case R.id.buttonPlus:
                        String inputText = inputLine.getText().toString();
                        if (inputText.equals("") || inputText.equals(" ") || inputText.equals("  ")){
                            break;
                        }
                        randomValues.add(inputText);
                        StringBuilder builder = new StringBuilder();
                        for (String randomValue : randomValues) {
                            builder.append(randomValue);
                            builder.append("\n");
                        }

                        textView2.setText(builder.toString());
                        inputLine.getText().clear();
                        break;
                    case R.id.button2:
                        textView2.setText("button New");
                        break;
                    case R.id.button3:
                        Intent intent = new Intent(MainActivity.this, ActivityTwo.class);
                        startActivity(intent);
                        break;
                }
            }

        };
        buttonPlus.setOnClickListener(onClickListener);
        button2.setOnClickListener(onClickListener);
        button3.setOnClickListener(onClickListener);

    }
}
