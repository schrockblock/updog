package com.wearwolves.updog.model;

import android.graphics.Color;
import android.text.TextUtils;

import com.android.volley.VolleyError;
import com.google.gson.annotations.SerializedName;
import com.wearwolves.updog.com.request.GetStopsByStation;
import com.wearwolves.updog.fragments.StationFragment;
import com.wearwolves.updog.interfaces.StationDisplayInterface;
import com.wearwolves.updog.util.MBTAColors;

import org.json.JSONException;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by adam on 1/10/15.
 */
public class TransitStation {
    @SerializedName("parent_station")
    public String mParentStationId;
    @SerializedName("parent_station_name")
    public String mParentStationName;
    @SerializedName("stop_name")
    public String mName;
    @SerializedName("stop_id")
    public String mIdentifier;
    @SerializedName("stop_lat")
    public String mLatitude;
    @SerializedName("stop_lon")
    public String mLongitude;
    @SerializedName("stop_order")
    public String mOrder;

    private transient TransitLine mCurrentLine;
    public transient ArrayList<TransitLine> mLines;
    public transient ArrayList<TransitStop> mStops;
    private transient StationDisplayInterface mDisplayInterface;

    public String getStationDisplayName() {
        return mParentStationName;
    }

    public int getNumberOfTransfers() {
        if(mLines == null) {
            return 0;
        }
        return mLines.size();
    }

    public TransitLine getCurrentLine() {
        if(mCurrentLine == null && getNumberOfTransfers() > 0) {
            mCurrentLine = mLines.get(0);
        }
        return mCurrentLine;
    }

    public int getCurrentLineColor() {
        if(mCurrentLine == null) {
            return Color.BLACK;
        }
        return MBTAColors.getColor(mCurrentLine);
    }

    public void init(ArrayList<TransitLine> lines) {
        mLines = new ArrayList<>();
        mStops = new ArrayList<>();
        if(lines == null)
            return;
        for(TransitLine line : lines) {
            if(line.mLookup.containsKey(mIdentifier)) {
                mLines.add(line);
            }
        }
    }

    public void setCurrentLineByIdentifier(String identifier) {
        for(TransitLine line : mLines) {
            if(TextUtils.equals(line.mIdentifier,identifier)) {
                mCurrentLine = line;
                if(mDisplayInterface != null) {
                    mDisplayInterface.lineChanged(mCurrentLine);
                }
                return;
            }
        }
    }

    public void getStops(GetStopsByStation.OnResultCallback callback) throws JSONException {
        //call API, get stops on this lat/long
        GetStopsByStation request = new GetStopsByStation();
        request.get(this, callback);
    }

    public void setDisplayInterface(StationDisplayInterface displayInterface) {
        mDisplayInterface = displayInterface;
    }
}
