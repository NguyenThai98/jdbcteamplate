package com.example.demo;

/**
 * Date: 5/11/2023<br/>
 * Time: 9:35 PM<br/>
 */
public class BedRoom extends Room{
    private int numberOfPerson;

    public int getNumberOfPerson() {
        return numberOfPerson;
    }

    public void setNumberOfPerson(int numberOfPerson) {
        this.numberOfPerson = numberOfPerson;
    }

    public BedRoom(int price, int monthRent, int numberOfPerson) {
        super(price, monthRent);
        this.numberOfPerson = numberOfPerson;
    }
}
