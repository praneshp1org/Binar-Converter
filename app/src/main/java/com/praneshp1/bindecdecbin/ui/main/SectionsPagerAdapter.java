package com.praneshp1.bindecdecbin.ui.main;

import android.content.Context;

import androidx.annotation.Nullable;
import androidx.annotation.StringRes;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.praneshp1.bindecdecbin.BinaryAdd;
import com.praneshp1.bindecdecbin.BinarySub;
import com.praneshp1.bindecdecbin.Binary_2_Decimal;
import com.praneshp1.bindecdecbin.Decimal_2_Binary;
import com.praneshp1.bindecdecbin.R;

/**
 * A [FragmentPagerAdapter] that returns a fragment corresponding to
 * one of the sections/tabs/pages.
 */
public class SectionsPagerAdapter extends FragmentPagerAdapter {

    @StringRes
    private static final int[] TAB_TITLES = new int[]{R.string.tab_text_1, R.string.tab_text_2, R.string.tab_text_3, R.string.tab_text_4};
    private final Context mContext;

    public SectionsPagerAdapter(Context context, FragmentManager fm) {
        super(fm);
        mContext = context;
    }

    @Override
    public Fragment getItem(int position) {
       Fragment fragment = null;
       switch (position){
           case 0:
               fragment = new Binary_2_Decimal();
               break;
           case 1:
               fragment = new Decimal_2_Binary();
               break;
           case 2:
               fragment = new BinaryAdd();
               break;
           case 3:
               fragment = new BinarySub();
               break;
       }
       return fragment;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return mContext.getResources().getString(TAB_TITLES[position]);
    }

    @Override
    public int getCount() {
        // Show 2 total pages.
        return 4;
    }
}