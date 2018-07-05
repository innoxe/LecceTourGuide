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
public class EventFragment extends Fragment {


    public EventFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.site_list, container, false);

        // Create a list of events
        final ArrayList<Site> sites = new ArrayList<Site>();
        sites.add(new Site(getString(R.string.events_feast_of_saint_oronzo_name), getString(R.string.events_feast_of_saint_oronzo_desc), getString(R.string.events_feast_of_saint_oronzo_coord), R.drawable.img_feast_of_saint_oronzo));
        sites.add(new Site(getString(R.string.events_notte_della_taranta_name), getString(R.string.events_notte_della_taranta_desc), getString(R.string.events_notte_della_taranta_coord), R.drawable.img_notte_della_taranta));
        sites.add(new Site(getString(R.string.events_focara_di_sant_antonio_name), getString(R.string.events_focara_di_sant_antonio_desc), getString(R.string.events_focara_di_sant_antonio_coord), R.drawable.img_focara_di_sant_antonio));
        sites.add(new Site(getString(R.string.events_cortili_aperti_name), getString(R.string.events_cortili_aperti_desc), getString(R.string.events_cortili_aperti_coord), R.drawable.img_cortili_aperti));
        sites.add(new Site(getString(R.string.events_festa_di_san_rocco_name), getString(R.string.events_festa_di_san_rocco_desc), getString(R.string.events_festa_di_san_rocco_coord), R.drawable.img_festa_di_san_rocco));
        sites.add(new Site(getString(R.string.events_sagra_de_lu_ranu_name), getString(R.string.events_sagra_de_lu_ranu_desc), getString(R.string.events_sagra_de_lu_ranu_coord), R.drawable.img_sagra_de_lu_ranu));
        sites.add(new Site(getString(R.string.events_alba_dei_popoli_name), getString(R.string.events_alba_dei_popoli_desc), getString(R.string.events_alba_dei_popoli_coord), R.drawable.img_alba_dei_popoli));

        SiteAdapter adapter = new SiteAdapter(getActivity(), sites);

        ListView listView = (ListView) rootView.findViewById(R.id.list);
        listView.setAdapter(adapter);

        // Set a click listener for every event
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
