package com.interview.busrouteapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.interview.busrouteapp.models.Routes;
import com.interview.busrouteapp.models.RoutesResponse;
import com.interview.busrouteapp.mvp.HomeAdapter;
import com.interview.busrouteapp.mvp.HomePresenter;
import com.interview.busrouteapp.mvp.HomeView;
import com.interview.busrouteapp.networking.Response;
import com.interview.busrouteapp.networking.Service;

import java.util.List;

import javax.inject.Inject;

import rx.Observer;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
/**
 * Created by pallavi on 1/18/2018.
 */
public class MainActivity extends BaseApp implements HomeView {

    private RecyclerView list;
    @Inject
    public Service service;
    ProgressBar progressBar;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getDeps().inject(this);

        renderView();
        init();

        HomePresenter presenter = new HomePresenter(service, this);
        presenter.getRouteList();
    }

    public  void renderView(){
        setContentView(R.layout.activity_main);
        list = (RecyclerView) findViewById(R.id.list);
        progressBar = (ProgressBar) findViewById(R.id.progress);
    }

    public void init(){
        list.setLayoutManager(new LinearLayoutManager(this));
    }

    @Override
    public void showWait() {
        progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void removeWait() {
        progressBar.setVisibility(View.GONE);
    }

    @Override
    public void onFailure(String appErrorMessage) {

    }

    @Override
    public void getRoutesSuccess(RoutesResponse routesResponse) {

        HomeAdapter adapter = new HomeAdapter(getApplicationContext(), routesResponse.getData(),
                new HomeAdapter.OnItemClickListener() {
                    @Override
                    public void onClick(Routes Item) {
                        Toast.makeText(getApplicationContext(), Item.getName(),
                                Toast.LENGTH_LONG).show();


                        Intent i = new Intent(MainActivity.this, DetailsActivity.class);
                        i.putExtra("item",Item);
                        startActivity(i);
                    }
                });

        list.setAdapter(adapter);

    }
}
