package com.wearwolves.updog.model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

/**
 * Created by adam on 1/10/15.
 */
public class StopsByLocationResponse {
    @SerializedName("stop")
    public ArrayList<MBTAStop> mStops;
}
