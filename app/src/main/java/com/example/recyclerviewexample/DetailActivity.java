package com.example.recyclerviewexample;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class DetailActivity extends AppCompatActivity
{
    private ImageView recycleImage;
    private TextView recycleText;

    Recycling selectedRecycling;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        setUpViews();
        getRecycling();

    }

    private void setUpViews() {
        recycleImage = findViewById(R.id.recyclerDetailImage);
        recycleText = findViewById(R.id.recyclerDetailText);

    }

    private void getRecycling() {
        Intent previousIntent = getIntent();
        int position = previousIntent.getIntExtra("position", 0);
        selectedRecycling = MainActivity.recyclingArrayList.get(position);
        recycleImage.setImageResource(selectedRecycling.getImage());
        recycleText.setText(selectedRecycling.getName());

    }
}