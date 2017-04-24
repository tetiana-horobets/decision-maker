package com.example.tetiana.randomversion2;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.Random;

public class InputActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.input_screen);

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        final EditText inputOption = (EditText) findViewById(R.id.inputOption);
        Button buttonAddOption = (Button) findViewById(R.id.buttonAddOption);

        final RandomSentence randomSentence = new RandomSentence(new Random());
        final OptionsListAdapter adapter = new OptionsListAdapter(this, randomSentence.getOptions());
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));


        buttonAddOption.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String typedText = inputOption.getText().toString();
                randomSentence.addWord(typedText);
                adapter.notifyDataSetChanged();
                inputOption.getText().clear();
            }
        });
    }
}
