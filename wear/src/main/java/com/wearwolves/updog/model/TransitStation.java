package com.wearwolves.updog.model;

import com.android.volley.VolleyError;
import com.google.gson.annotations.SerializedName;
import com.wearwolves.updog.com.request.GetStopsByStation;

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

    public transient ArrayList<TransitLine> mLines;
    public transient ArrayList<TransitStop> mStops;

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

    public void getStops(GetStopsByStation.OnResultCallback callback) throws JSONException {
        //call API, get stops on this lat/long
        GetStopsByStation request = new GetStopsByStation();
        request.get(this, callback);
    }
}
