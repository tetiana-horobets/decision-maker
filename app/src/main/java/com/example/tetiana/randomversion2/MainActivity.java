package com.example.tetiana.randomversion2;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private RandomSentence randomSentence = new RandomSentence(new Random());

    View lastView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.myscreen);

        final EditText inputLine = (EditText) findViewById(R.id.inputLine);
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
                        randomSentence.addWord(inputLine.getText().toString());
                        addVariant(inputLine, text111);
                        break;

                    case R.id.button2:
                        final View view1 = getLayoutInflater().inflate(R.layout.custom_text_view, null);
                        final TextView text = (TextView) view1.findViewById(R.id.textViewDynamic);
                        randomSentence.newList();
                        //добавляем елементы в linearlayout
                        addVariant(inputLine, text);
                        linear.addView(view1);
                        lastView = view1;

                        Button deleteField = (Button) view1.findViewById(R.id.buttonDelete);

                        deleteField.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view2) {
                                try {
                                    //получаем родительский view и удаляем его
                                    ((LinearLayout) view1.getParent()).removeView(view1);
                                } catch (IndexOutOfBoundsException ex) {
                                    ex.printStackTrace();
                                }
                            }
                        });


                        break;
                    case R.id.randomizeButton:
                        Intent intent = new Intent(MainActivity.this, ActivityTwo.class);
                        intent.putExtra("rezult", randomSentence.getSentence());
                        startActivity(intent);
                        break;
                }
            }

            private void addVariant(EditText editText, TextView textView) {
                String inputTextListTwo = editText.getText().toString();
                if (inputTextListTwo.trim().equals("")) {
                    return;
                }
                textView.append(editText.getText() + "\n");
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
}
