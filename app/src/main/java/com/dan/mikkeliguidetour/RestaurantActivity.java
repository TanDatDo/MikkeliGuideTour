package com.dan.mikkeliguidetour;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import com.dan.mikkeliguidetour.SupportingClass.Feature;
import com.dan.mikkeliguidetour.SupportingClass.FeatureAdapter;

import java.util.ArrayList;

public class RestaurantActivity extends AppCompatActivity {
// display lists of restaurants to users
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_view);
        // create an array list of restaurants and add information into it
        ArrayList<Feature> restaurants = new ArrayList<Feature>();
        restaurants.add(new Feature(getString(R.string.kumari_name),
                getString(R.string.kumari_adress),
                getString(R.string.kumari_url),
                R.drawable.kumari_restaurant));
        restaurants.add(new Feature(getString(R.string.vilee_name),
                getString(R.string.vilee_adress),
                getString(R.string.vilee_url),
                R.drawable.vilee_bistro));
        restaurants.add(new Feature(getString(R.string.huviretki_name),
                getString(R.string.huvireti_address),
                getString(R.string.huviretki_url),
                R.drawable.huviretki));
        restaurants.add(new Feature(getString(R.string.vino_name),
                getString(R.string.vino_address),
                getString(R.string.vino_url),
                R.drawable.ravintola_vino));
        restaurants.add(new Feature(getString(R.string.tertin_name),
                getString(R.string.tertin_address),
                getString(R.string.tertin_url),
                R.drawable.tertin_kantano));

        // create a feature adaptor object
        FeatureAdapter restaurantAdapter= new FeatureAdapter(this, restaurants);
        // find the listview by id
        ListView restaurantsListView= (ListView) findViewById(R.id.list);
        // set the list of restaurants into list view using restaurant adapter
        restaurantsListView.setAdapter(restaurantAdapter);
    }
}
