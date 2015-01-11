package com.wearwolves.updog.adapters;

import android.app.Fragment;
import android.app.FragmentManager;
import android.content.Context;
import android.support.wearable.view.FragmentGridPagerAdapter;

import com.wearwolves.updog.LineActivity;
import com.wearwolves.updog.R;
import com.wearwolves.updog.fragments.StationFragment;
import com.wearwolves.updog.interfaces.OnLineChangedListener;
import com.wearwolves.updog.model.TransitLine;
import com.wearwolves.updog.model.TransitStation;
import com.wearwolves.updog.model.TransitStop;

import java.util.ArrayList;

/**
 * Created by ell on 1/10/15.
 */
public class LineGridPagerAdapter extends FragmentGridPagerAdapter implements OnLineChangedListener{
    private final Context mContext;
    private LineActivity mActivity;
    private TransitLine mLine;

    public LineGridPagerAdapter(LineActivity context, FragmentManager fm, TransitLine line) {
        super(fm);
        mContext = context;
        mLine = line;
        mActivity = context;
    }

    @Override
    public Fragment getFragment(int row, int column) {
        TransitStation station = mLine.mStations.get(row);
        if(station.getNumberOfTransfers() == 0) {
            station.mLines = new ArrayList<>();
            station.mLines.add(mLine); //this is just making up for holes in our data model
        }
        mLine.setCurrentStation(station);
        StationFragment fragment = new StationFragment();
        fragment.setStation(station);
        fragment.setLineChangeListener(this);
        return fragment;
    }

    @Override
    public int getRowCount() {
        return mLine.mStations.size();
    }

    @Override
    public int getColumnCount(int i) {
        return 1;
    }

    @Override
    public void onLineChanged(TransitLine newLine, String currentStationID) {
        mLine = newLine;
        int positionInLine = mLine.getIndexOfStation(currentStationID);
        //need to force the activity to re-retrieve its fragments, given that they've now changed.
        mActivity.lineChanged(newLine, positionInLine);
    }
}
