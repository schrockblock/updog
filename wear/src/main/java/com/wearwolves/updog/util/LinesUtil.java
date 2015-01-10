package com.wearwolves.updog.util;

import com.google.gson.Gson;
import com.wearwolves.updog.model.TransitLine;
import java.util.HashMap;

/**
 * Created by adam on 1/10/15.
 */
public class LinesUtil {

    public static String hardcodedRed = "{" +
            "\"name\" : \"Red Line\"," +
            "\"identifier\" : \"redline\"," +
            "\"variant\" : \"\"," +
            "\"shorthand\" : \"RL\"," +
            "\"stops\" : " +
            "[" +
            "{" +
            "\"stop_order\": \"1\"," +
            "\"stop_id\": \"70061\"," +
            "\"stop_name\": \"Alewife\"," +
            "\"parent_station\": \"place-alfcl\"," +
            "\"parent_station_name\": \"Alewife\"," +
            "\"stop_lat\": \"42.395428\"," +
            "\"stop_lon\": \"-71.142483\"" +
            "}," +
            "{" +
            "\"stop_order\": \"2\"," +
            "\"stop_id\": \"70063\"," +
            "\"stop_name\": \"Davis\"," +
            "\"parent_station\": \"place-davis\"," +
            "\"parent_station_name\": \"Davis\"," +
            "\"stop_lat\": \"42.39674\"," +
            "\"stop_lon\": \"-71.121815\"" +
            "}," +
            "{" +
            "\"stop_order\": \"3\"," +
            "\"stop_id\": \"70065\"," +
            "\"stop_name\": \"Porter\"," +
            "\"parent_station\": \"place-portr\"," +
            "\"parent_station_name\": \"Porter\"," +
            "\"stop_lat\": \"42.3884\"," +
            "\"stop_lon\": \"-71.119149\"" +
            "}," +
            "{" +
            "\"stop_order\": \"4\"," +
            "\"stop_id\": \"70067\"," +
            "\"stop_name\": \"Harvard\"," +
            "\"parent_station\": \"place-harsq\"," +
            "\"parent_station_name\": \"Harvard\"," +
            "\"stop_lat\": \"42.373362\"," +
            "\"stop_lon\": \"-71.118956\"" +
            "}," +
            "{" +
            "\"stop_order\": \"5\"," +
            "\"stop_id\": \"70069\"," +
            "\"stop_name\": \"Central\"," +
            "\"parent_station\": \"place-cntsq\"," +
            "\"parent_station_name\": \"Central\"," +
            "\"stop_lat\": \"42.365486\"," +
            "\"stop_lon\": \"-71.103802\"" +
            "}," +
            "{" +
            "\"stop_order\": \"6\"," +
            "\"stop_id\": \"70071\"," +
            "\"stop_name\": \"Kendall/MIT\"," +
            "\"parent_station\": \"place-knncl\"," +
            "\"parent_station_name\": \"Kendall/MIT\"," +
            "\"stop_lat\": \"42.36249079\"," +
            "\"stop_lon\": \"-71.08617653\"" +
            "}," +
            "{" +
            "\"stop_order\": \"7\"," +
            "\"stop_id\": \"70073\"," +
            "\"stop_name\": \"Charles/MGH\"," +
            "\"parent_station\": \"place-chmnl\"," +
            "\"parent_station_name\": \"Charles/MGH\"," +
            "\"stop_lat\": \"42.361166\"," +
            "\"stop_lon\": \"-71.070628\"" +
            "}," +
            "{" +
            "\"stop_order\": \"8\"," +
            "\"stop_id\": \"70075\"," +
            "\"stop_name\": \"Park Street\"," +
            "\"parent_station\": \"place-pktrm\"," +
            "\"parent_station_name\": \"Park Street\"," +
            "\"stop_lat\": \"42.35639457\"," +
            "\"stop_lon\": \"-71.0624242\"" +
            "}," +
            "{" +
            "\"stop_order\": \"9\"," +
            "\"stop_id\": \"70077\"," +
            "\"stop_name\": \"Downtown Crossing\"," +
            "\"parent_station\": \"place-dwnxg\"," +
            "\"parent_station_name\": \"Downtown Crossing\"," +
            "\"stop_lat\": \"42.355518\"," +
            "\"stop_lon\": \"-71.060225\"" +
            "}," +
            "{" +
            "\"stop_order\": \"10\"," +
            "\"stop_id\": \"70079\"," +
            "\"stop_name\": \"South Station\"," +
            "\"parent_station\": \"place-sstat\"," +
            "\"parent_station_name\": \"South Station\"," +
            "\"stop_lat\": \"42.352271\"," +
            "\"stop_lon\": \"-71.055242\"" +
            "}" +
            "]" +
            "}";
    public static String hardcodedOrange = "{" +
            "\"name\" : \"Orange Line\"," +
            "\"identifier\" : \"orangeline\"," +
            "\"variant\" : \"\"," +
            "\"shorthand\" : \"OL\"," +
            "\"stops\" : " +
            "[" +
            "{" +
            "\"stop_order\": \"1\"," +
            "\"stop_id\": \"70036\"," +
            "\"stop_name\": \"Oak Grove\"," +
            "\"parent_station\": \"place-ogmnl\"," +
            "\"parent_station_name\": \"Oak Grove\"," +
            "\"stop_lat\": \"42.43668\"," +
            "\"stop_lon\": \"-71.071097\"" +
            "}," +
            "{" +
            "\"stop_order\": \"2\"," +
            "\"stop_id\": \"70034\"," +
            "\"stop_name\": \"Malden - Inbound\"," +
            "\"parent_station\": \"place-mlmnl\"," +
            "\"parent_station_name\": \"Malden Center\"," +
            "\"stop_lat\": \"42.426632\"," +
            "\"stop_lon\": \"-71.07411\"" +
            "}," +
            "{" +
            "\"stop_order\": \"3\"," +
            "\"stop_id\": \"70032\"," +
            "\"stop_name\": \"Wellington - Inbound\"," +
            "\"parent_station\": \"place-welln\"," +
            "\"parent_station_name\": \"Wellington\"," +
            "\"stop_lat\": \"42.40237\"," +
            "\"stop_lon\": \"-71.077082\"" +
            "}," +
            "{" +
            "\"stop_order\": \"4\"," +
            "\"stop_id\": \"70278\"," +
            "\"stop_name\": \"Assembly - Inbound\"," +
            "\"parent_station\": \"place-astao\"," +
            "\"parent_station_name\": \"Assembly\"," +
            "\"stop_lat\": \"42.392811\"," +
            "\"stop_lon\": \"-71.077257\"" +
            "}," +
            "{" +
            "\"stop_order\": \"5\"," +
            "\"stop_id\": \"70030\"," +
            "\"stop_name\": \"Sullivan Square - Inbound\"," +
            "\"parent_station\": \"place-sull\"," +
            "\"parent_station_name\": \"Sullivan Square\"," +
            "\"stop_lat\": \"42.383975\"," +
            "\"stop_lon\": \"-71.076994\"" +
            "}," +
            "{" +
            "\"stop_order\": \"6\"," +
            "\"stop_id\": \"70028\"," +
            "\"stop_name\": \"Community College - Inbound\"," +
            "\"parent_station\": \"place-ccmnl\"," +
            "\"parent_station_name\": \"Community College\"," +
            "\"stop_lat\": \"42.373622\"," +
            "\"stop_lon\": \"-71.069533\"" +
            "}," +
            "{" +
            "\"stop_order\": \"7\"," +
            "\"stop_id\": \"70026\"," +
            "\"stop_name\": \"North Station - Orange Line Inbound\"," +
            "\"parent_station\": \"place-north\"," +
            "\"parent_station_name\": \"North Station\"," +
            "\"stop_lat\": \"42.365577\"," +
            "\"stop_lon\": \"-71.06129\"" +
            "}," +
            "{" +
            "\"stop_order\": \"8\"," +
            "\"stop_id\": \"70024\"," +
            "\"stop_name\": \"Haymarket - Orange Line Inbound\"," +
            "\"parent_station\": \"place-haecl\"," +
            "\"parent_station_name\": \"Haymarket\"," +
            "\"stop_lat\": \"42.363021\"," +
            "\"stop_lon\": \"-71.05829\"" +
            "}," +
            "{" +
            "\"stop_order\": \"9\"," +
            "\"stop_id\": \"70022\"," +
            "\"stop_name\": \"State Street - to Forest Hills\"," +
            "\"parent_station\": \"place-state\"," +
            "\"parent_station_name\": \"State Street\"," +
            "\"stop_lat\": \"42.358978\"," +
            "\"stop_lon\": \"-71.057598\"" +
            "}," +
            "{" +
            "\"stop_order\": \"10\"," +
            "\"stop_id\": \"70020\"," +
            "\"stop_name\": \"Downtown Crossing - to Forest Hills\"," +
            "\"parent_station\": \"place-dwnxg\"," +
            "\"parent_station_name\": \"Downtown Crossing\"," +
            "\"stop_lat\": \"42.355518\"," +
            "\"stop_lon\": \"-71.060225\"" +
            "}," +
            "{" +
            "\"stop_order\": \"11\"," +
            "\"stop_id\": \"70018\"," +
            "\"stop_name\": \"Chinatown - Outbound\"," +
            "\"parent_station\": \"place-chncl\"," +
            "\"parent_station_name\": \"Chinatown\"," +
            "\"stop_lat\": \"42.352547\"," +
            "\"stop_lon\": \"-71.062752\"" +
            "}" +
            "]" +
            "}";

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
