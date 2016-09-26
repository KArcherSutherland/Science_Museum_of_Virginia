package org.smv.smvguide.Adapters;

/**
 * Created by root on 9/26/16.
 */
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import org.smv.smvguide.Fragments.FragmentOne;
import org.smv.smvguide.Fragments.FragmentThree;
import org.smv.smvguide.Fragments.FragmentTwo;


public class TabsViewPagerAdapter extends FragmentStatePagerAdapter {
    private int[] mIconResouceIds;
    //private String[] mTabTitles;

    public TabsViewPagerAdapter(FragmentManager fragmentManager, int[] iconResourceIds) {
        super(fragmentManager);

        mIconResouceIds = iconResourceIds;
    }

    @Override
    public Fragment getItem(int position) {
        if (0 == position) {
            return FragmentOne.newInstance();
        } else if (1 == position) {
            return FragmentTwo.newInstance();
        } else {
            return FragmentThree.newInstance();
        }
    }

    @Override
    public CharSequence getPageTitle(int position) {
        if(position == 0) {
            return "Page 1";
        }
        else if(position == 1){
            return "Page 2";
        }
        else{
            return "Page 3";
        }
    }

    @Override
    public int getCount() {
        return mIconResouceIds.length;
    }

    public int getDrawableId(int position) {
        return mIconResouceIds[position];
    }
}