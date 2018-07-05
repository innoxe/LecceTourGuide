package com.example.android.leccetourguide;

public class Site {

    private static final int NO_IMAGE_PROVIDED = -1;
    /**
     * Name or title of the site
     */
    private String mName;
    /**
     * Descripition of the site
     */
    private String mDesc;
    /**
     * Coordinates of the site for future map implementation
     */
    private String mCoord;

    /**
     * Image resource ID of the site
     */
    private int mImageResourceId = NO_IMAGE_PROVIDED;

    /**
     * Create a new site object.
     *
     * @param name The name of the site such place or name of food
     *
     * @param desc   desc of the site o source
     *
     * @param coord the coordinates where find the site
     *
     * @param imageResourceId    is the drawable resource ID for the image associate with the site
     *
     */
    public Site(String name, String desc, String coord, int imageResourceId) {
        mName = name;
        mDesc = desc;
        mCoord = coord;
        mImageResourceId = imageResourceId;
    }

    /**
     * Create a new site object withowut coordinates.
     *
     * @param name The name of the site such place or name of food
     *
     * @param desc   desc of the site o source
     *
     *
     * @param imageResourceId    is the drawable resource ID for the image associate with the site
     *
     */
    public Site(String name, String desc, int imageResourceId) {
        mName = name;
        mDesc = desc;
        mImageResourceId = imageResourceId;
    }

    /**
     * Get the name of the site.
     */
    public String getName() {
        return mName;
    }

    /**
     * Get the description of the site.
     */
    public String getDesc() {
        return mDesc;
    }

    /**
     * Get the coordinate of the site.
     */
    public String getCoord() {
        return mCoord;
    }

    /**
     * Get the image resource ID of the site.
     */
    public int getImageResourceId() {
        return mImageResourceId;
    }

    /**
     * Returns whether or not there is an image for this site.
     */
    public boolean hasImage() {
        return mImageResourceId != NO_IMAGE_PROVIDED;
    }


}
