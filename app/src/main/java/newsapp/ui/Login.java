package newsapp.ui;

import java.util.ArrayList;

import newsapp.data.Globaldata;

import org.apache.http.NameValuePair;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;

import weservice.CallerLogin;
import android.support.v7.app.ActionBarActivity;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Login extends ActionBarActivity {

	public static String rslt="";
	public static int f=0;
	private ProgressDialog dialog;
	private DefaultHttpClient httpclient;
	private HttpPost httppost;
	private ArrayList<NameValuePair> nameValuePairs;
	private String user;
	private String pass;
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_login);
		TextView warn=(TextView)findViewById(R.id.warn1);
		warn.setTextColor(Color.parseColor("RED"));
		warn.setText("");
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.login, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			Intent t=new Intent(this,Local.class);
			startActivity(t);
			return true;
		}
		
		return super.onOptionsItemSelected(item);
		
	}

	public void signup(View v)
	{
		Intent t = new Intent(this,Signup.class);
		startActivity(t);
	}

	public void login(View v)
	{
		TextView warn=(TextView)findViewById(R.id.warn1);
		EditText txt=(EditText)findViewById(R.id.username);
		user=txt.getText().toString();
		txt=(EditText)findViewById(R.id.password);
	 pass=txt.getText().toString();
		
	
		/*try 
		{ 
			
				rslt="START";	
				CallerLogin c=new CallerLogin();
				c.userid=user;
				c.password=pass;
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
				
 		       	if(rslt.equals("e"))
 		       	{
 		       		
 		       	Toast.makeText(getApplicationContext(),
						"invalid userid or password", Toast.LENGTH_LONG)
						.show();
 		       /*	Intent target = new Intent(this, Pchome.class);
 				startActivity(target); 	 		
 		        }
 		       else
		       	{
		       		if(rslt.equals("u"))
		       		{
		       			
		       		Intent target2 = new Intent(getApplicationContext(), Uploadnews.class);
					f=1;
		       		target2.putExtra("userid", user);
		       		startActivity(target2);
		       		
	 			
		       		}
		       		else
		       		{
		       			if(rslt.equals("a"))
		       			{
		       			Intent target2 = new Intent(this, adminlocal.class);
		   			
		       			startActivity(target2);
		       				
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
		
	
	
	
	//
	
	/*public void getresult()
	{
		try 
		{
				rslt="START";	
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
 	 								"Communication Error wait ", Toast.LENGTH_LONG)
 	 								.show();

 		        	}
 		        }
				Toast.makeText(getApplicationContext(),
						"invalid userid or password", Toast.LENGTH_LONG)
						.show();
 		       	if(rslt.equals("e"))
 		       	{
 		       		Toast.makeText(getApplicationContext(),
						"invalid userid or password", Toast.LENGTH_LONG)
						.show();
 		       		

 		       		
 	 			
 		        }
 		       	/*else
 		       	{
 		       		if(rslt.equals("u"))
 		       		{
 		       			
 		       		Intent target2 = new Intent(this, Uploadnews.class);
 					startActivity(target2);
 	 			
 		       		}
 		       		else
 		       		{
 		       			if(rslt.equals("a"))
 		       			{
 		       			Intent target2 = new Intent(this, Malayalam.class);
 		   			startActivity(target2);
 		       				
 		       			}
 		       			else
 		       			{
 		       				
 		       						Toast.makeText(getApplicationContext(),
 							"Communication Error resul in", Toast.LENGTH_LONG)
 							.show();
 		       					
 		       				
 		       			}
 		       		}

 		      
 		       	}
 		       
 		      
 		       	
		}
		catch(Exception ex)
 		{
			Toast.makeText(getApplicationContext(),
						"Communication Error thred", Toast.LENGTH_LONG)
						.show();
					Toast.makeText(getApplicationContext(),
							ex.getMessage(), Toast.LENGTH_LONG)
							.show();
 		        	
 		}
	} */ 
	
	dialog = ProgressDialog.show(this, "", 
            "Login ...", true);
	 new Thread(new Runnable() {
		    public void run() {
		    	sign();					      
		    }
		  }).start();	
}

void sign(){
	try{			
		 
		httpclient=new DefaultHttpClient();
		httppost= new HttpPost("http://"+Globaldata.ip+"/News/login.php"); // make sure the url is correct.
		//add your data
		nameValuePairs = new ArrayList<NameValuePair>(4);
		// Always use the same variable name for posting i.e the android side variable name and php side variable name should be similar, 
		nameValuePairs.add(new BasicNameValuePair("userid",user));  // $Edittext_value = $_POST['Edittext_value'];
		nameValuePairs.add(new BasicNameValuePair("password",pass));

		
		httppost.setEntity(new UrlEncodedFormEntity(nameValuePairs));
		//Execute HTTP Post Request
		// edited by James from coderzheaven.. from here....
		ResponseHandler<String> responseHandler = new BasicResponseHandler();
		final String response = httpclient.execute(httppost, responseHandler);
		System.out.println("Response : " + response); 
		
		runOnUiThread(new Runnable() {
		    public void run() {
		    	Toast.makeText(Login.this,"Response from PHP : " + response,Toast.LENGTH_LONG).show();
				dialog.dismiss();
		    }
		});
		
	if(response.equalsIgnoreCase("a")){
			runOnUiThread(new Runnable() {
			    public void run() {
			    	Toast.makeText(Login.this,"login sucsces", Toast.LENGTH_SHORT).show();
				    Intent targe = new Intent(Login.this,adminlocal.class);
			   		startActivity(targe);
			    }

			}
			
					
					);
			
			//startActivity(new Intent(Signup.this, Uploadnews.class));
		}else if(response.equalsIgnoreCase("u")){
			showAlert();	
	       		Intent target2 = new Intent(this, Uploadnews.class);
				startActivity(target2);
			
		}else{
				showAlert();
	}
	
	}catch(Exception e){
		dialog.dismiss();
		System.out.println("Exception : " + e.getMessage());
	}
}

public void showAlert(){
	Login.this.runOnUiThread(new Runnable() {
	    public void run() {
	    	AlertDialog.Builder builder = new AlertDialog.Builder(Login.this);
	    	builder.setTitle("Ligin Error");
	    	builder.setMessage("Try again...")  
	    	       .setCancelable(false)
	    	       .setPositiveButton("OK", new DialogInterface.OnClickListener() {
	    	           public void onClick(DialogInterface dialog, int id) {
	    	           }
	    	       });		    	       
	    	AlertDialog alert = builder.create();
	    	alert.show();		    	
	    }
	}); 
}
}
