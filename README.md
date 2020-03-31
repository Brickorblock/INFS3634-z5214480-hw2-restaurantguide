# INFS3634-z5214480-hw2-restaurantguide
A simple restaurant guide of 10 of my favorite restaurants in Sydney, with a filter by cuisine functionality

Most of the restaurant informational data (e.g. cuisine, cost, location) were sourced from Zomato. Images are sourced from Google. However, the reviews and ratings for each place were generated/written by me.

The app has a dynamic situational layout that supports small and large screens. In a small screen (single pane mode), the main screen is a master list of all the restaurants. Clicking on one will launch the detail in a separate activity. For large screens (dual pane mode), the master list will be shown on the left side, with the details being shown in the right hand panel.

The filter function allows users to sort the master list based on cuisine. This works by retrieving a filtered results list, then rebuilding the recycler view using this list. The filter also works with restaurants with multiple cuisine tags (for instance, if a place has tags "Taiwanese, Dessert", searching for just "Dessert" will still show this restaurant).
