package com.dan.mikkeliguidetour;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.dan.mikkeliguidetour.SupportingClass.Feature;
import com.dan.mikkeliguidetour.SupportingClass.FeatureAdapter;

import java.util.ArrayList;

public class MarketsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_view);

        //create the new markets array list and add market item into it
        ArrayList<Feature> markets= new ArrayList<Feature>();
        markets.add(new Feature("Stella",
                "Hallituskatu 3-5, 50100 Mikkeli",
                "https://www.kauppakeskusstella.fi/liikkeet",
                R.drawable.stella));
        markets.add(new Feature("K-Citymarket",
                "Graanintie 1, 50190 Mikkeli",
                "http://www.k-citymarket.fi/",
                R.drawable.k_citimarket));
        markets.add(new Feature("Carlson",
                "Laiturikatu 4, 50100 Mikkeli",
                "http://www.carlson.fi/fi/rautakaupat/mikkeli/",
                R.drawable.carlson));
        markets.add(new Feature("Lidl",
                "Setrikatu 3, 50100 Mikkeli",
                "https://www.lidl.fi/fi/myymalahaku.htm",
                R.drawable.lidl));

        //create new adapter object
        FeatureAdapter marketAdapter= new FeatureAdapter(this, markets);
        //find the listview by id
        ListView marketListView=(ListView) findViewById(R.id.list);
        //set the markets list into the list view
        marketListView.setAdapter(marketAdapter);
    }
}
