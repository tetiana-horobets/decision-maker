package com.example.tetiana.randomversion2;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.Arrays;
import java.util.List;

public class InputActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.input_screen);

        ListView childListView = (ListView) findViewById(R.id.childListView);
        ListView childListView2 = (ListView) findViewById(R.id.childListView2);


        List<String> content = Arrays.asList("Kate", "John");
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, R.layout.list_item, R.id.optionText, content);
        childListView.setAdapter(adapter);

        List<String> content2 = Arrays.asList("Washes dishes", "Cleans up apartment");
        ArrayAdapter<String> adapter2 = new ArrayAdapter<>(this, R.layout.list_item, R.id.optionText, content2);
        childListView2.setAdapter(adapter2);
    }
}
