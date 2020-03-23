package com.example.hw2_restaurantguide;

import android.app.Activity;
import android.media.Image;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

public class DetailFragment extends Fragment {
    Activity parent = getActivity();

    public DetailFragment() {
        // Required empty public constructor
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        //get bundle
        int rank = getArguments().getInt(MainActivity.KEY);
        Log.d("TAG", "onActivityCreated: rank is = " + rank);

        // specify views
        ImageView restaurantImg = getView().findViewById(R.id.restaurantImg);
        TextView nameText = getView().findViewById(R.id.nameText);
        TextView rankText = getView().findViewById(R.id.rankText);
        TextView cuisineText = getView().findViewById(R.id.cuisineText);
        TextView locationText = getView().findViewById(R.id.locationText);
        TextView costText = getView().findViewById(R.id.costText);
        TextView reviewText = getView().findViewById(R.id.reviewText);
        TextView choiceText = getView().findViewById(R.id.choiceText);
        RatingBar ratingBar = getView().findViewById(R.id.ratingBar);

        // get restaurant info and set to fields
        Restaurant curr = Restaurant.restaurantSearch(rank);
        restaurantImg.setImageResource(curr.getImage());
        nameText.setText(curr.getName());
        rankText.setText(Integer.toString(curr.getRank()));
        cuisineText.setText(curr.getCuisine());
        locationText.setText(curr.getLocation());
        costText.setText(curr.getCost());
        reviewText.setText(curr.getReview());
        choiceText.setText(curr.getItemOfChoice());
        ratingBar.setRating((float) curr.getRating());

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_detail, container, false);
    }

}
