package newsapp.ui;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import com.javapapers.android.swipetablayout.app.MainActivity;

import android.support.v7.app.ActionBarActivity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebView;

public class Licance extends ActionBarActivity {

	WebView  v;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_licance);
		v=(WebView)findViewById(R.id.webnews);
		v.loadUrl("file:///android_asset/licance.html");
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
		getMenuInflater().inflate(R.menu.licance, menu);
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
	
	public void tohome(View v)
	{
		Intent intent = new Intent(Intent.ACTION_MAIN);
		intent.addCategory(Intent.CATEGORY_HOME);
		intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
		startActivity(intent);
	}
	int s = 1;
	public void tolang(View v) throws IOException
	{
		String FILE = "ini";

		try 
		{

			FileOutputStream fos = openFileOutput(FILE, Context.MODE_PRIVATE);
			try 
			{
				fos.write(s);
				fos.close();
			} 
			catch (IOException e){
				e.printStackTrace();}
		} 
		catch (FileNotFoundException e) 
		{
		}

		Intent intent = new Intent(this,MainActivity.class);
		startActivity(intent);
	}
}
