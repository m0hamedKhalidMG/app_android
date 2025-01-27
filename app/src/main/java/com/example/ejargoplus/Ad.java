package com.example.ejargoplus;
public class Ad {
    private final String price;
    private final String details;
    private final String location;
    private final int imageResId;

    public Ad(String price, String details, String location, int imageResId) {
        this.price = price;
        this.details = details;
        this.location = location;
        this.imageResId = imageResId;
    }

    public String getPrice() {
        return price;
    }

    public String getDetails() {
        return details;
    }

    public String getLocation() {
        return location;
    }

    public int getImageResId() {
        return imageResId;
    }
}