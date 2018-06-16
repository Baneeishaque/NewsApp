package newsapp.ui;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import newsapp.data.Globaldata;

import org.apache.http.NameValuePair;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;

import com.javapapers.android.swipetablayout.app.Reuters;
import com.javapapers.android.swipetablayout.app.SwipeTabFragmentReuters.GetRSSDataTask;

import weservice.CallerLogin;
import weservice.CallerUnreaded;
import weservice.Callerview;

import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;
import android.support.v7.app.ActionBarActivity;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.MenuItem;

public class adminlocal extends ActionBarActivity {
	Vector ls;
	Vector lscon;
	Vector lscat;
	Vector lsid;
	private ProgressDialog dialog;
	private DefaultHttpClient httpclient;
	private HttpPost httppost;
	private ArrayList<NameValuePair> nameValuePairs;
	private String rssUrl;
	private ListView itcitems;
	public static String rslt="";
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_adminlocal);
		ls=new Vector();
		lscon=new Vector();
		lscat=new Vector();
		lsid=new Vector();
		
		itcitems=(ListView) findViewById(R.id.list);
			
		GetRSSDataTask task = new GetRSSDataTask();

		// Start process RSS task
		task.execute("http://"+Globaldata.ip+"/news/rss_unreadnews.php");

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
			Intent t=new Intent(this,Connect.class);
			startActivity(t); 
		}
		if (id == R.id.about) {
			Intent t=new Intent(this,About.class);
			startActivity(t); 
		}
		if (id == R.id.reload) {
			//nidhin();
		}
		return super.onOptionsItemSelected(item);
	}



private class GetRSSDataTask extends AsyncTask<String, Void, List<RssItem> > {
    
    
    @Override
    protected void onPostExecute(List<RssItem> result) {
         
    	//Reuters.item.setVisible(false);
    	  // Create a list adapter
        ArrayAdapter<RssItem> adapter = new ArrayAdapter<RssItem>(getBaseContext(),android.R.layout.simple_list_item_1, result);
        // Set list adapter for the ListView
        itcitems.setAdapter(adapter);
                     
        // Set list view item click listener
        //itcItems.setOnItemClickListener(new ListListener(result, local));
        // Set list view item click listener
        itcitems.setOnItemClickListener(new ListListener5(result ));
    }

	@Override
	protected List<RssItem> doInBackground(String... arg0) {
		try {
			
            // Create RSS reader
            RssReader rssReader = new RssReader(arg0[0]);
         
            // Parse RSS, get items
            return rssReader.getItems();
         
        } catch (Exception e) {
            Log.e("RssChannelActivity", e.getMessage());
        }
		return null;
	}
}

}