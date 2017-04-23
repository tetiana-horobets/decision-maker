package com.example.tetiana.randomversion2;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.Arrays;
import java.util.List;

public class InputActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.input_screen);

        List<List<String>> options = Arrays.asList(
                Arrays.asList("Kate", "John", "Jane"),
                Arrays.asList("Washes dishes", "Cleans up apartment"),
                Arrays.asList("Every Friday", "Every Sunday"),
                Arrays.asList("Each even month", "Each odd month")
        );

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        recyclerView.setAdapter(new OptionsListAdapter(this, options));
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
}
