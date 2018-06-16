package newsapp.ui;

import com.javapapers.android.swipetablayout.app.TabPagerAdapter;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.app.ActionBar;
import android.app.ActionBar.Tab;
import android.app.FragmentTransaction;
public class Tabbed extends FragmentActivity implements ActionBar.TabListener {
	ViewPager vp;
	TabPagerAdapter tp;
	ActionBar ab;
	String[] tabs={"First element","Second element","Third"};
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.tabbb);
		vp =(ViewPager)findViewById(R.id.pager);
		tp=new TabPagerAdapter(getSupportFragmentManager());
		vp.setAdapter(tp);
		ab.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);
		for(String tab_name:tabs)
		{
			ab.addTab(ab.newTab().setText(tab_name).setTabListener(this));
		}
		vp.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
			
			@Override
			public void onPageSelected(int arg0) {
				ab.setSelectedNavigationItem(arg0);
				
			}
			
			@Override
			public void onPageScrolled(int arg0, float arg1, int arg2) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void onPageScrollStateChanged(int arg0) {
				// TODO Auto-generated method stub
				
			}
		});{
			
		}
	}
	@Override
	public void onTabSelected(Tab tab, FragmentTransaction ft) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTabUnselected(Tab tab, FragmentTransaction ft) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTabReselected(Tab tab, FragmentTransaction ft) {
		// TODO Auto-generated method stub
		
	}

}
