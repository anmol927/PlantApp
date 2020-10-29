package com.example.plantapp.model;

public class HerbsPlant {
    String name ;
    String price;
    String quantity;
    Integer imageUrl;
    String restaurantname;
    String rating;

    public HerbsPlant(String name, String price, String quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }



    public String getRestaurantname() {
        return restaurantname;
    }

    public void setRestaurantname(String restaurantname) {
        this.restaurantname = restaurantname;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public HerbsPlant(String name, String price, Integer imageUrl, String restaurantname, String rating) {
        this.name = name;
        this.price = price;
        this.imageUrl = imageUrl;
        this.restaurantname = restaurantname;
        this.rating = rating;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }


    public String getName() {
        return name;
    }

    public String getPrice() {
        return price;
    }

    public Integer getImageUrl() {
        return imageUrl;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public void setImageUrl(Integer imageUrl) {
        this.imageUrl = imageUrl;
    }

}


