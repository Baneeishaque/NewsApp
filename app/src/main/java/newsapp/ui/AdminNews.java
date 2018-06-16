package newsapp.ui;
import java.util.Vector;

import weservice.CallerSignup;
import weservice.CallerVarify;

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

public class AdminNews extends ActionBarActivity {
	Vector ls;
	public static String rslt="";
	String id="";
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_adminnews);
		String title="";
		String content="";
		String category="";
		
		Bundle extras =getIntent().getExtras();
		if(extras!=null){
			content=extras.getString("content");
			title=extras.getString("title");
			category=extras.getString("category");
			id=extras.getString("id");
		}
		ls=new Vector();
		ls.add(title);
		ls.add(content);
		ls.add(category);
		
		
		ArrayAdapter adapter=new ArrayAdapter<String>(this,R.layout.activity_listview,ls);
		final ListView listview=(ListView) findViewById(R.id.list);
		
		listview.setAdapter(adapter);
		
		listview.setClickable(true);
		listview.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {

			@Override
			public boolean onItemLongClick(AdapterView<?> parent, View view,
					int position, long id1) {
				
				
				try 
				{
						rslt="START";	
						CallerVarify c=new CallerVarify();
					
						c.newsid=id;
						c.join();
						c.start();
						while(rslt=="START")
		 		        {
		 		        	try
		 		        	{
		 		        		Thread.sleep(10);
		 		        		
		 		        	}
		 		        	catch(Exception ex)
		 		        	{
		 		        		Toast.makeText(getApplicationContext(),
			 								"Thread sleep Error", Toast.LENGTH_LONG)
			 								.show();

		 		        	}
		 		        }
						
		 		       	if(rslt.equals("ok"))
		 		       	{
		 		       	
		 		       	Toast.makeText(getApplicationContext(),
								"Varyfied..", Toast.LENGTH_LONG)
								.show();
		 	 			
		 		        }
		 		       else
		 		       {
				       				
				       						Toast.makeText(getApplicationContext(),
									"Communication Error resul in", Toast.LENGTH_LONG)
									.show();
				       					
				       						Toast.makeText(getApplicationContext(),
				       								rslt, Toast.LENGTH_LONG)
				       								.show();
				       			       					
				       	}
				       		
				}catch(Exception ex)
		 		{
					Toast.makeText(getApplicationContext(),
								"Thread start Error", Toast.LENGTH_LONG)
								.show();

							Toast.makeText(getApplicationContext(),
									ex.getMessage(), Toast.LENGTH_LONG)
									.show();
		 		        	
		 		}
				
				
				
				
					return false;
					
					//Toast.makeText(getApplicationContext(),(CharSequence) o,Toast.LENGTH_LONG).show();		
			}

			
			
		});

	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.adminnews, menu);
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
			Intent t=new Intent(this,Connect.class);
			startActivity(t); 
		}
		if (id == R.id.about) {
			Intent t=new Intent(this,About.class);
			startActivity(t); 
		}
		if (id == R.id.verify) {
			Intent t=new Intent(this,About.class);
			startActivity(t); 
		}
		return super.onOptionsItemSelected(item);
	}
}