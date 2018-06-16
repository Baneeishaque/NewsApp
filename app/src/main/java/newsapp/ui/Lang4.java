package newsapp.ui;
import java.util.Vector;

import com.javapapers.android.swipetablayout.app.Reuters;

import android.view.Menu;
import android.view.View;
import android.webkit.WebView;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import android.support.v7.app.ActionBarActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

public class Lang4 extends ActionBarActivity {
	Vector ls;
	private WebView v;
	private TextView txttitle;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		super.setTitle("Reuters : "+Reuters.category);
		setContentView(R.layout.activity_lang2);
		String title="";
		String content="";
		String category="";
		Bundle extras =getIntent().getExtras();
		/*if(extras!=null){
			content=extras.getString("content");
			title=extras.getString("title");
			category=extras.getString("category");
		}*/
		title=ListListener3.b;
		content=ListListener3.c;
		//category=ListListener2.c;
		ls=new Vector();
		ls.add(title);
		ls.add(content);
		//ls.add(category);
		
		/*ArrayAdapter adapter=new ArrayAdapter<String>(this,R.layout.activity_listview,ls);
		final ListView listview=(ListView) findViewById(R.id.list);
		
		listview.setAdapter(adapter);*/
		
		v=(WebView)findViewById(R.id.webnews);
		//String test="<html> <head> </head> <body><b> NEWSAPP END USER SOFTWARE LICENSE AGREEMENT</b></br> NewsApp is a FREE application.<br>  PLEASE READ THIS DOCUMENT CAREFULLY <br><br><b> LICENSE GRANT </b><br> shall be subject to the following terms and  conditions: <br> </br><br><b> OWNERSHIP</b></br> <img src=//feeds.feedburner.com/~r/reuters/technologyNews/~4/qRRegstx1gU></body> </html>";
		
		
		v.loadData(content, "text/html", null);
		txttitle = (TextView) findViewById(R.id.title);
		txttitle.setText(title);
		
		

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