package com.example.tetiana.randomversion2;

import android.content.Intent;
import android.graphics.Rect;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private RandomSentence randomSentence = new RandomSentence(new Random());
    List<String> myList = new ArrayList();

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
        final RecyclerView linear = (RecyclerView) findViewById(R.id.linear);
        linear.setLayoutManager(new LinearLayoutManager(this));



        View.OnClickListener onClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (view.getId()) {
                    case R.id.buttonPlus:
                        final RecyclerViewAdapter adapter = new RecyclerViewAdapter(randomSentence.getOptions());

                        linear.setAdapter(adapter);
                        //myList.add(inputLine.getText().toString());
                        randomSentence.addWord(inputLine.getText().toString());
                        adapter.notifyDataSetChanged();
                        inputLine.getText().clear();
                        break;

                    case R.id.button2:
                        randomSentence.newList();
                        RecyclerViewAdapter2 adapter2 = new RecyclerViewAdapter2(randomSentence.getOptions());
                        linear.setAdapter(adapter2);
                        randomSentence.addWord(inputLine.getText().toString());
                        adapter2.notifyDataSetChanged();
                        inputLine.getText().clear();


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
        bundle.putParcelable("randomSentence", randomSentence);
    }

    @Override
    public void onRestoreInstanceState(Bundle bundle) {
        randomSentence = bundle.getParcelable("randomSentence");
        final LinearLayout linear = (LinearLayout) findViewById(R.id.linear);
        List<String> options = randomSentence.getOptions();
        for (int i = 0; i < options.size();i++) {
            String string = options.get(i);
            final View view1 = getLayoutInflater().inflate(R.layout.custom_text_view, null);
            final TextView text = (TextView) view1.findViewById(R.id.textViewDynamic);
            text.setText(string);
            linear.addView(view1);
            lastView = view1;
        }
    }

}
