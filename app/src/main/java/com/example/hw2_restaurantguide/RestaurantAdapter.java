package com.example.hw2_restaurantguide;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RestaurantAdapter extends RecyclerView.Adapter<RestaurantAdapter.MyViewHolder> {
    private ArrayList<Restaurant> mDataset;
    private LaunchListener mLaunchListener;


    public RestaurantAdapter(ArrayList<Restaurant> mDataset, LaunchListener mLaunchListener) {
        this.mDataset = mDataset;
        this.mLaunchListener = mLaunchListener;
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public ImageView restaurantImg;
        public TextView nameText;
        public TextView costText;
        public TextView locationText;
        public TextView ratingText;
        public TextView rankText;
        public TextView cuisineText;

        LaunchListener myLaunchListener;

        public MyViewHolder(View itemView, LaunchListener myLaunchListener) {
            super(itemView);

            this.nameText = itemView.findViewById(R.id.nameText);
            this.costText = itemView.findViewById(R.id.costText);
            this.restaurantImg = itemView.findViewById(R.id.restaurantImg);
            this.ratingText = itemView.findViewById(R.id.ratingText);
            this.rankText = itemView.findViewById(R.id.rankText);
            this.cuisineText = itemView.findViewById(R.id.cuisineText);
            this.locationText = itemView.findViewById(R.id.locationText);

            this.myLaunchListener = myLaunchListener;

            itemView.setOnClickListener(this);

            Log.d("TAG", "myViewHolder: #3");

        }

        @Override
        public void onClick(View v) {
            int position = getAdapterPosition();
            myLaunchListener.launch(position);
        }

    }

    @Override
    public RestaurantAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        CardView v = (CardView) LayoutInflater.from(parent.getContext())
                .inflate(R.layout.listitem_view, parent, false);

        MyViewHolder vh = new MyViewHolder(v, mLaunchListener);
        Log.d("TAG", "onCreateViewHolder: #4");

        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Restaurant curr = mDataset.get(position);

        //set fields about current restaurant
        holder.restaurantImg.setImageResource(curr.getImage());
        holder.nameText.setText(curr.getName());
        holder.costText.setText(curr.getCost());
        holder.locationText.setText(curr.getLocation());
        holder.rankText.setText(Integer.toString(curr.getRank()));
        holder.cuisineText.setText(curr.getCuisine());
        holder.ratingText.setText(curr.getRatingString());

        Log.d("TAG", "onBindViewHolder: #5");
    }

    @Override
    public int getItemCount() {
        return mDataset.size();
    }

    //interface for a click listener - logic is implemented in Main
    public interface LaunchListener {
        void launch(int position);
    }
}
