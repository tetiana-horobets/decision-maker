package com.example.tetiana.randomversion2;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    TextView textView2;
    TextView textView;
    List<List<String>> options = new ArrayList<>();
    View lastView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.myscreen);

        options.add(new ArrayList<String>());

        final EditText inputLine = (EditText) findViewById(R.id.inputLine);
        textView = (TextView) findViewById(R.id.textView);
        textView2 = (TextView) findViewById(R.id.textView2);
        Button buttonPlus = (Button) findViewById(R.id.buttonPlus);
        Button button2 = (Button) findViewById(R.id.button2);
        Button button3 = (Button) findViewById(R.id.randomizeButton);

        //находим наш linear который у нас под кнопкой add edittext в activity_main.xml
        final LinearLayout linear = (LinearLayout) findViewById(R.id.linear);
        final View firstView = getLayoutInflater().inflate(R.layout.custom_text_view, null);
        linear.addView(firstView);
        lastView = firstView;


        View.OnClickListener onClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (view.getId()) {
                    case R.id.buttonPlus:
                        final TextView text111 = (TextView) lastView.findViewById(R.id.textViewDynamic);
                        addVariant(inputLine, options.get(options.size() - 1), text111);
                        break;

                    case R.id.button2:
                            final View view1 = getLayoutInflater().inflate(R.layout.custom_text_view, null);
                            final TextView text = (TextView) view1.findViewById(R.id.textViewDynamic);
                        List<String> newList = new ArrayList<>();
                        options.add(newList);
                            //добавляем елементы в linearlayout
                            addVariant(inputLine, newList, text);
                            linear.addView(view1);
                            lastView = view1;

                        Button deleteField = (Button) view1.findViewById(R.id.buttonDelete);

                        deleteField.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view2) {
                                try {
                                    //получаем родительский view и удаляем его
                                    ((LinearLayout) view1.getParent()).removeView(view1);
                                } catch(IndexOutOfBoundsException ex) {
                                    ex.printStackTrace();
                                }
                            }
                        });


                        break;
                    case R.id.randomizeButton:
                        Random random = new Random();

                        Intent intent = new Intent(MainActivity.this, ActivityTwo.class);

                        String sentence = "";
                        for(List<String> option : options) {
                            int numberWords = option.size();
                            int randomNumber = random.nextInt(numberWords);
                            String randomWord = option.get(randomNumber);
                            sentence += " " + randomWord;
                        }
                        intent.putExtra("rezult", sentence.trim());

                        startActivity(intent);
                        break;
                }
            }

            private void addVariant(EditText editText, List<String> variants, TextView textView)  {
                String inputTextListTwo = editText.getText().toString();
                if (inputTextListTwo.trim().equals("")) {
                    return;
                }
                variants.add(inputTextListTwo);
                textView.setText(formatForTextView(variants));
                editText.getText().clear();
            }

        };

        buttonPlus.setOnClickListener(onClickListener);
        button2.setOnClickListener(onClickListener);
        button3.setOnClickListener(onClickListener);

    }

    @Override
    public void onSaveInstanceState(Bundle bundle) {

    }

    @Override
    public void onRestoreInstanceState(Bundle bundle) {
    }

    private String formatForTextView(List<String> strings) {
        StringBuilder builder = new StringBuilder();

        for (String string : strings) {
            builder.append(string);
            builder.append("\n");
        }

        return builder.toString();
    }


}
