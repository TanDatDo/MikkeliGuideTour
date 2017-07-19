package com.dan.mikkeliguidetour;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    //show 3 main category for the users to explore about Mikkeli city

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //navigate to the placesActivity when the user click on the place text view
        TextView placesTextView = (TextView) findViewById(R.id.places);
        placesTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent placesIntent = new Intent(getApplicationContext(), PlacesActivity.class);
                startActivity(placesIntent);
            }
        });

        //navigate to the Restaurant Activity when the user click on the restaurant text view
        TextView restaurantTextView = (TextView) findViewById(R.id.restaurants);
        restaurantTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent restaurantIntent = new Intent(getApplicationContext(), RestaurantActivity.class);
                startActivity(restaurantIntent);
            }
        });

        // navigate to the phrase Activity when the user click on the phrase text view
        TextView finnishTextView = (TextView) findViewById(R.id.phrase);
        finnishTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent phraseIntent = new Intent(getApplicationContext(), PhrasesActivity.class);
                startActivity(phraseIntent);
            }
        });

        //navigate to the market Activity when the user click on the market text view
        TextView marketTextView = (TextView) findViewById(R.id.market);
        marketTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent marketIntent = new Intent(getApplicationContext(), MarketsActivity.class);
                startActivity(marketIntent);
            }
        });
    }
}
