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
public class ProductFragment extends Fragment {


    public ProductFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.site_list, container, false);

        // Create a list of sites
        final ArrayList<Site> sites = new ArrayList<Site>();
        sites.add(new Site(getString(R.string.products_ceramic_of_lecce_name), getString(R.string.products_ceramic_of_lecce_desc), getString(R.string.products_ceramic_of_lecce_coord), R.drawable.img_ceramic_of_lecce));
        sites.add(new Site(getString(R.string.products_papier_mache_name), getString(R.string.products_papier_mache_desc), getString(R.string.products_papier_mache_coord), R.drawable.img_papier_mache));
        sites.add(new Site(getString(R.string.products_lecce_stone_name), getString(R.string.products_lecce_stone_desc), getString(R.string.products_lecce_stone_coord), R.drawable.img_lecce_stone));
        sites.add(new Site(getString(R.string.products_wrought_iron_name), getString(R.string.products_wrought_iron_desc), getString(R.string.products_wrought_iron_coord), R.drawable.img_wrought_iron));

        SiteAdapter adapter = new SiteAdapter(getActivity(), sites);

        ListView listView = (ListView) rootView.findViewById(R.id.list);
        listView.setAdapter(adapter);

        // Set a click listener for every product
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
