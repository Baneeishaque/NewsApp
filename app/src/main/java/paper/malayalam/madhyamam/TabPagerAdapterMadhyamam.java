package paper.malayalam.madhyamam;
import newsapp.ui.R;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class TabPagerAdapterMadhyamam extends FragmentPagerAdapter {

    public TabPagerAdapterMadhyamam(FragmentManager fm) {
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
          
           
        }
        bundle.putString("tab",tab);
        bundle.putInt("color", colorResId);
        SwipeTabFragmentMadhyamam swipeTabFragment = new SwipeTabFragmentMadhyamam();
        swipeTabFragment.setArguments(bundle);
        return swipeTabFragment;
    }

    @Override
    public int getCount() {
        return 2;
    }
}