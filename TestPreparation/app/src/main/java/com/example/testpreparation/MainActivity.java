package com.example.testpreparation;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    //setting the recycler views
    RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;
    RecyclerView.Adapter adapter;

    ImageView image;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView =  findViewById(R.id.recycler_view);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        image = findViewById(R.id.imageView);

        adapter = new RecyclerAdapter();
        recyclerView.setAdapter(adapter);
    }

    public void setItemTopImage(int position) {
        if(position==0) {
            image.setImageResource(R.drawable.bathroom1);
            Intent intent = new Intent(this, SecondActivity.class);
            intent.putExtra("itemType", position);
            startActivity(intent);
        } else if (position==1) {
            image.setImageResource(R.drawable.bathroom2);
            Intent intent = new Intent(this, SecondActivity.class);
            intent.putExtra("itemType", position);
            startActivity(intent);

        } else if (position==2) {

            image.setImageResource(R.drawable.bedroom1);
            Intent intent = new Intent(this, SecondActivity.class);
            intent.putExtra("itemType", position);
            startActivity(intent);
        }
        // Add more conditions for other positions as needed
    }
}