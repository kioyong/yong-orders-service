package com.yong.orders.model;

/**
 * Created by yong.a.liang on 6/21/2017.
 */
public class Address {
    private String add;
    private String location;
    private String country;


    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getAdd() {
        return add;
    }

    public void setAdd(String add) {
        this.add = add;
    }
}
