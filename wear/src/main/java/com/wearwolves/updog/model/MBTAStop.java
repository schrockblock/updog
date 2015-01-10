package com.wearwolves.updog.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by adam on 1/10/15.
 */
public class MBTAStop {
    @SerializedName("stop_id")
    public String mStopId;
    @SerializedName("stop_name")
    public String mStopName;
    @SerializedName("parent_station")
    public String mParentId;
    @SerializedName("parent_station_name")
    public String mParentName;
    @SerializedName("stop_lat")
    public String mStopLatitude;
    @SerializedName("stop_lon")
    public String mStopLongitude;
    @SerializedName("distance")
    public String mDistance;

}
