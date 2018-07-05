package com.example.android.leccetourguide;

import android.content.Context;
import android.content.res.Configuration;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class SiteAdapter extends ArrayAdapter<Site> {


    /**
     * Create a new {@link SiteAdapter} object.
     *
     * @param context is the current context (i.e. Activity) that the adapter is being created in.
     * @param sites   is the list of {@link Site}s to be displayed.
     */
    public SiteAdapter(Context context, ArrayList<Site> sites) {
        super(context, 0, sites);

    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Check if an existing view is being reused, otherwise inflate the view
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item_material, parent, false);
        }

        // Get the {@link Site} object located at this position in the list
        Site currentSite = getItem(position);


        // Find the TextView in the list_item_material.xml layout with the ID name place.
        TextView nameTextView = (TextView) listItemView.findViewById(R.id.name);
        // Get the name of place from the currentSite object and set this text on
        // the name TextView.
        nameTextView.setText(currentSite.getName());

        // Get The Orientation of screen and set TextView desc in landscape mode
        int currentOrientation = getContext().getResources().getConfiguration().orientation;
        if(currentOrientation == Configuration.ORIENTATION_LANDSCAPE){
            // Find the TextView in the list_item_material.xml layout with the ID desc place.
            TextView descTextView = (TextView) listItemView.findViewById(R.id.desc);
            // Get the desc of place from the currentSite object and set this text on
            // the desc TextView.
            String upToNCharacters = currentSite.getDesc().substring(0, Math.min(currentSite.getDesc().length(), 120));
            descTextView.setText(upToNCharacters);
        }

        // Find the ImageView in the list_item_material.xml layout with the ID image.
        ImageView imageView = (ImageView) listItemView.findViewById(R.id.image);

        if (currentSite.hasImage()) {
            // Set the ImageView to the image resource specified in the current Word
            imageView.setImageResource(currentSite.getImageResourceId());

            //Make sure the view is visible
            imageView.setVisibility(View.VISIBLE);
        } else {
            //Otherwise hide the ImageView (set visibility to GONE)
            imageView.setVisibility(View.GONE);
        }

        // Return the whole list item layout (containing 2 TextViews) so that it can be shown in
        // the ListView.
        return listItemView;

    }
}
