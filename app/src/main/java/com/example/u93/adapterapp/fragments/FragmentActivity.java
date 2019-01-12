package com.example.u93.adapterapp.fragments;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.example.u93.adapterapp.R;
import com.example.u93.adapterapp.fragments.FragmentOne;
import com.example.u93.adapterapp.fragments.FragmentTwo;

public class FragmentActivity extends AppCompatActivity {
    private TextView tvUno;
    private TextView tvDos;
    private FrameLayout frameLayout;
    private RecyclerView recyclerViewPersons;
    private RecyclerView recyclerViewProducts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment);
        recyclerViewPersons = findViewById(R.id.rvRecyclerPersons);
        recyclerViewProducts = findViewById(R.id.recyclerProducts);


        tvUno = findViewById(R.id.tvUno);
        tvDos = findViewById(R.id.tvDos);
        frameLayout = findViewById(R.id.frameLayout);

        tvUno.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showFragment(new FragmentOne());
            }

        });
        tvUno.callOnClick();
        tvDos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showFragment(new FragmentTwo());

            }
        });
    }

    private void showFragment(Fragment fragment){
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(frameLayout.getId(),fragment);
        fragmentTransaction.commit();
    }
}
