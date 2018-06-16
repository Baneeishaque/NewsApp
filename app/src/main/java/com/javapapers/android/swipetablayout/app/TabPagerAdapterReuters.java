package com.javapapers.android.swipetablayout.app;
import newsapp.ui.R;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class TabPagerAdapterReuters extends FragmentPagerAdapter {

    public TabPagerAdapterReuters(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int index) {
        Bundle bundle = new Bundle();
        String tab = "";
        int colorResId = 0;
        switch (index) {
            case 0:
                tab = "1";
                colorResId = R.color.color1;
                break;
            case 1:
                tab = "2";
                colorResId = R.color.color2;
                break;
            case 2:
                tab = "3";
                colorResId = R.color.color3;
                break;
           
        }
        bundle.putString("tab",tab);
        bundle.putInt("color", colorResId);
        SwipeTabFragmentReuters swipeTabFragment = new SwipeTabFragmentReuters();
        swipeTabFragment.setArguments(bundle);
        return swipeTabFragment;
    }

    @Override
    public int getCount() {
        return 4;
    }
}