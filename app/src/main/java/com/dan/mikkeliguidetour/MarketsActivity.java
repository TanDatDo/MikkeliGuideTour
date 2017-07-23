package com.dan.mikkeliguidetour;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
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
        ArrayList<Feature> markets = new ArrayList<Feature>();
        markets.add(new Feature(getString(R.string.stella_name),
                getString(R.string.stella_adress),
                getString(R.string.stella_url),
                R.drawable.stella));
        markets.add(new Feature(
                getString(R.string.kcity_name),
                getString(R.string.kcity_adress),
                getString(R.string.kcity_url),
                R.drawable.k_citimarket));
        markets.add(new Feature(getString(R.string.carson_name),
                getString(R.string.carson_adress),
                getString(R.string.carlson_url),
                R.drawable.carlson));
        markets.add(new Feature(getString(R.string.lidl_name),
                getString(R.string.lidl_adress),
                getString(R.string.lidl_url),
                R.drawable.lidl));

        //create new adapter object
        FeatureAdapter marketAdapter = new FeatureAdapter(this, markets);
        //find the listview by id
        ListView marketListView = (ListView) findViewById(R.id.list);
        //set the markets list into the list view
        marketListView.setAdapter(marketAdapter);
    }
}
