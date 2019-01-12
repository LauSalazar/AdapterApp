package com.example.u93.adapterapp.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.u93.adapterapp.R;
import com.example.u93.adapterapp.adapters.AdapterPersons;
import com.example.u93.adapterapp.adapters.AdapterProducts;
import com.example.u93.adapterapp.models.Person;
import com.example.u93.adapterapp.models.Product;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private AdapterProducts adapterProducts;
    private AdapterPersons adapterPersons;
    private RecyclerView recyclerView;
    private RecyclerView recyclerViewPersons;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.rvRecycler);
        recyclerViewPersons = findViewById(R.id.rvRecyclerPersons);
        loadAdapter();
        loadAdapterPersons();
    }

    private void loadAdapterPersons() {
        Person person1 = new Person("Laura");
        Person person2 = new Person("Karen");
        Person person3 = new Person("Hildamar");

        ArrayList<Person> persons = new ArrayList<>();
        persons.add(person1);
        persons.add(person2);
        persons.add(person3);

        adapterPersons = new AdapterPersons(persons);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerViewPersons.setLayoutManager(linearLayoutManager);
        recyclerViewPersons.setAdapter(adapterPersons);

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
