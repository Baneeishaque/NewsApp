package newsapp.ui;
import java.util.Vector;

import weservice.CallerLogin;
import weservice.Callerview;

import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;
import android.support.v7.app.ActionBarActivity;
import android.app.ActionBar;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

public class Local extends ActionBarActivity {
	Vector ls;
	Vector lscon;
	Vector lscat;
	public static String rslt="";
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_local);
		
		
		ls=new Vector();
		lscon=new Vector();
		lscat=new Vector();
		//ls.add("test");
		/**/
		test();
		ArrayAdapter adapter=new ArrayAdapter<String>(this,R.layout.activity_listview,ls);
		final ListView listview=(ListView) findViewById(R.id.list);
		
		listview.setAdapter(adapter);
		
		listview.setClickable(true);
		listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				Intent t=new Intent(view.getContext(),Lang2.class);
				t.putExtra("title", ls.get(position).toString());
				
				t.putExtra("content", lscon.get(position).toString());
				t.putExtra("category", lscat.get(position).toString());
				startActivity(t);
				
			//	Toast.makeText(getApplicationContext(),lscon.get(position).toString(),Toast.LENGTH_LONG).show();					
				//Toast.makeText(getApplicationContext(),lscat.get(position).toString(),Toast.LENGTH_LONG).show();					
						}

			
			
		});

	}
	
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.local, menu);
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
			if(Login.f==1){
				Intent t=new Intent(this,Uploadnews.class);
				startActivity(t); 
			}else{
				Intent t=new Intent(this,Login.class);
				startActivity(t); 
			}
		}
		if (id == R.id.about) {
			Intent t=new Intent(this,About.class);
			startActivity(t); 
		}
		if (id == R.id.reload) {
			test();
		}
		return super.onOptionsItemSelected(item);
	}


	private void test() {
		// TODO Auto-generated method stub
		try 
		{
			
				rslt="START";	
				Callerview c=new Callerview();
			
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
				
 		       	if(rslt.equals("0"))
 		       	{
 		       		
 		       ls.add("");
 	 			
 		        }
 		       else
		       	{
 		    	   
 		    	   String p=rslt;
 		    	  while(p.contains("~"))
 		    	  {
 		    	   int tlen=p.indexOf("~");
 		    	   String n1=p.subSequence(0, tlen).toString();
 		    	   p=p.substring(tlen+1);
 		    	   
 		    	   int slen=n1.indexOf("*");
 		    	   String tit=n1.subSequence(0, slen).toString();
 		    	   String nn1=n1.substring(slen+1);
 		    	   int slen2=nn1.indexOf("*");
 		    	   String con=nn1.subSequence(0, slen2).toString();
 		    	  String cat=nn1.substring(slen2+1);
 		    	  
 		    	  ls.add(tit);
 		    	 lscon.add(con);
 		    	lscat.add(cat);
 		    	  }
 		    	  
 		    	   
		       	}
		       					 		       
 		      
 		       	
		}
		catch(Exception ex)
 		{
			Toast.makeText(getApplicationContext(),
						"Thread start Error", Toast.LENGTH_LONG)
						.show();

					Toast.makeText(getApplicationContext(),
							ex.getMessage(), Toast.LENGTH_LONG)
							.show();
 		        	
 		}
	}
}