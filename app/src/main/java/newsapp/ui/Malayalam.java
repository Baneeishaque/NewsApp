package newsapp.ui;

import paper.malayalam.madhyamam.Madhyamam;

import com.javapapers.android.swipetablayout.app.Reuters;

import android.support.v7.app.ActionBarActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class Malayalam extends ActionBarActivity {
	String[] ls = {"Malayala Manorama","Mathrubhumi","Madhyamam","Mangalam"};
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_malayalam);
		
		ArrayAdapter adapter=new ArrayAdapter<String>(this,R.layout.activity_listview,ls);
		final ListView listview=(ListView) findViewById(R.id.list);
		listview.setAdapter(adapter);
		listview.setClickable(true);
		listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
					Object o=listview.getItemAtPosition(position);
					
					
					if(o.toString().equals("Madhyamam"))
					{
						Intent t=new Intent(view.getContext(),Madhyamam.class);
						//Intent t=new Intent(view.getContext(),Lang5.class);
						
						//t.putExtra("rss-url", "http://feeds.reuters.com/news/artsculture?format=xml");
						startActivity(t); 
					}
					//Toast.makeText(getApplicationContext(),(CharSequence) o,Toast.LENGTH_LONG).show();		
			}

			
			
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.malayalam, menu);
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
