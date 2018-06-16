package newsapp.ui;

import newsapp.data.Globaldata;

import com.javapapers.android.swipetablayout.app.MainActivity;
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
import android.widget.Toast;

public class English extends ActionBarActivity {
	String[] ls = {"Newyork Times","Reuters","The New Indian Express","India Today","The Indian Express"};
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_english);
		
		ArrayAdapter adapter=new ArrayAdapter<String>(this,R.layout.activity_listview,ls);
		final ListView listview=(ListView) findViewById(R.id.list);
		listview.setAdapter(adapter);
		listview.setClickable(true);
		listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
					Object o=listview.getItemAtPosition(position);
					if(o.toString().equals("India Today"))
					{
						//Toast.makeText(getApplicationContext(), "hai", Toast.LENGTH_LONG).show();
						Intent artIntent = new Intent(view.getContext(), RssChannelActivity.class);
						// Set Art category RSS URL
						//artIntent.putExtra("rss-url", "http://www.madhyamam.com/lifestyle/rss.xml");
						artIntent.putExtra("rss-url", "http://"+Globaldata.ip+"/News/rss.php");
						startActivity(artIntent);
					}
					
					if(o.toString().equals("Reuters"))
					{
						Intent t=new Intent(view.getContext(),Reuters.class);
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
		getMenuInflater().inflate(R.menu.english, menu);
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
