package com.example.u93.adapterapp.repositories;

import com.example.u93.adapterapp.services.IServices;
import com.example.u93.adapterapp.models.Product;

import java.io.IOException;
import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Response;

public class Repository {

    private IServices iServices;

    public Repository() {
        ServiceFactory serviceFactory = new ServiceFactory();
        iServices = (IServices) serviceFactory.getInstanceService(IServices.class);

    }

    public ArrayList<Product> getProducts() throws IOException {
        try {
            Call<ArrayList<Product>> call = iServices.getProducts();
            Response<ArrayList<Product>> response = call.execute();
            if (response.errorBody()!=null){
                throw defaultError();
            } else{
                return response.body();
            }
        } catch (IOException e){
            throw defaultError();
        }
    }

    private IOException defaultError(){
        return new IOException("Ha ocurrido un error");
    }


    public Product saveProduct(Product producto) throws IOException{
        try {
            Call<Product> call = iServices.createProduct(producto);
            Response<Product> response = call.execute();
            if (response.errorBody() != null){
                throw defaultError();
            } else{
                return response.body();
            }
        } catch (IOException e){
            throw defaultError();
        }
    }
}
