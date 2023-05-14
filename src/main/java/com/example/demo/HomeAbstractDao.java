package com.example.demo;

/**
 * Date: 5/11/2023<br/>
 * Time: 9:43 PM<br/>
 */
public abstract class HomeAbstractDao {

    public <T> T getInforRoom(){
        T data = (T)new Department(1000, 2, 20,5);
        return data;
    }
}
