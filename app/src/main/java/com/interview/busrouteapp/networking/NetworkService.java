package com.interview.busrouteapp.networking;


import com.interview.busrouteapp.models.Routes;
import com.interview.busrouteapp.models.RoutesResponse;

import retrofit2.http.GET;
import rx.Observable;
/**
 * Created by pallavi on 1/18/2018.
 */
public interface NetworkService {

    @GET("v2/5808f00d10000005074c6340")
    Observable<RoutesResponse> getRoutes();

}
