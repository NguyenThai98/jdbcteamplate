package com.example.demo.domain;

import java.io.Serializable;

/**
 * Date: 5/11/2023<br/>
 * Time: 3:21 PM<br/>
 */
public class Activities implements Serializable {
    private static final long serialVersionUID = 1L;

    private String trackingActivities;
    private int numberOfLead;

    public String getTrackingActivities() {
        return trackingActivities;
    }

    public void setTrackingActivities(String trackingActivities) {
        this.trackingActivities = trackingActivities;
    }

    public int getNumberOfLead() {
        return numberOfLead;
    }

    public void setNumberOfLead(int numberOfLead) {
        this.numberOfLead = numberOfLead;
    }

    public Activities() {
    }

    public Activities(String trackingActivities, int numberOfLead) {
        this.trackingActivities = trackingActivities;
        this.numberOfLead = numberOfLead;
    }

    @Override
    public String toString() {
        return "Activities{" +
                "trackingActivities='" + trackingActivities + '\'' +
                ", numberOfLead=" + numberOfLead +
                '}';
    }
}
