package com.example.demo.domain;

/**
 * Date: 5/22/2023<br/>
 * Time: 3:08 PM<br/>
 */
public class KpiDto {
    private int id;
    private String role;
    private String month;
    private int weight;

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public KpiDto(int id, String role, String month, int weight) {
        this.id = id;
        this.role = role;
        this.month = month;
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "KpiDto{" +
                "id=" + id +
                ", role='" + role + '\'' +
                ", month='" + month + '\'' +
                ", weight=" + weight +
                '}';
    }
}
