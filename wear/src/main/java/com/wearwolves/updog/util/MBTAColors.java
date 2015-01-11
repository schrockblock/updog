package com.wearwolves.updog.util;

import android.graphics.Color;

import com.wearwolves.updog.AppController;
import com.wearwolves.updog.R;
import com.wearwolves.updog.model.TransitLine;

/**
 * Created by adam on 1/11/15.
 */
public class MBTAColors {

    public static int getColor(TransitLine line) {
        switch (line.mIdentifier) {
            case "orangeline":
                return AppController.getInstance().getResources().getColor(R.color.orange);
            case "redline":
                return AppController.getInstance().getResources().getColor(R.color.red);
            case "blueline":
                return AppController.getInstance().getResources().getColor(R.color.blue);
            case "greenline":
                return AppController.getInstance().getResources().getColor(R.color.green);

        }
        return Color.BLACK;
    }
}
