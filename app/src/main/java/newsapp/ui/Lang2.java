package newsapp.ui;
import java.util.Vector;

import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;
import android.support.v7.app.ActionBarActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

public class Lang2 extends ActionBarActivity {
	Vector ls;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_lang);
		String title="";
		String content="";
		//String category="";
		Bundle extras =getIntent().getExtras();
		if(extras!=null){
			content=extras.getString("content");
			title=extras.getString("title");
			//category=extras.getString("category");
		}
		ls=new Vector();
		ls.add(title);
		ls.add(content);
		//ls.add(category);
		
		ArrayAdapter adapter=new ArrayAdapter<String>(this,R.layout.activity_listview,ls);
		final ListView listview=(ListView) findViewById(R.id.list);
		
		listview.setAdapter(adapter);
		
		listview.setClickable(true);
		listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
					Object o=listview.getItemAtPosition(position);
					if(o.toString().equals("test"))
					{
						Intent t=new Intent(view.getContext(),English.class);
						startActivity(t);
					}
					
					//Toast.makeText(getApplicationContext(),(CharSequence) o,Toast.LENGTH_LONG).show();		
			}

			
			
		});

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
		if (id == R.id.upload) {
			Intent t=new Intent(this,Uploadnews.class);
			startActivity(t); 
		}
		if (id == R.id.about) {
			Intent t=new Intent(this,About.class);
			startActivity(t); 
		}
		return super.onOptionsItemSelected(item);
	}
}