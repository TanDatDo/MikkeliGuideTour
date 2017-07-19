package com.dan.mikkeliguidetour;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
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
        places.add(new Feature("Mikkeli Cathedral",
                "Ristimaenkatu 2 50100 Mikkeli",
                "https://www.tripadvisor.com/Attraction_Review-g189909-d4701252-Reviews-Mikkeli_Cathedral-Mikkeli_Southern_Savonia.html",
                R.drawable.mikkeli_church));
        places.add(new Feature("Naivouri",
                "50100 Mikkeli center",
                "https://www.tripadvisor.com/Attraction_Review-g189909-d8587629-Reviews-Naisvuori_Observation_Tower-Mikkeli_Southern_Savonia.html",
                R.drawable.naisvuori));
        places.add(new Feature("Kenkavero",
                "Pursialankatu 6, 50100",
                "https://www.tripadvisor.com/Attraction_Review-g189909-d6953599-Reviews-Kenkavero-Mikkeli_Southern_Savonia.html",
                R.drawable.kenkavero));
        places.add(new Feature("Head Quarter Museum",
                "Paeaemajankuja 1, Mikkeli 50100",
                "https://www.tripadvisor.com/Attraction_Review-g189909-d6483979-Reviews-Headquarters_Museum-Mikkeli_Southern_Savonia.html",
                R.drawable.head_quarter_museum));

        FeatureAdapter placesAdapter = new FeatureAdapter(this, places);
        ListView placeslistView = (ListView) findViewById(R.id.list);
        placeslistView.setAdapter(placesAdapter);
    }
}
