package com.example.u93.adapterapp;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class AdapterProducts extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private ArrayList<Product> productsArrayList;
    public AdapterProducts(ArrayList<Product> productsArrayList){
        this.productsArrayList = productsArrayList;

    }
    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_products,parent,false);
        return new CustomViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        CustomViewHolder customViewHolder = (CustomViewHolder) holder;
        Product producto = productsArrayList.get(position);
        customViewHolder.productoName.setText(producto.getName());
        customViewHolder.productoDescription.setText(producto.getDescription());

    }

    @Override
    public int getItemCount() {
        return productsArrayList.size();
    }

    private class CustomViewHolder extends RecyclerView.ViewHolder{
        private TextView productoName;
        private TextView productoDescription;

        public CustomViewHolder(View itemView) {
            super(itemView);
            productoName = itemView.findViewById(R.id.tvProducto);
            productoDescription = itemView.findViewById(R.id.tvProductoDes);
        }
    }


}
