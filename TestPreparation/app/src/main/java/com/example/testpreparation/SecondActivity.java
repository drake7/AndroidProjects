package com.example.testpreparation;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        int itemType = getIntent().getIntExtra("itemType",0);

        // set up the RecyclerView
        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        System.out.println(itemType+"***********************");
        RecyclerAdapter2 adapter = new RecyclerAdapter2(itemType);
        recyclerView.setAdapter(adapter);

        // set up the back button
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
}