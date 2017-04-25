package com.example.tetiana.randomversion2;

import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.view.View;
import android.widget.EditText;

class AddButtonListener implements View.OnClickListener {

    private final RecyclerView.Adapter adapter;
    private final EditText inputOption;
    private final InputConsumer consumer;

    AddButtonListener(RecyclerView.Adapter adapter, EditText inputOption, InputConsumer consumer) {
        this.adapter = adapter;
        this.inputOption = inputOption;
        this.consumer = consumer;
    }

    @Override
    public void onClick(View v) {
        Editable text = inputOption.getText();
        if (text.toString().trim().equals("")) {
            return;
        }
        consumer.consume(text.toString().trim());
        adapter.notifyDataSetChanged();
        text.clear();
    }
}
