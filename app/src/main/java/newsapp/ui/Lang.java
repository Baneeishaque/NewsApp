package newsapp.ui;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.javapapers.android.swipetablayout.app.Localnews;
import com.javapapers.android.swipetablayout.app.MainActivity;

public class Lang extends ActionBarActivity {
	String[] ls = {"English","Malayalam","Hindi","","Local News"};
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_lang);
	
		
		
		ArrayAdapter adapter=new ArrayAdapter<String>(this,R.layout.activity_listview,ls);
		final ListView listview=(ListView) findViewById(R.id.list);
		
		listview.setAdapter(adapter);
		
		listview.setClickable(true);
		listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
					Object o=listview.getItemAtPosition(position);
					if(o.toString().equals("English"))
					{
						Intent t=new Intent(view.getContext(),English.class);
						startActivity(t);
						
					}
					if(o.toString().equals("Malayalam"))
					{
						Intent t=new Intent(view.getContext(),Malayalam.class);
						startActivity(t);
					}
					if(o.toString().equals("Local News"))
					{
						//Intent t=new Intent(view.getContext(),MainActivity.class);
						Intent t=new Intent(view.getContext(),Localnews.class);
						startActivity(t); 
					}
					
			}

			
			
		});

	}
	@Override
	public void onBackPressed() 
	{
		Intent intent = new Intent(Intent.ACTION_MAIN);
		intent.addCategory(Intent.CATEGORY_HOME);
		intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
		startActivity(intent);
	}
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.lang, menu);
		return true;
	}
	

	public void onclik(View v){
		Intent t=new Intent(this,English.class);
		startActivity(t);
		
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
		if (id == R.id.Sign_in) {
			Intent t=new Intent(this,Login.class);
			startActivity(t); 
		}
		if (id == R.id.about) {
			Intent t=new Intent(this,About.class);
			startActivity(t); 
		}
	
		return super.onOptionsItemSelected(item);
	}
}