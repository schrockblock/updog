package com.wearwolves.updog.interfaces;

import com.wearwolves.updog.model.TransitLine;

/**
 * Created by ell on 1/10/15.
 */
public interface OnLineChangedListener {
    public void onLineChanged(TransitLine newLine, String stationId);
}
