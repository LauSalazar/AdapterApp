package com.example.u93.adapterapp;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.io.IOException;
import java.util.ArrayList;

public class FragmentTwo extends Fragment {
    private AdapterProducts adapter;
    private RecyclerView recyclerView;
    private Repository repository;

    public FragmentTwo(){}

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View view = inflater.inflate(R.layout.fragment_two,container,false);
        recyclerView = view.findViewById(R.id.recyclerProducts);
        repository = new Repository();

        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {

                getProducts();
            }
        });
        thread.start();
        return view;
    }

    private void getProducts() {
        try {
            ArrayList<Product> products = repository.getProducts();
            loadAdapterProducts(products);

        } catch (final IOException e) {
            getActivity().runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    Toast.makeText(getContext(),e.getMessage(),Toast.LENGTH_LONG).show();
                }
            });

        }
    }

    private void loadAdapterProducts(final ArrayList<Product> products) {
        if (getActivity() != null) {

            getActivity().runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    adapter = new AdapterProducts(products);
                    LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
                    recyclerView.setLayoutManager(linearLayoutManager);
                    recyclerView.setAdapter(adapter);
                }
            });
        }
    }


}
