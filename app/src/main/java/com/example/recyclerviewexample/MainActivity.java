package com.example.recyclerviewexample;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements RecycleAdapter.OnItemListener
{
    RecyclerView recyclerVIew;
    public static ArrayList<Recycling> recyclingArrayList = new ArrayList<Recycling>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        initialiseList();
        setUpRecycler();

    }

    private void initialiseList() {
        Recycling can = new Recycling("0", "Can", R.drawable.can, "Aliminium");
        Recycling cerealBox = new Recycling("1", "cerealBox", R.drawable.cerealbox, "Aliminium");
        Recycling envelope = new Recycling("2", "envelope", R.drawable.envolope, "Aliminium");
        Recycling newsPaper = new Recycling("3", "newsPaper", R.drawable.newspaper, "Aliminium");
        Recycling waterBottle = new Recycling("4", "waterBottle", R.drawable.waterbottle, "Aliminium");
        Recycling wineBottle = new Recycling("5", "wineBottle", R.drawable.winebottle, "Aliminium");

        recyclingArrayList.add(can);
        recyclingArrayList.add(cerealBox);
        recyclingArrayList.add(envelope);
        recyclingArrayList.add(newsPaper);
        recyclingArrayList.add(waterBottle);
        recyclingArrayList.add(wineBottle);
    }

    private void setUpRecycler() {
        recyclerVIew = findViewById(R.id.recyclerView);
        RecycleAdapter recycleAdapter = new RecycleAdapter(recyclingArrayList,this);

        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(getApplicationContext(), 3);
        recyclerVIew.setLayoutManager(layoutManager);
        recyclerVIew.setAdapter(recycleAdapter);

    }

    @Override
    public void onItemClick(int position)
    {
        Intent detailIntent = new Intent(this, DetailActivity.class);
        detailIntent.putExtra("position", position);
        startActivity(detailIntent);

    }
}