package com.example.android.leccetourguide;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class CategoryAdapter extends FragmentPagerAdapter {

    /** Context of the app */
    private Context mContext;

    public CategoryAdapter(Context context, FragmentManager fm) {
        super(fm);
        mContext = context;
    }



    @Override
    public Fragment getItem(int position) {
        if (position == 0) {
            return new PlaceFragment();
        } else if (position == 1) {
            return new SeeFragment();
        } else if (position == 2) {
            return new EventFragment();
        } else if (position == 3) {
            return new FoodFragment();
        } else {
            return new ProductFragment();
        }
    }

    @Override
    public int getCount() {
        return 5;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        switch (position) {
            case 0:
                return mContext.getString(R.string.category_place);
            case 1:
                return mContext.getString(R.string.category_see);
            case 2:
                return mContext.getString(R.string.category_event);
            case 3:
                return mContext.getString(R.string.category_food);
            case 4:
            return mContext.getString(R.string.category_product);
            default:
                return null;

        }
    }
}
