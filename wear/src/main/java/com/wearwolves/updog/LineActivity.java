package com.wearwolves.updog;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.support.wearable.view.GridViewPager;
import android.support.wearable.view.WatchViewStub;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.wearwolves.updog.adapters.LineGridPagerAdapter;
import com.wearwolves.updog.model.TransitLine;
import com.wearwolves.updog.util.LinesUtil;
import com.wearwolves.updog.views.SeekArc;

import java.util.ArrayList;

public class LineActivity extends Activity {

    private GridViewPager mGridPager;
    private TextView mNextStation;
    private TextView mPrevStation;
    private LinearLayout mTop;
    private LinearLayout mBottom;
    private int mColor;
    private String mNext;
    private String mPrev;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_line);
        final WatchViewStub stub = (WatchViewStub) findViewById(R.id.wvs_line_activity);
        stub.setOnLayoutInflatedListener(new WatchViewStub.OnLayoutInflatedListener() {
            @Override
            public void onLayoutInflated(WatchViewStub stub) {

                TransitLine line = LinesUtil.getSingleLine("redline");
                line.init(line.mStations);
                ArrayList<TransitLine> orange = new ArrayList<TransitLine>();
                orange.add(LinesUtil.getSingleLine("orangeline"));
                orange.add(line);
                line.mLookup.get("70077").mLines = orange;
                mGridPager = (GridViewPager) stub.findViewById(R.id.pager);
                mGridPager.setAdapter(new LineGridPagerAdapter(LineActivity.this, getFragmentManager(), line));
            }
        });
    }

    public void setPrev(String name) {
        mPrev = name;
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                mPrevStation.setText(mPrev);
            }
        });
    }

    public void setNext(String name) {
        mNext = name;
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                mPrevStation.setText(mNext);
            }
        });
    }

    public void setLine(String line) {
        if(mTop == null) {

            mTop = (LinearLayout)findViewById(R.id.top);
            mBottom = (LinearLayout)findViewById(R.id.bottom);
            mNextStation = (TextView)findViewById(R.id.tv_next_station);
            mPrevStation = (TextView)findViewById(R.id.tv_previous_station);
        }
        if(TextUtils.equals(line,"red")) {
            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    mTop.setBackgroundResource(R.color.red);
                    mBottom.setBackgroundResource(R.color.red);
                    mTop.invalidate();
                    mBottom.invalidate();
                }
            });
        } else if(TextUtils.equals(line,"green")) {
            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    mTop.setBackgroundColor(Color.GREEN);
                    mBottom.setBackgroundColor(Color.GREEN);
                    mTop.invalidate();
                    mBottom.invalidate();
                }
            });
        }
    }
}
