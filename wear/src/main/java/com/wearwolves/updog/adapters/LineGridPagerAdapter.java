package com.wearwolves.updog.adapters;

import android.app.Fragment;
import android.app.FragmentManager;
import android.content.Context;
import android.support.wearable.view.FragmentGridPagerAdapter;

import com.wearwolves.updog.R;
import com.wearwolves.updog.fragments.StationFragment;
import com.wearwolves.updog.interfaces.OnLineChangedListener;
import com.wearwolves.updog.model.TransitLine;
import com.wearwolves.updog.model.TransitStop;

import java.util.ArrayList;


/**
 * Created by ell on 1/10/15.
 */
public class LineGridPagerAdapter extends FragmentGridPagerAdapter implements OnLineChangedListener{
    private final Context mContext;
    private TransitLine mLine;

    public LineGridPagerAdapter(Context context, FragmentManager fm) {
        super(fm);
        mContext = context;
    }

    @Override
    public Fragment getFragment(int row, int column) {
        TransitStop stop = new TransitStop();
        switch (row){
            case 0:
                stop.mParentStationName = "Central Square";
                break;
            case 1:
                stop.mParentStationName = "Kendall Square";
                break;
            case 2:
                stop.mParentStationName = "Charles/MGH";
                break;
            case 3:
                stop.mParentStationName = "Park Street";
                stop.mLines = new ArrayList<>();
                stop.mLines.add(new TransitLine());
                stop.mLines.add(new TransitLine());
                break;
        }
        StationFragment fragment = new StationFragment();
        fragment.setStop(stop);
        return fragment;
    }

    @Override
    public int getRowCount() {
        return 4;
    }

    @Override
    public int getColumnCount(int i) {
        return 1;
    }

    @Override
    public void onLineChanged() {

    }
}
