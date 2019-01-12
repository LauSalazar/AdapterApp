package com.example.u93.adapterapp.fragments;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.example.u93.adapterapp.activities.CreateProductActivity;
import com.example.u93.adapterapp.helper.ValidateInternet;
import com.example.u93.adapterapp.models.Product;
import com.example.u93.adapterapp.R;
import com.example.u93.adapterapp.repositories.Repository;
import com.example.u93.adapterapp.adapters.AdapterProducts;

import java.io.IOException;
import java.util.ArrayList;

public class FragmentTwo extends Fragment {
    private AdapterProducts adapter;
    private RecyclerView recyclerView;
    private Repository repository;
    private Button productCreateButton;

    public FragmentTwo(){}

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View view = inflater.inflate(R.layout.fragment_two,container,false);
        recyclerView = view.findViewById(R.id.recyclerProducts);
        repository = new Repository();
        productCreateButton = view.findViewById(R.id.productCreateButton);
        validateInternet();

        productCreateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), CreateProductActivity.class);
                startActivity(intent);
            }
        });
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

    private void createThreadCreateProducts(){
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {

                getProducts();
            }
        });
        thread.start();

    }

    @Override
    public void onResume() {
        super.onResume();
        validateInternet();
    }


    private void validateInternet(){
        final ValidateInternet validateInternet = new ValidateInternet(getContext());
        if (validateInternet.verificarInternet()){
            createThreadCreateProducts();
        } else {
            AlertDialog.Builder alertDialog = new AlertDialog.Builder(getContext());
            alertDialog.setTitle(R.string.error_internet);
            alertDialog.setMessage(R.string.message_error_internet);
            alertDialog.setCancelable(false);
            alertDialog.setPositiveButton(R.string.text_again, new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    validateInternet();
                    dialogInterface.dismiss();
                }
            });
        }

    }
}
