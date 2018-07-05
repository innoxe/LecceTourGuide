package com.example.android.leccetourguide;


import android.content.Intent;
import android.graphics.Point;
import android.location.Location;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class PlaceFragment extends Fragment {


    public PlaceFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.site_list, container, false);

        // Create a list of sites
        final ArrayList<Site> sites = new ArrayList<Site>();
        sites.add(new Site(getString(R.string.place_must_museum_name), getString(R.string.place_must_museum_desc), getString(R.string.place_must_museum_coord), R.drawable.img_must_museum));
        sites.add(new Site(getString(R.string.place_saint_oronzo_square_name), getString(R.string.place_saint_oronzo_square_desc), getString(R.string.place_saint_oronzo_square_coord), R.drawable.img_saint_oronzo_square));
        sites.add(new Site(getString(R.string.place_villa_comunale_name), getString(R.string.place_villa_comunale_desc), getString(R.string.place_villa_comunale_coord), R.drawable.img_villa_comunale));
        sites.add(new Site(getString(R.string.place_villa_bray_name), getString(R.string.place_villa_bray_desc), getString(R.string.place_villa_bray_coord), R.drawable.img_villa_bray));
        sites.add(new Site(getString(R.string.place_post_and_telecommunications_palace_name), getString(R.string.place_post_and_telecommunications_palace_desc), getString(R.string.place_post_and_telecommunications_palace_coord), R.drawable.img_post_and_telecommunications_palace));
        sites.add(new Site(getString(R.string.place_palazzo_adorno_name), getString(R.string.place_palazzo_adorno_desc), getString(R.string.place_palazzo_adorno_coord), R.drawable.img_palazzo_adorno));
        sites.add(new Site(getString(R.string.place_hypogeum_palmieri_name), getString(R.string.place_hypogeum_palmieri_desc), getString(R.string.place_hypogeum_palmieri_coord), R.drawable.img_hypogeum_palmieri));
        sites.add(new Site(getString(R.string.place_obelisk_name), getString(R.string.place_obelisk_desc), getString(R.string.place_obelisk_coord), R.drawable.img_obelisk));
        sites.add(new Site(getString(R.string.place_diocesan_museum_name), getString(R.string.place_diocesan_museum_desc), getString(R.string.place_diocesan_museum_coord), R.drawable.img_diocesan_museum));

        SiteAdapter adapter = new SiteAdapter(getActivity(), sites);

        ListView listView = (ListView) rootView.findViewById(R.id.list);
       listView.setAdapter(adapter);

        // Set a click listener for every place
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Site siteSelected = (Site) parent.getItemAtPosition(position);
                String siteName_temp = siteSelected.getName();
                String siteDesc_temp = siteSelected.getDesc();
                String siteCoord_temp = siteSelected.getCoord();
                Integer siteImg_temp = siteSelected.getImageResourceId();

                Intent intent = new Intent(getActivity(), DetailActivity.class);
                intent.putExtra("siteName", siteName_temp);
                intent.putExtra("siteDesc", siteDesc_temp);
                intent.putExtra("siteCoord", siteCoord_temp);
                intent.putExtra("siteImg", siteImg_temp);

                startActivity(intent);
            }
        });


        return rootView;
    }

}
