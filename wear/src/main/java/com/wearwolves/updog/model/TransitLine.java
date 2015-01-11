package com.wearwolves.updog.model;

import android.text.TextUtils;
import android.util.Log;

import com.google.gson.annotations.SerializedName;
import com.wearwolves.updog.util.MBTAColors;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by adam on 1/10/15.
 */
public class TransitLine {

    @SerializedName("name")
    public String mName;
    @SerializedName("identifier")
    public String mIdentifier;
    @SerializedName("variant")
    public String mVariant;
    @SerializedName("shorthand")
    public String mShorthand;
    @SerializedName("stops")
    public LinkedList<TransitStation> mStations;
    public transient HashMap<String, TransitStation> mLookup;

    private TransitStation mCurrentStation = null;

    public TransitStation getCurrentStop() {
        return mCurrentStation;
    }

    public void setCurrentStation(TransitStation station) {
        mCurrentStation = station;
    }

    public void setCurrentStation(int position) {
        if(mStations == null || mStations.size() <= position + 1)
            return;
        mCurrentStation = mStations.get(position);
    }

    public void setCurrentStation(String stationIdentifier) {
        for(TransitStation station : mStations) {
            if(TextUtils.equals(stationIdentifier, station.mIdentifier)) {
                mCurrentStation = station;
                return;
            }
        }
        Log.d("WhatsUpDog", "setCurrentStation called with id=" + stationIdentifier + ", but no station found");
    }

    public void init(List<TransitStation> stations) {
        //mStops = new LinkedList<TransitStation>();
        mLookup = new HashMap<String, TransitStation>();
        for(TransitStation station : stations) {
            //mStops.add(Station);
            if(mCurrentStation == null) {
                mCurrentStation = station;
            }
            mLookup.put(station.mIdentifier, station);
        }
    }

    public TransitStation peekNext(TransitStation current) {
        if(!hasNext(current)) {
            return null;
        }
        int pos = mStations.indexOf(current);
        TransitStation next = mStations.get(pos + 1);
        return next;
    }

    public TransitStation moveNext(TransitStation current) {
        if(!hasNext(current)) {
            return null;
        }
        int pos = mStations.indexOf(current);
        TransitStation next = mStations.get(pos + 1);
        mCurrentStation = next;
        return next;
    }

    public boolean hasNext(TransitStation current) {
        int pos = mStations.indexOf(current);
        return mStations.size() > (pos + 1);
    }

    public TransitStation peekPrevious(TransitStation current) {
        if(!hasPrevious(current)) {
            return null;
        }
        int pos = mStations.indexOf(current);
        TransitStation previous = mStations.get(pos - 1);
        return previous;
    }

    public TransitStation movePrevious(TransitStation current) {
        if(!hasPrevious(current)) {
            return null;
        }
        int pos = mStations.indexOf(current);
        TransitStation previous = mStations.get(pos - 1);
        mCurrentStation = previous;
        return previous;
    }

    public boolean hasPrevious(TransitStation current) {
        int pos = mStations.indexOf(current);
        return pos > 0;
    }

    public int getDisplayColor() {
        return MBTAColors.getColor(this);
    }

    public int getIndexOfStation(String currentStationID) {
        for(int x = 0; x < mStations.size(); x++) {
            if(mStations.get(x).mIdentifier.equals(currentStationID)) {
                return x;
            }
        }
        return 0;
    }
}
