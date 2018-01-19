package com.interview.busrouteapp.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Generated;
/**
 * Created by pallavi on 1/18/2018.
 */
@Generated("org.jsonschema2pojo")
public class RoutesResponse {

    @SerializedName("routes")
    @Expose
    private List<Routes> data = new ArrayList<Routes>();


    /**
     *
     * @return
     * The data
     */
    public List<Routes> getData() {
        return data;
    }

    /**
     *
     * @param data
     * The data
     */
    public void setData(List<Routes> data) {
        this.data = data;
    }



}