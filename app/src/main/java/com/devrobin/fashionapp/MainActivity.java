package com.devrobin.fashionapp;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecycleViewAdapter viewAdapter;
    private StaggeredGridLayoutManager manager;
    private List<row> applist;
    private RecyclerView recyclerView;


    private int[] covers = new int[]{
            R.drawable.fash1,
            R.drawable.fash2,
            R.drawable.fash3,
            R.drawable.fash4,
            R.drawable.fash5,
            R.drawable.fash6,
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);


        recyclerView = findViewById(R.id.recycelView);

        //Getting Data
        applist = new ArrayList<>();

        //Adapter and Layout
        viewAdapter = new RecycleViewAdapter(this, applist);
        manager = new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);

        //set Adapter
        recyclerView.setLayoutManager(manager);
        recyclerView.setAdapter(viewAdapter);


        //Insert data
        InitializeDataIntoRecycleView();

    }

    private void InitializeDataIntoRecycleView() {

        row a = new row("Box T Shirt", covers[0]);
        applist.add(a);

        a = new row("New Shirt", covers[1]);
        applist.add(a);

        a = new row("Boys Shirt", covers[2]);
        applist.add(a);

        a = new row("Girls Shirt", covers[3]);
        applist.add(a);

        a = new row("Shirt ", covers[4]);
        applist.add(a);

        a = new row("T shirt", covers[5]);
        applist.add(a);

    }
}