package com.dan.mikkeliguidetour;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import com.dan.mikkeliguidetour.SupportingClass.Feature;
import com.dan.mikkeliguidetour.SupportingClass.FeatureAdapter;

import java.util.ArrayList;

public class PlacesActivity extends AppCompatActivity {
// display a list of interesting places to users
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_view);
        ArrayList<Feature> places = new ArrayList<Feature>();
        places.add(new Feature(getString(R.string.cathedral_name),
                getString(R.string.cathedral_address),
                getString(R.string.cathedral_url),
                R.drawable.mikkeli_church));
        places.add(new Feature(getString(R.string.naivouri_name),
                getString(R.string.naivuori_address),
                getString(R.string.naivouri_url),
                R.drawable.naisvuori));
        places.add(new Feature(getString(R.string.kenkavero_name),
                getString(R.string.kenkavero_address),
                getString(R.string.kenkavero_url),
                R.drawable.kenkavero));
        places.add(new Feature(getString(R.string.museum_name),
                getString(R.string.museum_address),
                getString(R.string.museum_url),
                R.drawable.head_quarter_museum));

        FeatureAdapter placesAdapter = new FeatureAdapter(this, places);
        ListView placeslistView = (ListView) findViewById(R.id.list);
        placeslistView.setAdapter(placesAdapter);
    }
}
