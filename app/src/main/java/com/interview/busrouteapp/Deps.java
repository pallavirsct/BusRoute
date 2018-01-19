package com.interview.busrouteapp;




import com.interview.busrouteapp.networking.NetworkModule;

import javax.inject.Singleton;

import dagger.Component;
/**
 * Created by pallavi on 1/18/2018.
 */
@Singleton
@Component(modules = {NetworkModule.class,})
public interface Deps {
    void inject(MainActivity mainActivity);
}
