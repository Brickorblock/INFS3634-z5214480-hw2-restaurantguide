package com.example.hw2_restaurantguide;

import android.widget.ImageView;

import java.util.ArrayList;

public class Restaurant {
    private String name;
    private int rank;
    private double rating;
    private String cuisine;
    private String location;
    private String cost;
    private String review;
    private String itemOfChoice;
    private int image;

    public Restaurant(){
    }

    public Restaurant(String name, int rank, double rating, String cuisine, String location, String cost, String review, String itemOfChoice, int image) {
        this.name = name;
        this.rank = rank;
        this.rating = rating;
        this.cuisine = cuisine;
        this.location = location;
        this.cost = cost;
        this.review = review;
        this.itemOfChoice = itemOfChoice;
        this.image = image;
    }

    public static ArrayList<Restaurant> getRestaurants(){
        ArrayList<Restaurant> restaurantList = new ArrayList<>();

        restaurantList.add(new Restaurant("Sunflower Taiwanese Gourmet", 1, 5, "Taiwanese", "Ultimo", "$$", "Located in the heart of the CBD, right by Central Station, Sunflower is a great way to wrap up a long day at work or class with some comfort food. Bite into a tasty Taiwanese fried chicken fillet, accompanied by a rotating selection of sides including seasonal vegetables and mapo tofu. The meal deal also makes it a great way for you to get your bubble tea fix, with a selection of various milk and sweet teas!", "Crispy Chicken Fillet w’ Rice + Drink combo", R.drawable.sunflower));
        restaurantList.add(new Restaurant("Ippudo", 2, 5, "Japanese", "CBD - various outlets", "$$", "Ramen lovers rejoice! Ippudo provides authentic and true-to-tradition Japanese cuisine, from the hearty greeting you receive upon arrival, to the last spoonful of warm broth and noodles before departure. The restaurant offers a varied selection of soup bases, and a firmness option of your noodles. Add in a few street snack sides, including juicy Karaage and pan-fried Gyoza, it’s the best ramen you can get in Sydney!", "Tori-Shoyu, firm noodles, with a 3pc Karaage side and salad", R.drawable.ippudo));
        restaurantList.add(new Restaurant("Vapiano", 3, 5, "Italian", "King st, CBD", "$$$", "Vapiano offer a masterful Italian culinary experience, from both hand-made pasta, and fire-wood baked pizza - all of which using only the freshest ingredients, prepared in-house.", "Carbonara, with Linguine", R.drawable.vapiano));
        restaurantList.add(new Restaurant("The Tea Cosy ", 4, 5, "Cafe, Western", "The Rocks", "$$$", "This selection is a departure from the others on this list… The Tea Cosy offers an experience that accompanies the food. If you’re in the mood for some afternoon tea, astounding harbour-side views, vintage decor, and the creme-de-la-creme hot scones, this quaint little cafe will not disappoint to offer a cosy afternoon.", "Grandstand Platter (A selection of teas, scones & spreads, and finger sandwiches)", R.drawable.teacosy));
        restaurantList.add(new Restaurant("Chefs Gallery", 5, 4.5, "Chinese, Fusion", "Regent Place, CBD", "$$$", "Lovers of traditional, trendy, or simply taste - all will find something satisfying at Chef’s Gallery. The restaurant offers a selection of traditional Chinese meals such as hand-pulled spinach noodles, to fusion dishes such as Peking duck roti.", "Black pepper wagyu with hand-pulled spinach noodles", R.drawable.chefsgallery));
        restaurantList.add(new Restaurant("Dopa Donburi & Milkbar", 6, 4.5, "Japanese, Dessert", "Haymarket, CBD", "$$", "The traditional rice bowl is a famed staple, generating many variants across multiple cultures. Dopa’s Japanese Donburi is a wonderful representation of this, offering bowls sided with Karaage, chicken or pork Katsu, or teriyaki salmon. Wrap up the meal with a parfait from the milkbar menu!", "Karaage Chicken + Soft Egg Donburi", R.drawable.dopa));
        restaurantList.add(new Restaurant("Pepper Lunch", 7, 4, "Japanese", "CBD - Various Outlets", "$$", "Served on a sizzling hot plate, Pepper Lunch is a casual dining/fast food spin on a traditional staple, that’s hot in more ways than one! With a wide variety of rice, pasta, and curry-based items, this is a good choice to suit large gatherings. However, it’s on the pricey side for a casual dining joint.", "Kimchi Beef + Cheese Pepper Rice", R.drawable.pepperlunch));
        restaurantList.add(new Restaurant("Meet Fresh", 8, 4, "Taiwanese", "Haymarket, CBD", "$", "Traditional herbal desserts such as the selection offered at Meet Fresh are well appreciated in many Asian cuisines, for their natural and subtle sweetness, as well as refreshing property. It’s a great way to round out your meal with a dessert that’s not too heavy and resets your palette!", "Signature Herbal Jelly (Taro ball + Pearls)", R.drawable.meetfresh));
        restaurantList.add(new Restaurant("Chir Chir", 9, 4, "Korean, Fusion", "Burwood", "$$$", "Fried chicken is a simple, yet much-loved international dish - Korean fried chicken being particularly well-known for its accompaniment of abundant sauces and toppings, from spicy, soy, sweet, to cheesy! Each dish is quite pricey, though, so it’s best to share between three or more people!", "Chir Spaghetti (Chicken Tenders and Creamy Sauce Pasta, covered with Mozzarella) ", R.drawable.chirchir));
        restaurantList.add(new Restaurant("Roji Monster Icecream", 10, 3.5, "Taiwanese, Dessert", "Burwood", "$$", "A super cute dessert parlour with monster-themed treats and a Japanese tea-room aesthetic. The minimum $10 per person requirement makes it a great idea for a two-person date or even with a small group of friends.", "Uji Maccha Icecream", R.drawable.roji));

        return restaurantList;
    }

