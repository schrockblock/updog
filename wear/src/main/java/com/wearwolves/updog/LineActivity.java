package com.wearwolves.updog;

import android.app.Activity;
import android.os.Bundle;
import android.support.wearable.view.GridViewPager;
import android.support.wearable.view.WatchViewStub;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.wearwolves.updog.adapters.LineGridPagerAdapter;
import com.wearwolves.updog.views.SeekArc;

public class LineActivity extends Activity {

    private GridViewPager mGridPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_line);
        final WatchViewStub stub = (WatchViewStub) findViewById(R.id.wvs_line_activity);
        stub.setOnLayoutInflatedListener(new WatchViewStub.OnLayoutInflatedListener() {
            @Override
            public void onLayoutInflated(WatchViewStub stub) {
                mGridPager = (GridViewPager) stub.findViewById(R.id.pager);
                mGridPager.setAdapter(new LineGridPagerAdapter(LineActivity.this, getFragmentManager()));
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        mGridPager.setCurrentItem(1, 0, true);
                    }
                });
            }
        });
    }
}
