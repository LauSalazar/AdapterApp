package com.example.u93.adapterapp;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

public class FragmentOne extends Fragment {
    private AdapterPersons adapterPersons;
    private RecyclerView recyclerViewPersons;

    public FragmentOne(){}

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View view = inflater.inflate(R.layout.fragment_one,container,false);
        loadAdapterPersons(view);
        return view;
    }

    private void loadAdapterPersons(View view) {
        recyclerViewPersons = view.findViewById(R.id.rvRecyclerPersons);
        Person person1 = new Person("Laura");
        Person person2 = new Person("Karen");
        Person person3 = new Person("Hildamar");
        Person person4 = new Person("Geronimo");
        Person person5 = new Person("Rosana");
        Person person6 = new Person("Bayardo");
        Person person7 = new Person("Felipe");
        Person person8 = new Person("Ana");


        ArrayList<Person> persons = new ArrayList<>();
        persons.add(person1);
        persons.add(person2);
        persons.add(person3);
        persons.add(person4);
        persons.add(person5);
        persons.add(person6);
        persons.add(person7);
        persons.add(person8);

        adapterPersons = new AdapterPersons(persons);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(view.getContext());
        recyclerViewPersons.setLayoutManager(linearLayoutManager);
        recyclerViewPersons.setAdapter(adapterPersons);

    }


}
