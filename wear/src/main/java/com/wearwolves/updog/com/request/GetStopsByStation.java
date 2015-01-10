package com.wearwolves.updog.com.request;

import android.text.TextUtils;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;
import com.wearwolves.updog.AppController;
import com.wearwolves.updog.model.MBTAStop;
import com.wearwolves.updog.model.StopsByLocationResponse;
import com.wearwolves.updog.model.TransitStation;
import com.wearwolves.updog.model.TransitStop;
import com.wearwolves.updog.util.Constants;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by adam on 1/10/15.
 */
public class GetStopsByStation {

    public interface OnResultCallback {
        void onSuccess(ArrayList<TransitStop> stops);
        void onFailure(VolleyError error);
    }

    private transient String REQUEST_TAG = "GetStopsByStation-";
    private transient String URL_FORMAT = "http://realtime.mbta.com/developer/api/v2/stopsbylocation?api_key="+ Constants.MBTA_API_KEY;
    private transient OnResultCallback mCallback;
    private transient TransitStation mStation;

    @SerializedName("lat")
    private float mLatitude;
    @SerializedName("lon")
    private float mLongitude;

    public void get(TransitStation station, OnResultCallback callback) throws JSONException {
        mLatitude = Float.parseFloat(station.mLatitude);
        mLongitude = Float.parseFloat(station.mLongitude);
        mStation = station;
        mCallback = callback;
        String url = String.format(URL_FORMAT + "&lat=%f&lon=%f&format=json", mLatitude, mLongitude);

        JSONObject object = new JSONObject(new Gson().toJson(this));
        JsonObjectRequest request = new JsonObjectRequest(url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                StopsByLocationResponse stops = new Gson().fromJson(response.toString(), StopsByLocationResponse.class);
                if(mCallback != null) {
                    mCallback.onSuccess(parseResult(stops));
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                if(mCallback != null) {
                    mCallback.onFailure(error);
                }
            }
        });
        AppController.getInstance().addToRequestQueue(request, REQUEST_TAG);
    }

    private ArrayList<TransitStop> parseResult(StopsByLocationResponse response) {
        ArrayList<TransitStop> stops = new ArrayList<>();
        for(MBTAStop stop : response.mStops) {
            if(TextUtils.equals(stop.mParentName, mStation.mParentStationName)) {
                stops.add(new TransitStop(stop));
            }
        }
        return stops;
    }
}
