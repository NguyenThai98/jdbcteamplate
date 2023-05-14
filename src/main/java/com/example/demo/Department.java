package com.example.demo;

/**
 * Date: 5/11/2023<br/>
 * Time: 9:32 PM<br/>
 */
public class Department extends Room {
    private int weight;
    private int height;

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public Department(int price, int monthRent, int weight, int height) {
        super(price, monthRent);
        this.weight = weight;
        this.height = height;
    }
}
