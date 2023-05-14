package com.example.demo;

/**
 * Date: 5/11/2023<br/>
 * Time: 9:31 PM<br/>
 */
public class Room {
    private int price;
    private int monthRent;

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getMonthRent() {
        return monthRent;
    }

    public void setMonthRent(int monthRent) {
        this.monthRent = monthRent;
    }


    public Room(int price, int monthRent) {
        this.price = price;
        this.monthRent = monthRent;
    }
}
