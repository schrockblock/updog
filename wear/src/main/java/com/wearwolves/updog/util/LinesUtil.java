package com.wearwolves.updog.util;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.wearwolves.updog.model.TransitLine;

import java.util.HashMap;

/**
 * Created by adam on 1/10/15.
 */
public class LinesUtil {

    public static String hardcodedRed = "{\n" +
            "\t\"name\" : \"Red Line\",\n" +
            "\t\"identifier\" : \"redline\",\n" +
            "\t\"variant\" : \"\",\n" +
            "\t\"shorthand\" : \"RL\",\n" +
            "\t\"stops\" : \n" +
            "\t[\n" +
            "\t\t{\n" +
            "\t\t\t\"stop_order\": \"1\",\n" +
            "\t\t\t\"stop_id\": \"70061\",\n" +
            "\t\t\t\"stop_name\": \"Alewife\",\n" +
            "\t\t\t\"parent_station\": \"place-alfcl\",\n" +
            "\t\t\t\"parent_station_name\": \"Alewife\",\n" +
            "\t\t\t\"stop_lat\": \"42.395428\",\n" +
            "\t\t\t\"stop_lon\": \"-71.142483\"\n" +
            "\t\t},\n" +
            "\t\t{\n" +
            "\t\t\t\"stop_order\": \"2\",\n" +
            "\t\t\t\"stop_id\": \"70063\",\n" +
            "\t\t\t\"stop_name\": \"Davis\",\n" +
            "\t\t\t\"parent_station\": \"place-davis\",\n" +
            "\t\t\t\"parent_station_name\": \"Davis\",\n" +
            "\t\t\t\"stop_lat\": \"42.39674\",\n" +
            "\t\t\t\"stop_lon\": \"-71.121815\"\n" +
            "\t\t},\n" +
            "\t\t{\n" +
            "\t\t\t\"stop_order\": \"3\",\n" +
            "\t\t\t\"stop_id\": \"70065\",\n" +
            "\t\t\t\"stop_name\": \"Porter\",\n" +
            "\t\t\t\"parent_station\": \"place-portr\",\n" +
            "\t\t\t\"parent_station_name\": \"Porter\",\n" +
            "\t\t\t\"stop_lat\": \"42.3884\",\n" +
            "\t\t\t\"stop_lon\": \"-71.119149\"\n" +
            "\t\t},\n" +
            "\t\t{\n" +
            "\t\t\t\"stop_order\": \"4\",\n" +
            "\t\t\t\"stop_id\": \"70067\",\n" +
            "\t\t\t\"stop_name\": \"Harvard\",\n" +
            "\t\t\t\"parent_station\": \"place-harsq\",\n" +
            "\t\t\t\"parent_station_name\": \"Harvard\",\n" +
            "\t\t\t\"stop_lat\": \"42.373362\",\n" +
            "\t\t\t\"stop_lon\": \"-71.118956\"\n" +
            "\t\t},\n" +
            "\t\t{\n" +
            "\t\t\t\"stop_order\": \"5\",\n" +
            "\t\t\t\"stop_id\": \"70069\",\n" +
            "\t\t\t\"stop_name\": \"Central\",\n" +
            "\t\t\t\"parent_station\": \"place-cntsq\",\n" +
            "\t\t\t\"parent_station_name\": \"Central\",\n" +
            "\t\t\t\"stop_lat\": \"42.365486\",\n" +
            "\t\t\t\"stop_lon\": \"-71.103802\"\n" +
            "\t\t},\n" +
            "\t\t{\n" +
            "\t\t\t\"stop_order\": \"6\",\n" +
            "\t\t\t\"stop_id\": \"70071\",\n" +
            "\t\t\t\"stop_name\": \"Kendall/MIT\",\n" +
            "\t\t\t\"parent_station\": \"place-knncl\",\n" +
            "\t\t\t\"parent_station_name\": \"Kendall/MIT\",\n" +
            "\t\t\t\"stop_lat\": \"42.36249079\",\n" +
            "\t\t\t\"stop_lon\": \"-71.08617653\"\n" +
            "\t\t},\n" +
            "\t\t{\n" +
            "\t\t\t\"stop_order\": \"7\",\n" +
            "\t\t\t\"stop_id\": \"70073\",\n" +
            "\t\t\t\"stop_name\": \"Charles/MGH\",\n" +
            "\t\t\t\"parent_station\": \"place-chmnl\",\n" +
            "\t\t\t\"parent_station_name\": \"Charles/MGH\",\n" +
            "\t\t\t\"stop_lat\": \"42.361166\",\n" +
            "\t\t\t\"stop_lon\": \"-71.070628\"\n" +
            "\t\t},\n" +
            "\t\t{\n" +
            "\t\t\t\"stop_order\": \"8\",\n" +
            "\t\t\t\"stop_id\": \"70075\",\n" +
            "\t\t\t\"stop_name\": \"Park Street\",\n" +
            "\t\t\t\"parent_station\": \"place-pktrm\",\n" +
            "\t\t\t\"parent_station_name\": \"Park Street\",\n" +
            "\t\t\t\"stop_lat\": \"42.35639457\",\n" +
            "\t\t\t\"stop_lon\": \"-71.0624242\"\n" +
            "\t\t},\n" +
            "\t\t{\n" +
            "\t\t\t\"stop_order\": \"9\",\n" +
            "\t\t\t\"stop_id\": \"70077\",\n" +
            "\t\t\t\"stop_name\": \"Downtown Crossing\",\n" +
            "\t\t\t\"parent_station\": \"place-dwnxg\",\n" +
            "\t\t\t\"parent_station_name\": \"Downtown Crossing\",\n" +
            "\t\t\t\"stop_lat\": \"42.355518\",\n" +
            "\t\t\t\"stop_lon\": \"-71.060225\"\n" +
            "\t\t},\n" +
            "\t\t{\n" +
            "\t\t\t\"stop_order\": \"10\",\n" +
            "\t\t\t\"stop_id\": \"70079\",\n" +
            "\t\t\t\"stop_name\": \"South Station\",\n" +
            "\t\t\t\"parent_station\": \"place-sstat\",\n" +
            "\t\t\t\"parent_station_name\": \"South Station\",\n" +
            "\t\t\t\"stop_lat\": \"42.352271\",\n" +
            "\t\t\t\"stop_lon\": \"-71.055242\"\n" +
            "\t\t}\n" +
            "\t]\n" +
            "}";
    public static String hardcodedOrange = "";

    public static HashMap<String, TransitLine> getAllLines() {
        Gson gson = new Gson();
        TransitLine orange = gson.fromJson(hardcodedOrange, TransitLine.class);
        TransitLine red = gson.fromJson(hardcodedRed, TransitLine.class);

        HashMap<String, TransitLine> map = new HashMap<>();
        map.put("orangeline", orange);
        map.put("redline", red);
        return map;
    }

    public static TransitLine getSingleLine (String lineIdentifier) {
        HashMap<String, TransitLine> map = new HashMap<>();
        Gson gson = new Gson();
        TransitLine returnValue = null;

        switch (lineIdentifier) {
            case "orangeline":
                TransitLine orange = gson.fromJson(hardcodedOrange, TransitLine.class);
                returnValue = orange;
                break;
            case "redline":
                TransitLine red = gson.fromJson(hardcodedRed, TransitLine.class);
                returnValue = red;
                break;
        }
        return returnValue;
    }
}
