package com.wearwolves.updog.model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

/**
 * Created by adam on 1/10/15.
 * Multiple stops for a given station, for the different inbound/outbound directions.
 */
public class TransitStop {

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

    public transient ArrayList<TransitLine> mLines;

    public TransitStop(MBTAStop stop) {
        mParentStationId = stop.mParentId;
        mParentStationName = stop.mParentName;
        mIdentifier = stop.mStopId;
        mName = stop.mStopName;
        mLatitude = stop.mStopLatitude;
        mLongitude = stop.mStopLongitude;
    }

    public void init(ArrayList<TransitLine> lines) {
        mLines = new ArrayList<>();
        if(lines == null)
            return;
        for(TransitLine line : lines) {
            if(line.mLookup.containsKey(mIdentifier)) {
                mLines.add(line);
            }
        }
    }
}
