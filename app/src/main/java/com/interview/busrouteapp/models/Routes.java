package com.interview.busrouteapp.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

import javax.annotation.Generated;

/**
 * Created by pallavi on 1/18/2018.
 */

@Generated("org.jsonschema2pojo")
public class Routes implements Serializable{

    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("name")
    @Expose
    private  String name;
    @SerializedName("stops")
    @Expose
    private List<Stops> stops;
    @SerializedName("description")
    @Expose
    private String description;

    @SerializedName("accessible")
    @Expose
    private boolean accessible;

    @SerializedName("image")
    @Expose
    private String image;



    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Stops> getStops() {
        return stops;
    }

    public void setStops(List<Stops> stops) {
        this.stops = stops;
    }


    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean getAccessible() {
        return accessible;
    }

    public void setAccessible(boolean accessible) {
        this.accessible = accessible;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
