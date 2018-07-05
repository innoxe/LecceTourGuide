package com.example.android.leccetourguide;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class SeeFragment extends Fragment {


    public SeeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.site_list, container, false);

        // Create a list of to see
        final ArrayList<Site> sites = new ArrayList<Site>();
        sites.add(new Site(getString(R.string.see_monastery_olivetani_name), getString(R.string.see_monastery_olivetani_desc), getString(R.string.see_monastery_olivetani_coord), R.drawable.img_monastery_olivetani));
        sites.add(new Site(getString(R.string.see_roman_theatre_name), getString(R.string.see_roman_theatre_desc), getString(R.string.see_roman_theatre_coord), R.drawable.img_roman_theatre));
        sites.add(new Site(getString(R.string.see_roman_amphitheatre_name), getString(R.string.see_roman_amphitheatre_desc), getString(R.string.see_roman_amphitheatre_coord), R.drawable.img_roman_amphitheatre));
        sites.add(new Site(getString(R.string.see_st_irene_church_name), getString(R.string.see_st_irene_church_desc), getString(R.string.see_st_irene_church_coord), R.drawable.img_st_irene_church));
        sites.add(new Site(getString(R.string.see_piazza_duomo_name), getString(R.string.see_piazza_duomo_desc), getString(R.string.see_piazza_duomo_coord), R.drawable.img_piazza_duomo));
        sites.add(new Site(getString(R.string.see_porta_rudiae_name), getString(R.string.see_porta_rudiae_desc), getString(R.string.see_porta_rudiae_coord), R.drawable.img_porta_rudiae));
        sites.add(new Site(getString(R.string.see_holy_cross_cathedral_name), getString(R.string.see_holy_cross_cathedral_desc), getString(R.string.see_holy_cross_cathedral_coord), R.drawable.img_holy_cross_cathedral));
        sites.add(new Site(getString(R.string.see_palace_of_the_celestini_name), getString(R.string.see_palace_of_the_celestini_desc), getString(R.string.see_palace_of_the_celestini_coord), R.drawable.img_palace_of_the_celestini));
        sites.add(new Site(getString(R.string.see_sedile_name), getString(R.string.see_sedile_desc), getString(R.string.see_sedile_coord), R.drawable.img_sedile));
        sites.add(new Site(getString(R.string.see_bell_tower_name), getString(R.string.see_bell_tower_desc), getString(R.string.see_bell_tower_coord), R.drawable.img_bell_tower));

        SiteAdapter adapter = new SiteAdapter(getActivity(), sites);

        ListView listView = (ListView) rootView.findViewById(R.id.list);
        listView.setAdapter(adapter);


        // Set a click listener for every place to see
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