    public static Restaurant restaurantSearch(int rank){
        ArrayList<Restaurant> restaurantList = getRestaurants();
        Restaurant myRestaurant = null;

        if (rank == 1){
            myRestaurant = restaurantList.get(0);
        } else if (rank == 2){
            myRestaurant = restaurantList.get(1);
        } else if (rank == 3){
            myRestaurant = restaurantList.get(2);
        } else if (rank == 4){
            myRestaurant = restaurantList.get(3);
        } else if (rank == 5){
            myRestaurant = restaurantList.get(4);
        } else if (rank == 6){
            myRestaurant = restaurantList.get(5);
        } else if (rank == 7){
            myRestaurant = restaurantList.get(6);
        } else if (rank == 8){
            myRestaurant = restaurantList.get(7);
        } else if (rank == 9){
            myRestaurant = restaurantList.get(8);
        } else if (rank == 10){
            myRestaurant = restaurantList.get(9);
        }
        // TODO: finish this

        return myRestaurant;
    }

    // custom get method for rating; returns either a double or int as a string
    // this method is used to handle NOT having rating text show as "5.0", etc.
    public String getRatingString(){
        String ratingString = Double.toString(rating);
            if (rating % 1 == 0) {
                // rating is a whole int
                int ratingInt = (int) rating;
                ratingString = Integer.toString(ratingInt);
            }

        return ratingString;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public String getCuisine() {
        return cuisine;
    }

    public void setCuisine(String cuisine) {
        this.cuisine = cuisine;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getCost() {
        return cost;
    }

    public void setCost(String cost) {
        this.cost = cost;
    }

    public String getReview() {
        return review;
    }

    public void setReview(String review) {
        this.review = review;
    }

    public String getItemOfChoice() {
        return itemOfChoice;
    }

    public void setItemOfChoice(String itemOfChoice) {
        this.itemOfChoice = itemOfChoice;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }
}
