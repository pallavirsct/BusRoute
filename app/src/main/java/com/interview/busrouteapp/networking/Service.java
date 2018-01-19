package com.interview.busrouteapp.networking;


import com.interview.busrouteapp.models.Routes;
import com.interview.busrouteapp.models.RoutesResponse;

import rx.Observable;
import rx.Subscriber;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

/**
 * Created by pallavi on 1/18/2018.
 */
public class Service {
    private final NetworkService networkService;

    public Service(NetworkService networkService) {
        this.networkService = networkService;
    }

    public Subscription getRoutes(final GetRoutesCallback callback) {

        return networkService.getRoutes()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .onErrorResumeNext(new Func1<Throwable, Observable<? extends RoutesResponse>>() {
                    @Override
                    public Observable<? extends RoutesResponse> call(Throwable throwable) {
                        return Observable.error(throwable);
                    }
                })
                .subscribe(new Subscriber<RoutesResponse>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        callback.onError(new NetworkError(e));

                    }

                    @Override
                    public void onNext(RoutesResponse routesResponse) {
                        callback.onSuccess(routesResponse);

                    }
                });
    }

    public interface GetRoutesCallback{
        void onSuccess(RoutesResponse routesResponse);

        void onError(NetworkError networkError);
    }
}
