package com.interview.busrouteapp.mvp;

import com.interview.busrouteapp.models.RoutesResponse;

/**
 * Created by pallavi on 1/18/2018.
 */
public interface HomeView {
    void showWait();

    void removeWait();

    void onFailure(String appErrorMessage);

    void getRoutesSuccess(RoutesResponse cityListResponse);

}
