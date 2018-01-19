package com.interview.busrouteapp.mvp;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.interview.busrouteapp.R;
import com.interview.busrouteapp.models.Routes;

import java.util.List;
/**
 * Created by pallavi on 1/18/2018.
 */
public class HomeAdapter extends RecyclerView.Adapter<HomeAdapter.ViewHolder> {
    private final OnItemClickListener listener;
    private List<Routes> data;
    private Context context;

    public HomeAdapter(Context context, List<Routes> data, OnItemClickListener listener) {
        this.data = data;
        this.listener = listener;
        this.context = context;
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_github_repo, null);
        view.setLayoutParams(new RecyclerView.LayoutParams(RecyclerView.LayoutParams.MATCH_PARENT, RecyclerView.LayoutParams.WRAP_CONTENT));
        return new ViewHolder(view);
    }


    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.click(data.get(position), listener);
        holder.tvCity.setText(data.get(position).getName());

        String images = data.get(position).getImage();
        Log.i("test","images --->"+images);
        Glide.with(context)
                .load(images)
                .into(holder.logo);

    }


    @Override
    public int getItemCount() {
        return data.size();
    }


    public interface OnItemClickListener {
        void onClick(Routes Item);
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvCity;
        ImageView logo;

        public ViewHolder(View itemView) {
            super(itemView);
            tvCity = (TextView) itemView.findViewById(R.id.text_repo_name);
            logo = (ImageView) itemView.findViewById(R.id.imageView_);

        }


        public void click(final Routes cityListData, final OnItemClickListener listener) {
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener.onClick(cityListData);
                }
            });
        }
    }


}
