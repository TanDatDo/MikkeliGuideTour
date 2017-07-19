package com.dan.mikkeliguidetour;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
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
        restaurants.add(new Feature("Kumari",
                "Mikonkatu 11 8L, Mikkeli 50100",
                "https://www.tripadvisor.com/Restaurant_Review-g189909-d6695225-Reviews-Kumari_Nepalese_Restaurant-Mikkeli_Southern_Savonia.html",
                R.drawable.kumari_restaurant));
        restaurants.add(new Feature("Vilee Puoti & Bistro",
                "Savilahdenkatu 11, Mikkeli 50100",
                "https://www.tripadvisor.com/Restaurant_Review-g189909-d4758093-Reviews-Vilee_Puoti_Bistro-Mikkeli_Southern_Savonia.html",
                R.drawable.vilee_bistro));
        restaurants.add(new Feature("Huviretki",
                "Mikonkatu 9, Mikkeli 50100",
                "https://www.tripadvisor.com/Restaurant_Review-g189909-d1079693-Reviews-Huviretki-Mikkeli_Southern_Savonia.html",
                R.drawable.huviretki));
        restaurants.add(new Feature("Restaurant Vino",
                "Mikonkatu 1, Mikkeli 50100",
                "https://www.tripadvisor.com/Restaurant_Review-g189909-d10508101-Reviews-Restaurant_Vino-Mikkeli_Southern_Savonia.html",
                R.drawable.ravintola_vino));
        restaurants.add(new Feature("Tertin Kartano",
                "Kuopiontie 68, Mikkeli 50350",
                "https://www.tripadvisor.co.nz/Restaurant_Review-g189909-d2251366-Reviews-Tertin_Kartano-Mikkeli_Southern_Savonia.html",
                R.drawable.tertin_kantano));

        // create a feature adaptor object
        FeatureAdapter restaurantAdapter= new FeatureAdapter(this, restaurants);
        // find the listview by id
        ListView restaurantsListView= (ListView) findViewById(R.id.list);
        // set the list of restaurants into list view using restaurant adapter
        restaurantsListView.setAdapter(restaurantAdapter);
    }
}
