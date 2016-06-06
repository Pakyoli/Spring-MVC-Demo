package com.patspringframework.dto;

import org.springframework.stereotype.Component;

import java.io.Serializable;

/**
 * Created by pakyo_000 on 6/4/2016.
 */
@Component
public class Address implements Serializable {

    private String street;
    private String city;
    private int stateId;
    private String zip;

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getStateId() {
        return stateId;
    }

    public void setStateId(int stateId) {
        this.stateId = stateId;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }
}
