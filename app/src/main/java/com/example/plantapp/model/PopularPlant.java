package com.example.plantapp.model;

public class PopularPlant {
    String name ;
    String price;
    Integer imageUrl;

    String quantity;
    public PopularPlant() {

    }

    public PopularPlant(String name, String price, Integer imageUrl, String quantity) {
        this.name = name;
        this.price = price;
        this.imageUrl = imageUrl;
        this.quantity = quantity;
    }

    public PopularPlant(String name, String price, String quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
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



    public PopularPlant(String name, String price, Integer imageUrl) {
        this.name = name;
        this.price = price;
        this.imageUrl = imageUrl;
    }
    public PopularPlant(String name, String price) {
        this.name = name;
        this.price = price;
   //     this.imageUrl = imageUrl;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public String getQuantity() { return quantity; }

    public String getName() {
        return name;
    }

    public String getPrice() {
        return price;
    }

    public Integer getImageUrl() {
        return imageUrl;
    }
}


