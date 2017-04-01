package com.example.tetiana.randomversion2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    TextView textView2;
    TextView textView;
    List<String> randomValues = new ArrayList<>();
    List<String> randomValuesListTwo = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.myscreen);


        final EditText inputLine = (EditText) findViewById(R.id.inputLine);
        textView = (TextView) findViewById(R.id.textView);
        textView2 = (TextView) findViewById(R.id.textView2);
        Button buttonPlus = (Button) findViewById(R.id.buttonPlus);
        Button button2 = (Button) findViewById(R.id.button2);
        Button button3 = (Button) findViewById(R.id.randomizeButton);

        View.OnClickListener onClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                switch (view.getId()) {
                    case R.id.buttonPlus:
                        addVariant(inputLine,randomValues,textView);
                        break;

                    case R.id.button2:
                        addVariant(inputLine, randomValuesListTwo, textView2);
                        break;
                    case R.id.randomizeButton:
                        Random random = new Random();

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
        bundle.putStringArrayList("randomValues", new ArrayList<>(randomValues));
        bundle.putStringArrayList("randomValues2", new ArrayList<>(randomValuesListTwo));
    }

    @Override
    public void onRestoreInstanceState(Bundle bundle) {
        List<String> randomValues = bundle.getStringArrayList("randomValues");
        List<String> randomValues2 = bundle.getStringArrayList("randomValues2");

        textView.setText(formatForTextView(randomValues));
        textView2.setText(formatForTextView(randomValues2));
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
