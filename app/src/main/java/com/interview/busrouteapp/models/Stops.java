package com.interview.busrouteapp.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by pallavi on 1/18/2018.
 */

public class Stops implements Serializable{

    @SerializedName("name")
    @Expose
    private  String name;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
