package com.wearwolves.updog.fragments;

import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.app.Fragment;
import android.support.wearable.view.WatchViewStub;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.wearwolves.updog.LineActivity;
import com.wearwolves.updog.R;
import com.wearwolves.updog.interfaces.OnLineChangedListener;
import com.wearwolves.updog.interfaces.StationDisplayInterface;
import com.wearwolves.updog.model.TransitLine;
import com.wearwolves.updog.model.TransitStation;
import com.wearwolves.updog.model.TransitStop;
import com.wearwolves.updog.views.SeekArc;

import java.util.List;

/**
 * Created by ell on 1/10/15.
 */
public class StationFragment extends Fragment implements View.OnClickListener, StationDisplayInterface {
    private LinearLayout mSeekArc;
    private View mRootView;
    private TextView mStationName;
    private TextView mDestination1;
    private TextView mDestination2;
    private TextView mDestination3;
    private TextView mPreviousStationName;
    private TextView mNextStationName;
    private TransitStation mStation;
    private TransitLine mCurrentTransitLine;
    private TextView mNextStation;
    private TextView mPrevStation;
    private LinearLayout mTop;
    private LinearLayout mBottom;
    private int mColor;
    private String mNext;
    private String mPrev;
    private OnLineChangedListener mOnLineChangeListener;

    public StationFragment() {
        super();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mRootView = inflater.inflate(R.layout.fragment_station, container, false);

        final WatchViewStub stub = (WatchViewStub) mRootView.findViewById(R.id.wvs_station_fragment);
        stub.setOnLayoutInflatedListener(new WatchViewStub.OnLayoutInflatedListener() {
            @Override
            public void onLayoutInflated(WatchViewStub stub) {
                mSeekArc = (LinearLayout) mRootView.findViewById(R.id.seek_arc);
                mSeekArc.setVisibility(View.GONE);

                mTop = (LinearLayout)mRootView.findViewById(R.id.top);
                mBottom = (LinearLayout)mRootView.findViewById(R.id.bottom);
                mNextStation = (TextView)mRootView.findViewById(R.id.tv_next_station);
                mPrevStation = (TextView)mRootView.findViewById(R.id.tv_previous_station);
                mStationName = (TextView) mRootView.findViewById(R.id.tv_name);
                mDestination1 = (TextView) mRootView.findViewById(R.id.tv_dest1);
                mDestination2 = (TextView) mRootView.findViewById(R.id.tv_dest2);
                mDestination3 = (TextView) mRootView.findViewById(R.id.tv_dest3);
                mPreviousStationName = (TextView) mRootView.findViewById(R.id.tv_previous_station);
                mNextStationName = (TextView) mRootView.findViewById(R.id.tv_next_station);
                ((ImageView)mRootView.findViewById(R.id.iv_bline)).setOnClickListener(StationFragment.this);
                ((ImageView)mRootView.findViewById(R.id.iv_cline)).setOnClickListener(StationFragment.this);
                ((ImageView)mRootView.findViewById(R.id.iv_dline)).setOnClickListener(StationFragment.this);
                ((ImageView)mRootView.findViewById(R.id.iv_eline)).setOnClickListener(StationFragment.this);
                ((ImageView)mRootView.findViewById(R.id.iv_redline)).setOnClickListener(StationFragment.this);

                if (mStation != null){
                    mStation.setDisplayInterface(StationFragment.this);
                    mStationName.setText(mStation.mParentStationName);
                    mCurrentTransitLine = mStation.getCurrentLine();
                    if (mStation.mLines != null && mStation.mLines.size() > 1){
                        mSeekArc.setVisibility(View.VISIBLE);
                    }else {
                        mSeekArc.setVisibility(View.GONE);
                    }
                }
                updatePrevNextHeaders();
            }
        });
        return mRootView;
    }

    public void setLineChangeListener(OnLineChangedListener listener) {
        mOnLineChangeListener = listener;
    }

    public void setUpcomingStops(List<TransitStop> stops) {

    }

    @Override
    public void lineChanged(TransitLine line) {
        mCurrentTransitLine = line;
        //update view
        if(getActivity() != null) {
            getActivity().runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    updatePrevNextHeaders();
                }
            });
        }
        if(mOnLineChangeListener != null) {
            mOnLineChangeListener.onLineChanged(mCurrentTransitLine, mStation.mIdentifier);
        }
    }

    public void setStation(TransitStation station) {
        this.mStation = station;
    }

    private void updatePrevNextHeaders() {
        if(mCurrentTransitLine == null) {
            return;
        }
        TransitStation prev = mCurrentTransitLine.peekPrevious(mStation);
        TransitStation next = mCurrentTransitLine.peekNext(mStation);
        if(prev == null) {
            mPreviousStationName.setText("");
            mTop.setBackgroundColor(Color.TRANSPARENT);
        } else {
            mPreviousStationName.setText(prev.getStationDisplayName());
            mTop.setBackgroundColor(mCurrentTransitLine.getDisplayColor());
        }
        if(next == null) {
            mNextStationName.setText("");
            mBottom.setBackgroundColor(Color.TRANSPARENT);
        } else {
            mNextStationName.setText(next.getStationDisplayName());
            mBottom.setBackgroundColor(mCurrentTransitLine.getDisplayColor());
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.iv_redline:
                mStation.setCurrentLineByIdentifier("redline");
                break;
            /*case R.id.iv_orangeline:
                mStation.setCurrentLineByIdentifier("orangeline");
                break;
            case R.id.iv_blueline:
                mStation.setCurrentLineByIdentifier("blueline");
                break;*/
            case R.id.iv_bline:
                mStation.setCurrentLineByIdentifier("greenline-b");
                break;
            case R.id.iv_cline:
                mStation.setCurrentLineByIdentifier("greenline-c");
                break;
            case R.id.iv_dline:
                mStation.setCurrentLineByIdentifier("greenline-d");
                break;
            case R.id.iv_eline:
                mStation.setCurrentLineByIdentifier("greenline-e");
                break;
        }
    }
}
