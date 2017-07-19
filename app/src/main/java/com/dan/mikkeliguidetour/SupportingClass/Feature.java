package com.dan.mikkeliguidetour.SupportingClass;

/**
 * Created by Dat T Do on 7/19/2017.
 */

public class Feature {
    /**
     * {@link Word} represents a feature of Mikkeli city.
     * It contains a feature name, location informaiton, and an image of that places
     */

    /**
     * name of the feature
     */
    private String mName;

    /**
     * location of the feature
     */
    private String mLocation;

    /**
     * Image resource ID of the feature
     */
    private int mImageResourceId;

    /**
     * URL for more information about the feature
     */
    private String mUrl;

    /**
     * Create a new Word object.
     *
     * @param name            of the feature
     * @param location        of the feature
     * @param imageResourceId for the feature
     * @param url             to the website for more information about the feature
     */
    public Feature(String name, String location, String url, int imageResourceId
    ) {
        mName = name;
        mLocation = location;
        mUrl = url;
        mImageResourceId = imageResourceId;
    }

    /**
     * Get the  name of the feature
     */
    public String getName() {
        return mName;
    }

    /**
     * Get the location of the feature.
     */
    public String getLocation() {
        return mLocation;
    }

    /**
     * Return the image resource ID of the feature.
     */
    public int getImageResourceId() {
        return mImageResourceId;
    }

    /**
     * Return the website url containing more information about the feature
     */
    public String getUrl() {
        return mUrl;
    }
}