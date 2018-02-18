package com.example.android.quakereport;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import java.util.ArrayList;

public class EarthquakeActivity extends AppCompatActivity {

    ListView l;
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.earthquake_activity);

        ArrayList<Earthquake> s = QueryUtils.extractEarthquakes();
        EarthquakeAdapter ea = new EarthquakeAdapter(this,s);

        l = (ListView) findViewById(R.id.list);

        l.setAdapter(ea);
    }
}
