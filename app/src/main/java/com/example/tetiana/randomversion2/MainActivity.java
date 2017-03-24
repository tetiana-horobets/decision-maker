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
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    EditText inputLine;
    EditText editText;
    TextView textView2;
    TextView textView;
    Button buttonPlus;
    Button button2;
    Button button3;
    TextView textViewResult;



    List<String> randomValues = new ArrayList<>();
    List<String> randomValuesListTwo = new ArrayList<>();
    Random random = new Random();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.myscreen);

        inputLine = (EditText) findViewById(R.id.inputLine);
        editText = (EditText) findViewById(R.id.editText);
        textView = (TextView) findViewById(R.id.textView);
        textView2 = (TextView) findViewById(R.id.textView2);
        buttonPlus = (Button) findViewById(R.id.buttonPlus);
        button2 = (Button) findViewById(R.id.button2);
        button3 = (Button) findViewById(R.id.button3);
        textViewResult = (TextView) findViewById(R.id.textViewResult);



        View.OnClickListener onClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                switch (view.getId()) {
                    case R.id.buttonPlus:
                        String inputText = inputLine.getText().toString();
                        if (inputText.trim().equals("")){
                            break;
                        }
                        randomValues.add(inputText);
                        StringBuilder builder = new StringBuilder();
                        for (String randomValue : randomValues) {
                            builder.append(randomValue);
                            builder.append("\n");
                        }

                        textView.setText(builder.toString());
                        inputLine.getText().clear();
                        break;
                    case R.id.button2:
                        String inputTextListTwo = editText.getText().toString();
                        if (inputTextListTwo.trim().equals("")){
                            break;
                        }
                        randomValuesListTwo.add(inputTextListTwo);
                        StringBuilder builderTwo = new StringBuilder();
                        for (String randomValueTwo : randomValuesListTwo) {
                            builderTwo.append(randomValueTwo);
                            builderTwo.append("\n");
                        }

                        textView2.setText(builderTwo.toString());
                        editText.getText().clear();
                        break;
                    case R.id.button3:
                        Intent intent = new Intent(MainActivity.this, ActivityTwo.class);
                        int numberWords = randomValues.size();
                        int randomNumber = random.nextInt(numberWords);
                        String randomWorld = randomValues.get(randomNumber);
                        intent.putExtra("rezult", randomWorld);

                        int numberWordsTwo = randomValuesListTwo.size();
                        int randomNumberTwo = random.nextInt(numberWordsTwo);
                        String randomWorldTwo = randomValuesListTwo.get(randomNumberTwo);
                        intent.putExtra("rezultTwo", randomWorldTwo);

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
