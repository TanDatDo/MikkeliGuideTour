package com.dan.mikkeliguidetour.SupportingClass;

import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;


import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.dan.mikkeliguidetour.R;

import java.util.ArrayList;

/**
 * {@link PhraseAdapter} is an {@link ArrayAdapter} that can provide the layout for each list item
 * based on a data source, which is a list of {@link Phrase} objects.
 */
public class PhraseAdapter extends ArrayAdapter<Phrase> {

    /**
     * Create a new {@link PhraseAdapter} object.
     *
     * @param context is the current context (i.e. Activity) that the adapter is being created in.
     * @param phrases is the list of {@link Phrase}s to be displayed.
     */
    public PhraseAdapter(Context context, ArrayList<Phrase> phrases) {
        super(context, 0, phrases);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Check if an existing view is being reused, otherwise inflate the view
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.phrase_list_item, parent, false);
        }

        // Get the {@link Phrase} object located at this position in the list
        Phrase currentPhrase = getItem(position);

        // Find the TextView in the list_view.xml layout with the ID finnish_text_view.
        TextView finnishTextView = (TextView) listItemView.findViewById(R.id.finnish_text_view);
        // Get the finnish phrase from the currentPhrase object and set this text on
        // the finnish TextView.
        finnishTextView.setText(currentPhrase.getFinnishPhrase());

        // Find the TextView in the list_view.xml layout with the ID translation_text_view.
        TextView translationTextView = (TextView) listItemView.findViewById(R.id.translation_text_view);
        // Get the translation from the currentPhrase object and set this text on
        // the translation TextView.
        translationTextView.setText(currentPhrase.getTranslation());

        // Return the whole list item layout (containing 2 TextViews) so that it can be shown in
        // the ListView.
        return listItemView;
    }
}
