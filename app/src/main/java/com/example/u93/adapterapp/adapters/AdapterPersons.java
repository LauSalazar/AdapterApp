package com.example.u93.adapterapp.adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.u93.adapterapp.models.Person;
import com.example.u93.adapterapp.R;

import java.util.ArrayList;

public class AdapterPersons extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    ArrayList<Person> persons;
    public AdapterPersons(ArrayList<Person> persons){
        this.persons = persons;
    }
    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_persons,parent,false);
        return new CustomViewHolderPerson(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        CustomViewHolderPerson viewHolderPerson = (CustomViewHolderPerson) holder;
        Person person = persons.get(position);
        viewHolderPerson.apellido.setText(person.getApellido());
        viewHolderPerson.nombre.setText(person.getNombre());
    }

    @Override
    public int getItemCount() {
        return persons.size();
    }

    private class CustomViewHolderPerson extends RecyclerView.ViewHolder{
        private TextView nombre;
        private TextView apellido;
        public CustomViewHolderPerson(View itemView) {
            super(itemView);
            nombre = itemView.findViewById(R.id.tvNamePerson);
            apellido = itemView.findViewById(R.id.tvLastNamePerson);
        }

    }

}
