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
    public LinkedList<TransitStation> mStops;
    public transient HashMap<String, TransitStation> mLookup;

    public void init(List<TransitStation> stops) {
        //mStops = new LinkedList<TransitStation>();
        mLookup = new HashMap<String, TransitStation>();
        for(TransitStation stop : stops) {
            //mStops.add(stop);
            mLookup.put(stop.mIdentifier, stop);
        }
    }

    public TransitStation next(TransitStation current) {
        int pos = mStops.indexOf(current);
        TransitStation next = mStops.get(pos + 1);
        return next;
    }

    public boolean hasNext(TransitStation current) {
        int pos = mStops.indexOf(current);
        return mStops.size() > (pos + 1);
    }

    public TransitStation previous(TransitStation current) {
        int pos = mStops.indexOf(current);
        TransitStation previous =mStops.get(pos - 1);
        return previous;
    }

    public boolean hasPrevious(TransitStation current) {
        int pos = mStops.indexOf(current);
        return pos > 0;
    }
}
