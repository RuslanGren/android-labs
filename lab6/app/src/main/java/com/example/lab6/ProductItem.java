package com.example.lab6;

public class ProductItem {
    private final String title;
    private int quantity;
    private final String unit;

    public ProductItem(String title, String unit) {
        this.title = title;
        this.quantity = 0;
        this.unit = unit;
    }

    public String getTitle() {
        return title;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getUnit() {
        return unit;
    }
}
