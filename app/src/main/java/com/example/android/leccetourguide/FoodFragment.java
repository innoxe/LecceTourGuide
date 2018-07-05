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
public class FoodFragment extends Fragment {


    public FoodFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.site_list, container, false);

        // Create a list of sites
        final ArrayList<Site> sites = new ArrayList<Site>();
        sites.add(new Site(getString(R.string.food_pasticciotto_name), getString(R.string.food_pasticciotto_desc), getString(R.string.food_pasticciotto_coord), R.drawable.img_pasticciotto));
        sites.add(new Site(getString(R.string.food_primitivo_di_manduria_name), getString(R.string.food_primitivo_di_manduria_desc), getString(R.string.food_primitivo_di_manduria_coord), R.drawable.img_primitivo_di_manduria));
        sites.add(new Site(getString(R.string.food_rustico_name), getString(R.string.food_rustico_desc), getString(R.string.food_rustico_coord), R.drawable.img_rustico));
        sites.add(new Site(getString(R.string.food_friseddha_name), getString(R.string.food_friseddha_desc), getString(R.string.food_friseddha_coord), R.drawable.img_friseddha));
        sites.add(new Site(getString(R.string.food_mustazzoli_name), getString(R.string.food_mustazzoli_desc), getString(R.string.food_mustazzoli_coord), R.drawable.img_mustazzoli));
        sites.add(new Site(getString(R.string.food_pittule_name), getString(R.string.food_pittule_desc), getString(R.string.food_pittule_coord), R.drawable.img_pittule));
        sites.add(new Site(getString(R.string.food_ciceri_e_tria_name), getString(R.string.food_ciceri_e_tria_desc), getString(R.string.food_ciceri_e_tria_coord), R.drawable.img_ciceri_e_tria));
        sites.add(new Site(getString(R.string.food_fave_e_cicorie_name), getString(R.string.food_fave_e_cicorie_desc), getString(R.string.food_fave_e_cicorie_coord), R.drawable.img_fave_e_cicorie));
        sites.add(new Site(getString(R.string.food_negroamaro_name), getString(R.string.food_negroamaro_desc), getString(R.string.food_negroamaro_coord), R.drawable.img_negroamaro));
        sites.add(new Site(getString(R.string.food_taieddha_name), getString(R.string.food_taieddha_desc), getString(R.string.food_taieddha_coord), R.drawable.img_taieddha));

        SiteAdapter adapter = new SiteAdapter(getActivity(), sites);

        ListView listView = (ListView) rootView.findViewById(R.id.list);
        listView.setAdapter(adapter);

// Set a click listener for every food
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
