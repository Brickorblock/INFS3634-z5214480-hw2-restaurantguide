package com.example.hw2_restaurantguide;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;

public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        //create fragment
        DetailFragment fragment = new DetailFragment();

        //bind fragment to activity
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.add(R.id.scrollView, fragment);
        transaction.commit();

        //get intent and pass through as bundle
        Intent intent = getIntent();
        int rank = intent.getIntExtra(MainActivity.KEY, 1);

        Bundle intentBundle = new Bundle();
        intentBundle.putInt(MainActivity.KEY, rank);

        fragment.setArguments(intentBundle);

        Toolbar myToolbar = findViewById(R.id.myToolbar);
        setSupportActionBar(myToolbar);
        getSupportActionBar().setTitle(Restaurant.restaurantSearch(rank).getName());

    }
}
