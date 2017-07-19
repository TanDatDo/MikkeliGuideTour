package com.dan.mikkeliguidetour.SupportingClass;


import android.content.Intent;
import android.net.Uri;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.dan.mikkeliguidetour.R;

import java.util.ArrayList;


import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * {@link FeatureAdapter} is an {@link ArrayAdapter} that can provide the layout for each list item
 * based on a data source, which is a list of {@link Feature} objects.
 */
public class FeatureAdapter extends ArrayAdapter<Feature> {


    /**
     * Create a new {@link FeatureAdapter} object.
     *
     * @param context  is the current context (i.e. Activity) that the adapter is being created in.
     * @param features is the list of {@link Feature}s to be displayed.
     */
    public FeatureAdapter(Context context, ArrayList<Feature> features) {
        super(context, 0, features);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Check if an existing view is being reused, otherwise inflate the view
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.feature_list_item, parent, false);
        }

        // Get the {@link Feature} object located at this position in the list
        final Feature currentFeature = getItem(position);

        // Find the name TextView in the list_view.xml layout with the ID name_text_view.
        TextView nameTextView = (TextView) listItemView.findViewById(R.id.name_text_view);
        // Get the Name from the currentWord object and set this text on
        // the name TextView.
        nameTextView.setText(currentFeature.getName());

        // Find the TextView in the list_view.xml layout with the ID location_text_view.
        TextView defaultTextView = (TextView) listItemView.findViewById(R.id.location_text_view);
        // Get the location text from the currentFeature object and set this text on
        // the location TextView.
        defaultTextView.setText(currentFeature.getLocation());

        // Find the ImageView in the list_view.xml layout with the ID image.
        ImageView imageView = (ImageView) listItemView.findViewById(R.id.image_view);
        // Get the image Resource id from the currentFeature object and set this image on
        // the image View.
        imageView.setImageResource(currentFeature.getImageResourceId());
        // Return the whole list item layout (containing 2 TextViews and 1 ImageView) so that it can be shown in
        // the ListView.

        // find the button in the list_view.xml layout with the id button_view
        Button button= (Button) listItemView.findViewById(R.id.button_view);
        //when users click on the button, navigate to the website containing more info about
        // the curreny feature
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //get the url of the website from current feature object
                String Url= currentFeature.getUrl();
                //sent intent to the website
                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_VIEW);
                intent.addCategory(Intent.CATEGORY_BROWSABLE);
                intent.setData(Uri.parse(Url));
                getContext().startActivity(intent);
            }
        });

        return listItemView;
    }
}


