package com.javapapers.android.swipetablayout.app;
import newsapp.ui.Lang;
import newsapp.ui.R;
import newsapp.ui.Signup;
import android.app.ActionBar;
import android.app.ActionBar.Tab;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends FragmentActivity implements
        ActionBar.TabListener {

    private ViewPager viewPager;
    public static String category;
    public static int count=1;
    private ActionBar actionBar;
    private TabPagerAdapter tabPagerAdapter;
    private String[] tabs = {"Kerala","National","International","Sports","Technology","Education","Entertainment","Travel","Movie","Health"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        viewPager = (ViewPager) findViewById(R.id.pager);
        tabPagerAdapter = new TabPagerAdapter(getSupportFragmentManager());
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
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.licance, menu);
		return true;
	}
    
    @Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.sign) {
			Intent intent = new Intent(this,Signup.class);
			startActivity(intent);
			return true;
		}
		if (id == R.id.othernews) {
			Intent intent = new Intent(this,Lang.class);
			startActivity(intent);
			return true;
		}
		return super.onOptionsItemSelected(item);
		
	}

    @Override
    public void onTabReselected(Tab tab, FragmentTransaction ft) { }

    @Override
    public void onTabSelected(Tab tab, FragmentTransaction ft) {
        category=tab.getText().toString();
   
    	viewPager.setCurrentItem(tab.getPosition());
    	
    }

    @Override
    public void onTabUnselected(Tab tab, FragmentTransaction ft) {}
}