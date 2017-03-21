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

    public static final String APP_PREFERENCES = "mysettings";


    EditText inputLine;
    TextView textView2;
    Button buttonPlus;
    Button button2;
    Button button3;

    SharedPreferences mSettings;

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

      //  final SharedPreferences[] sPref = new SharedPreferences[10]; // штука для зберігання тексту
       // final String SAVED_TEXT = "saved text";// штука для зберігання тексту

        mSettings = getSharedPreferences(APP_PREFERENCES, Context.MODE_PRIVATE);
        inputLine = (EditText) findViewById(R.id.inputLine);
        textView2 = (TextView) findViewById(R.id.textView2);

        View.OnClickListener onClickListener = new View.OnClickListener() {


            @Override
            public void onClick(View view) {

                switch (view.getId()) {
                    case R.id.buttonPlus:
                        String inputText = inputLine.getText().toString(); // SaveText();//метод для зберігання тексту описаний нижче
                        randomValues.add(inputText);

                        StringBuilder builder = new StringBuilder();
                        for(String randomValue : randomValues) {
                            builder.append(randomValue);
                            builder.append("\n");
                        }

                        textView2.setText(builder.toString());

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

          /*  private void SaveText() {//метод для зберігання текст
                sPref[0] = getPreferences(MODE_PRIVATE);
                SharedPreferences.Editor ed = sPref[0].edit();
                ed.putString(SAVED_TEXT, inputLine.getText().toString());
                ed.commit();
                Toast.makeText(MainActivity.this, "Text saved ", Toast.LENGTH_SHORT).show();

            }*/


        };


        buttonPlus.setOnClickListener(onClickListener);
        button2.setOnClickListener(onClickListener);
        button3.setOnClickListener(onClickListener);


    }





        /* buttonPlus.setOnClickListener(new View.OnClickListener() { // Спосіб створення кнопки номер 1
            @Override
            //Коли нажимають кнопку setOnClickListener реагує і виконує метод OnClickListener()
            public void onClick(View v) {
                //  В метод setOnClickListener подається обєкт View.OnClickListener(). йому кнопка доручить обробляти нажатия
                textView2.setText("Plass word 1"); // тут можна написати. щоб після нажимання кнопки текст змінився

            }
        });


        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView2.setText("Random");
            }
        }); */




    /*public void clickButton2(View view) { // Спосіб створення кнопки 3
        textView2.setText("New list");// в xml в полі потрібної кнопки створюємо android:onClick="clickButton2"(створити потрібно для 2 екранів) і тут створюємо public метод,

    }*/
}
