package newsapp.ui;

import android.app.ActionBar;
import android.app.Activity;
import android.app.FragmentTransaction;
import android.app.ActionBar.Tab;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class Tabb extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_tabb);
	    // Notice that setContentView() is not used, because we use the root
	    // android.R.id.content as the container for each fragment

	    // setup action bar for tabs
	    ActionBar actionBar1 = getActionBar();
	    actionBar1.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);
	   // actionBar.setDisplayShowTitleEnabled(false);

	    android.app.ActionBar.Tab tab1 = actionBar1.newTab();
	    tab1.setText("Tab1");
	    android.app.ActionBar.Tab tab2 = actionBar1.newTab();
	    tab2.setText("Tab2");
	    tab1.setTabListener(new ActionBar.TabListener() {
			
			@Override
			public void onTabUnselected(Tab tab, FragmentTransaction ft) {
				Toast.makeText(getApplicationContext(), "Unselected", Toast.LENGTH_LONG).show();// TODO Auto-generated method stub
				
			}
			
			@Override
			public void onTabSelected(Tab tab, FragmentTransaction ft) {
				// TODO Auto-generated method stub
				Toast.makeText(getApplicationContext(), "Selected", Toast.LENGTH_LONG).show();// TODO Auto-generated method stub
			}
			
			@Override
			public void onTabReselected(Tab tab, FragmentTransaction ft) {
				// TODO Auto-generated method stub
				Toast.makeText(getApplicationContext(), "Reselected", Toast.LENGTH_LONG).show();// TODO Auto-generated method stub
				
			}
		});
tab2.setTabListener(new ActionBar.TabListener() {
			
			@Override
			public void onTabUnselected(Tab tab, FragmentTransaction ft) {
				Toast.makeText(getApplicationContext(), "Unselected", Toast.LENGTH_LONG).show();// TODO Auto-generated method stub
				
			}
			
			@Override
			public void onTabSelected(Tab tab, FragmentTransaction ft) {
				// TODO Auto-generated method stub
				Toast.makeText(getApplicationContext(), "Selected", Toast.LENGTH_LONG).show();// TODO Auto-generated method stub
			}
			
			@Override
			public void onTabReselected(Tab tab, FragmentTransaction ft) {
				// TODO Auto-generated method stub
				Toast.makeText(getApplicationContext(), "Reselected", Toast.LENGTH_LONG).show();// TODO Auto-generated method stub
				
			}
		});
	    actionBar1.addTab(tab1);
	    actionBar1.addTab(tab2);
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.tabb, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
