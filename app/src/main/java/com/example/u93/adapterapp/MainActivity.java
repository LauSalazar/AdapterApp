package com.example.u93.adapterapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private AdapterProducts adapterProducts;
    private RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.rvRecycler);
        loadAdapter();
    }

    private void loadAdapter(){
        Product tanga = new Product();
        tanga.setName("Pastel");
        tanga.setDescription("Pastel de naranja");

        ArrayList<Product> products= new ArrayList<>();
        products.add(tanga);
        products.add(tanga);
        products.add(tanga);
        products.add(tanga);

        adapterProducts = new AdapterProducts(products);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(adapterProducts);
    }
}
