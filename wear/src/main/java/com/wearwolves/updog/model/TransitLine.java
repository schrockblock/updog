package com.wearwolves.updog.model;

import com.google.gson.annotations.SerializedName;

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
    public LinkedList<TransitStop> mStops;
    public transient HashMap<String, TransitStop> mLookup;

    public void init(List<TransitStop> stops) {
        //mStops = new LinkedList<TransitStop>();
        mLookup = new HashMap<String, TransitStop>();
        for(TransitStop stop : stops) {
            //mStops.add(stop);
            mLookup.put(stop.mIdentifier, stop);
        }
    }

    public TransitStop next(TransitStop current) {
        int pos = mStops.indexOf(current);
        TransitStop next = mStops.get(pos + 1);
        return next;
    }

    public boolean hasNext(TransitStop current) {
        int pos = mStops.indexOf(current);
        return mStops.size() > (pos + 1);
    }

    public TransitStop previous(TransitStop current) {
        int pos = mStops.indexOf(current);
        TransitStop previous =mStops.get(pos - 1);
        return previous;
    }

    public boolean hasPrevious(TransitStop current) {
        int pos = mStops.indexOf(current);
        return pos > 0;
    }
}
