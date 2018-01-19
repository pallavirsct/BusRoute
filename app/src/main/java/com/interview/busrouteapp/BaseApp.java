package com.interview.busrouteapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;


import com.interview.busrouteapp.networking.NetworkModule;

import java.io.File;

/**
 * Created by pallavi on 1/18/2018.
 */
public class BaseApp  extends AppCompatActivity{
    Deps deps;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        File cacheFile = new File(getCacheDir(), "responses");
        deps = DaggerDeps.builder().networkModule(new NetworkModule(cacheFile)).build();

    }

    public Deps getDeps() {
        return deps;
    }
}
