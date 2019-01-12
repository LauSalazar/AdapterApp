package com.example.u93.adapterapp.activities;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.u93.adapterapp.R;
import com.example.u93.adapterapp.models.Product;
import com.example.u93.adapterapp.repositories.Repository;

import java.io.IOException;

public class CreateProductActivity extends AppCompatActivity implements TextWatcher {

    private EditText nombreEditText;
    private EditText descripcionEditText;
    private EditText precioEditText;
    private EditText cantidadEditText;
    private EditText marcaEditText;
    private Button buttonCreateProduct;
    private ProgressBar progressBar;



    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.create_product);
        loadView();
        loadEvents();
    }


    private void loadEvents() {
        buttonCreateProduct.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                Product producto = new Product();
                producto.setCantidad(Integer.parseInt(cantidadEditText.getText().toString()));
                producto.setDescription(descripcionEditText.getText().toString());
                producto.setMarca(marcaEditText.getText().toString());
                producto.setPrecio(Integer.parseInt(precioEditText.getText().toString()));
                producto.setName(nombreEditText.getText().toString());
                buttonCreateProduct.setVisibility(View.GONE);
                progressBar.setVisibility(View.VISIBLE);
                createThreadCreateProduct(producto);

            }
        });
    }

    private void loadView() {
        nombreEditText = findViewById(R.id.nombreEditText);
        nombreEditText.addTextChangedListener(this);
        descripcionEditText = findViewById(R.id.descripcionEditText);
        descripcionEditText.addTextChangedListener(this);
        precioEditText = findViewById(R.id.precioEditText);
        precioEditText.addTextChangedListener(this);
        cantidadEditText = findViewById(R.id.cantidadEditText);
        cantidadEditText.addTextChangedListener(this);
        marcaEditText = findViewById(R.id.marcaEditText);
        marcaEditText.addTextChangedListener(this);
        buttonCreateProduct = findViewById(R.id.buttonCreateProduct);
        progressBar = findViewById(R.id.progressBar);
    }

    @Override
    public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

    }

    @Override
    public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

    }

    @Override
    public void afterTextChanged(Editable editable) {
        if(nombreEditText.getText().toString().trim().isEmpty() || descripcionEditText.getText().toString().trim().isEmpty()
                || precioEditText.getText().toString().trim().isEmpty() || cantidadEditText.getText().toString().trim().isEmpty()
                || marcaEditText.getText().toString().trim().isEmpty()){
            buttonCreateProduct.setEnabled(false);
            buttonCreateProduct.setBackgroundResource(R.color.colorRose);
        } else {
            buttonCreateProduct.setEnabled(true);
            buttonCreateProduct.setBackgroundResource(R.color.colorPrimaryDark);
        }

    }
    
    private void createThreadCreateProduct(final Product producto){
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                createProduct(producto);
            }
        });
        thread.start();
    }

    private void createProduct(Product producto) {
        try{
        Repository repository = new Repository();
        repository.saveProduct(producto);

        finish();
        } catch (final IOException e) {
            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    Toast.makeText(CreateProductActivity.this,e.getMessage(),Toast.LENGTH_LONG).show();
                }
            });

        }

    }
}
