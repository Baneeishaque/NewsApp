package com.javapapers.android.swipetablayout.app;
import newsapp.ui.R;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class TabPagerAdapter extends FragmentPagerAdapter {

    public TabPagerAdapter(FragmentManager fm) {
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
            case 3:
                tab = "4";
                colorResId = R.color.color3;
                break;
            case 4:
                tab = "5";
                colorResId = R.color.color3;
                break;
            case 5:
                tab = "6";
                colorResId = R.color.color3;
                break;
            case 6:
                tab = "7";
                colorResId = R.color.color3;
                break;
            case 7:
                tab = "8";
                colorResId = R.color.color3;
                break;
            case 8:
                tab = "9";
                colorResId = R.color.color3;
                break;
            case 9:
                tab = "10";
                colorResId = R.color.color3;
                break;
        }
        bundle.putString("tab",tab);
        bundle.putInt("color", colorResId);
        SwipeTabFragment swipeTabFragment = new SwipeTabFragment();
        swipeTabFragment.setArguments(bundle);
        return swipeTabFragment;
    }

    @Override
    public int getCount() {
        return 10;
    }
}