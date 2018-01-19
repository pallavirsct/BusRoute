package com.interview.busrouteapp.mvp;

import com.interview.busrouteapp.models.Routes;
import com.interview.busrouteapp.models.RoutesResponse;
import com.interview.busrouteapp.networking.NetworkError;
import com.interview.busrouteapp.networking.Service;

import rx.Subscription;
import rx.subscriptions.CompositeSubscription;
/**
 * Created by pallavi on 1/18/2018.
 */
public class HomePresenter {
    private final Service service;
    private final HomeView view;
    private CompositeSubscription subscriptions;

    public HomePresenter(Service service, HomeView view) {
        this.service = service;
        this.view = view;
        this.subscriptions = new CompositeSubscription();
    }

    public void getRouteList() {
        view.showWait();

        Subscription subscription = service.getRoutes(new Service.GetRoutesCallback() {
            @Override
            public void onSuccess(RoutesResponse routes) {
                view.removeWait();
                view.getRoutesSuccess(routes);
            }

            @Override
            public void onError(NetworkError networkError) {
                view.removeWait();
                view.onFailure(networkError.getAppErrorMessage());
            }

        });

        subscriptions.add(subscription);
    }
    public void onStop() {
        subscriptions.unsubscribe();
    }
}
