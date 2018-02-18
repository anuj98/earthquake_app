package com.example.android.quakereport;

import android.util.Log;
import java.lang.String;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

class Earthquake {
    private String location,mag;
    private long time;
    private double magnitude;

    public Earthquake(Double x, String y, long z) {
        this.magnitude=x;
        this.location=y;
        this.time=z;
    }

    public double getMag(){
        return (magnitude);
    }
    public String getLoc(){
        return location;
    }
    public long getDate(){
        return (time);
    }

}

public final class QueryUtils {
    private static final String SAMPLE_JSON_RESPONSE = "https://"
    private QueryUtils() {
    }
    public static ArrayList<Earthquake> extractEarthquakes() {

        // Create an empty ArrayList that we can start adding earthquakes to
        ArrayList<Earthquake> earthquakes = new ArrayList<>();

        try {

            // TODO: Parse the response given by the SAMPLE_JSON_RESPONSE string and
            JSONObject json = new JSONObject(SAMPLE_JSON_RESPONSE);
            JSONArray features = json.getJSONArray("features");
            for(int i=0; i<features.length(); i++) {
                JSONObject j = features.getJSONObject(i);
                JSONObject prop = j.getJSONObject("properties");
                Double mag = prop.getDouble("mag");
                String loc = prop.getString("place");
                long time = prop.getLong("time");

                Earthquake eq = new Earthquake(mag,loc,time);
                earthquakes.add(eq);
            }

        } catch (JSONException e) {
            Log.e("QueryUtils", "Problem parsing the earthquake JSON results", e);
        }

        // Return the list of earthquakes
        return earthquakes;
    }
}
