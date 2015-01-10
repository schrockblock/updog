package com.wearwolves.updog;

import android.app.Application;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

/**
 * Created by adam on 1/10/15.
 */
public class AppController extends Application {
    private RequestQueue mRequestQueue;
    private static AppController mInstance;

    @Override
    public void onCreate() {
        super.onCreate();
        mInstance = this;
    }

    public static synchronized AppController getInstance() {
        return mInstance;
    }

    public RequestQueue getRequestQueue() {
        if(mRequestQueue == null) {
            mRequestQueue = Volley.newRequestQueue(getApplicationContext());
        }

        return mRequestQueue;
    }

    public <T> void addToRequestQueue(Request<T> request, String tag) {
        request.setTag(tag);
        getRequestQueue().add(request);
    }

    public void cancelPendingRequests(Object tag) {
        if(mRequestQueue != null) {
            mRequestQueue.cancelAll(tag);
        }
    }
}
