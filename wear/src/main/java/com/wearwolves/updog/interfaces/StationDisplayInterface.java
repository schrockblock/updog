package com.wearwolves.updog.interfaces;

import com.wearwolves.updog.model.TransitLine;
import com.wearwolves.updog.model.TransitStation;
import com.wearwolves.updog.model.TransitStop;
import java.util.List;

/**
 * Created by adam on 1/11/15.
 */
public interface StationDisplayInterface {
    public void setStation(TransitStation station);
    public void setUpcomingStops(List<TransitStop> stops);
    public void lineChanged(TransitLine line);
}
