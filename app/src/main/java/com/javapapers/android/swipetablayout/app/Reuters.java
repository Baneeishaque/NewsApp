package com.javapapers.android.swipetablayout.app;
import newsapp.ui.R;
import android.app.ActionBar;
import android.app.ActionBar.Tab;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class Reuters extends FragmentActivity implements
        ActionBar.TabListener {

    private ViewPager viewPager;
    public static String category;
    private ActionBar actionBar;
    private TabPagerAdapterReuters tabPagerAdapter;
    private String[] tabs = {"Arts","Technology","Sports"};
    public static MenuItem item;
    
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.welcome, menu);
        item=menu.findItem(R.id.wait);
        return true;
    }
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        super.setTitle("Reuters");
        viewPager = (ViewPager) findViewById(R.id.pager);
        tabPagerAdapter = new TabPagerAdapterReuters(getSupportFragmentManager());
        viewPager.setAdapter(tabPagerAdapter);
        actionBar = getActionBar();
        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);
        for (String tab_name : tabs) {
            actionBar.addTab(actionBar.newTab().setText(tab_name)
                    .setTabListener(this));
        }

        viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {

            /**
             * on swipe select the respective tab
             * */
            @Override
            public void onPageSelected(int position) {
                actionBar.setSelectedNavigationItem(position);
            }

            @Override
            public void onPageScrolled(int arg0, float arg1, int arg2) { }

            @Override
            public void onPageScrollStateChanged(int arg0) { }
        });
    }

    @Override
    public void onTabReselected(Tab tab, FragmentTransaction ft) { }

    @Override
    public void onTabSelected(Tab tab, FragmentTransaction ft) {
        //Toast.makeText(getApplicationContext(), tab.getText(), Toast.LENGTH_SHORT).show();
    	category=tab.getText().toString();
    	//Toast.makeText(getApplicationContext(), category, Toast.LENGTH_SHORT).show();
    	
    	viewPager.setCurrentItem(tab.getPosition());
    }

    @Override
    public void onTabUnselected(Tab tab, FragmentTransaction ft) {}
}