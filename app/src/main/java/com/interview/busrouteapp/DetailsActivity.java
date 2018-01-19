package com.interview.busrouteapp;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.interview.busrouteapp.models.Routes;
import com.interview.busrouteapp.models.Stops;

import java.util.List;

/**
 * Created by jagadesh_r on 1/18/2018.
 */

public class DetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.details_layout);

        LinearLayout header=(LinearLayout)findViewById(R.id.header);
        TextView mTextView_name = (TextView)findViewById(R.id.text_repo_name);
        TextView mTextView_description = (TextView)findViewById(R.id.text_repo_description);
        ImageView mImageView_logo = (ImageView)findViewById(R.id.imageView_);
        ImageView mImageView_access = (ImageView)findViewById(R.id.access_icon);

        Bundle b = getIntent().getExtras();
        if(b!=null)
        {
            Routes item = (Routes) b.getSerializable("item");
            mTextView_name.setText(item.getName());
            mTextView_description.setText(item.getDescription());

            Glide.with(this)
                    .load(item.getImage())
                    .into(mImageView_logo);

                mImageView_access.setEnabled(item.getAccessible());
            LayoutInflater vi = (LayoutInflater) getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);

            List<Stops> stops=item.getStops();
            for( int i=0;i<stops.size();i ++){
                View view = vi.inflate(R.layout.steps_view, null);
                TextView mStopName=(TextView) view.findViewById(R.id.stop_name);
                mStopName.setText(stops.get(i).getName());
                if(i==(stops.size()-1)){
                    view.findViewById(R.id.line).setVisibility(View.INVISIBLE);
                }
                header.addView(view);
            }

        }
    }
}
