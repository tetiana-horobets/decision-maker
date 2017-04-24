package com.example.tetiana.randomversion2;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
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
        Button buttonAddList = (Button) findViewById(R.id.buttonAddList);

        final RandomSentence randomSentence = new RandomSentence(new Random());
        final OptionsListAdapter adapter = new OptionsListAdapter(this, randomSentence.getOptions());
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        buttonAddOption.setOnClickListener(new AddButtonListener(adapter, inputOption, new InputConsumer() {
            @Override
            public void consume(String str) {
                randomSentence.addWord(str);
            }
        }));

        buttonAddList.setOnClickListener(new AddButtonListener(adapter, inputOption, new InputConsumer() {
            @Override
            public void consume(String str) {
                randomSentence.newList(str);
            }
        }));

        int dragDirections = ItemTouchHelper.UP | ItemTouchHelper.DOWN;
        int swipeDirections = ItemTouchHelper.START | ItemTouchHelper.END;

        new ItemTouchHelper(new ItemTouchHelper.SimpleCallback(dragDirections, swipeDirections) {
            @Override
            public boolean onMove(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder target) {
                return true;
            }

            @Override
            public void onSwiped(RecyclerView.ViewHolder viewHolder, int direction) {
                adapter.onDeleteElement(viewHolder.getAdapterPosition());
            }
        }).attachToRecyclerView(recyclerView);
    }
}
