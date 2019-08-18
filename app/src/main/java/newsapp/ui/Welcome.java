package newsapp.ui;

import java.io.FileInputStream;

import java.io.FileNotFoundException;
import java.io.IOException;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.ProgressBar;


public class Welcome extends ActionBarActivity {

	ProgressBar Pb;
	int a[] = { 20, 40, 60, 80, 100 }, i;
	View v;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        
        Pb = (ProgressBar) findViewById(R.id.pblaunch);
		Pb.setProgress(0);
		
		
		new Thread(new Runnable() 
		{ 
			public void run() 
			{ 
				try 
				{
		  
					for(i=0;i<5;i++) 
					{
		  
						Thread.sleep(500);
		  
						Pb.setProgress(a[i]); 
					} 
					gotonext(v);
			
				} 
				catch(InterruptedException e) 
				{
					e.printStackTrace(); 
				} 
			}

		
		}).start();
    }
    

    
	public void test(View v) {
		Intent target = new Intent(this,Lang.class);
		startActivity(target);
		
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
    
    String FILENAME = "ini";
	int s;
    
	public void gotonext(View v)
    {
    	try 
		{
			FileInputStream fos = openFileInput(FILENAME);
			try 
			{
				s = fos.read();
				fos.close();
			} 
			catch (IOException e) 
			{
				e.printStackTrace();
			}

		} 
		catch (FileNotFoundException e) 
		{
			e.printStackTrace();
		}
		if (s != 1) 
		{
			Intent target = new Intent(this,Licance.class);
			startActivity(target);
		} 
		else 
		{
			Intent target = new Intent(this,MainActivity.class);
			startActivity(target);
		}
    }
}
