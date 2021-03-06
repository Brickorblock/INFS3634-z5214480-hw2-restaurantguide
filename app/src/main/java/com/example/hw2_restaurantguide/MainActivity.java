package com.example.hw2_restaurantguide;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;


import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements RestaurantAdapter.LaunchListener, AdapterView.OnItemSelectedListener {

    private RecyclerView myRecyclerView;
    private RecyclerView.Adapter myAdapter;
    private RecyclerView.LayoutManager myLayoutManager;
    private ArrayList<Restaurant> currList;
    private boolean isDualPane = false;

    public static final String KEY = "ActivityMain";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // check if dualpane mode
        ConstraintLayout fragmentContainer = findViewById(R.id.fragmentContainer);
        if (fragmentContainer != null && fragmentContainer.getVisibility() == View.VISIBLE) {
            isDualPane = true;
        }

        //set up custom toolbar
        Toolbar myToolbar = findViewById(R.id.myToolbar);
        setSupportActionBar(myToolbar);

        //set up spinner dropdown
        Spinner filterSpinner = findViewById(R.id.filterSpinner);
        ArrayAdapter<CharSequence> arrayAdapter = ArrayAdapter.createFromResource(
                this, R.array.cuisines, android.R.layout.simple_spinner_item);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_item);
        filterSpinner.setAdapter(arrayAdapter);
        filterSpinner.setOnItemSelectedListener(this);

        //create recyclerView
        myRecyclerView = findViewById(R.id.myRecyclerView);
        myRecyclerView.setHasFixedSize(true);

        myLayoutManager = new LinearLayoutManager(this);
        myRecyclerView.setLayoutManager(myLayoutManager);

        Log.d("TAG", "onCreate: #1");

        //create adapter (using Restaurant list as dataset)
        ArrayList<Restaurant> restaurants = Restaurant.getRestaurants();
        currList = restaurants;
        myAdapter = new RestaurantAdapter(restaurants, this);
        myRecyclerView.setAdapter(myAdapter);

        Log.d("TAG", "onCreate: #2");

    }

    @Override
    public void launch(int position) {
    int rank = getRank(position);
        //check which screen mode to launch in
        if (isDualPane == false){
            launchActivity(rank);
        } else {
            attachDetailFragment(rank);
        }
    }

    //launches detail in a separate activity (small screens)
    private void launchActivity(int rank){
        Intent launchIntent = new Intent(this, DetailActivity.class);
        launchIntent.putExtra(KEY, rank);

        startActivity(launchIntent);

    }

    //binds detailFragment to scrollView in MainActivity (tablets)
    private void attachDetailFragment(int rank) {
        DetailFragment fragment = new DetailFragment();

        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        if (fragment == null) {
            transaction.add(R.id.fragmentContainer, fragment);
        } else {
            transaction.replace(R.id.fragmentContainer, fragment);
        }
        transaction.commit();

        // send rank info as a bundle to fragment
        Bundle rankBundle = new Bundle();
        rankBundle.putInt(KEY, rank);
        fragment.setArguments(rankBundle);

    }

    //get restaurant rank
    private int getRank(int position){
        //get rank based on each Restaurant in the currList
        int rank = currList.get(position).getRank();

        return rank;
    }


    // methods to handle spinner drop down list action
    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String selected = parent.getItemAtPosition(position).toString();

        resetRecycler(getFilteredList(selected));
        Log.d("TAG", "onItemSelected: #6");

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {
    }

    // rebuilds the recyclerView to show filtered items
    private void resetRecycler(ArrayList<Restaurant> filteredList){
        myAdapter = new RestaurantAdapter(filteredList, this);
        myRecyclerView.setAdapter(myAdapter);
        Log.d("TAG", "resetRecycler: #7");
    }

    // returns a separate, filtered arraylist to use as a customised data set
    private ArrayList<Restaurant> getFilteredList(String cuisine) {
        ArrayList<Restaurant> filteredList = new ArrayList<>();
        ArrayList<Restaurant> defaultList = Restaurant.getRestaurants();

        for (int i = 0; i < defaultList.size(); i++) {
            Restaurant currDefault = defaultList.get(i);

            //add the restaurant to new filtered list if it contains the specified cuisine
            if (currDefault.getCuisine().contains(cuisine) || cuisine.equals("All")) {
                filteredList.add(currDefault);
            }
        }

        currList = filteredList;
        return filteredList;
    }


}
