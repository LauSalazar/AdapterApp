package com.example.u93.adapterapp;

import java.io.IOException;
import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Response;

public class Repository {

    private  IServices iServices;

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
            defaultError();
        }
    }

    private IOException defaultError(){
        return new IOException("Ha ocurrido un error");
    }
}
