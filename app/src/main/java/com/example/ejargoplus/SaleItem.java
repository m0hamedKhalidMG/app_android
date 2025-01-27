package com.example.ejargoplus;

public class SaleItem {
    private final String title;
    private final String price;
    private final int imageRes;

    public SaleItem(String title, String price, int imageRes) {
        this.title = title;
        this.price = price;
        this.imageRes = imageRes;
    }

    public String getTitle() {
        return title;
    }

    public String getPrice() {
        return price;
    }

    public int getImageRes() {
        return imageRes;
    }
}
