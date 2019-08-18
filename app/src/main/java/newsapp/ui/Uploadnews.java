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
import weservice.CallerUpload;
import android.R.array;
import android.support.v7.app.ActionBarActivity;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class Uploadnews extends ActionBarActivity {

	public static String rslt="";
	private ProgressDialog dialog;
	private DefaultHttpClient httpclient;
	private HttpPost httppost;
	private ArrayList<NameValuePair> nameValuePairs;
	private String title;
	private String content;
	private String category;
	private String userid;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_uploadnews);
		
		String[] ls={"Kerala","National","International","Sports","Technology","Education","Entertainment","Travel","Movie","Health"};
		Spinner sp=(Spinner)findViewById(R.id.spin);
		ArrayAdapter adapter=new ArrayAdapter(this,android.R.layout.simple_spinner_item,ls);
		sp.setAdapter(adapter);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.uploadnews, menu);
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
	
	public void updatenews(View v)
	{

		EditText txt=(EditText)findViewById(R.id.txtip);
		title=txt.getText().toString();
	
		
		txt=(EditText)findViewById(R.id.content);
		content=txt.getText().toString();
	
		
		Spinner sp=(Spinner)findViewById(R.id.spin);
		category=sp.getSelectedItem().toString();
		
		

		userid="";
		Bundle extras =getIntent().getExtras();
		if((content.isEmpty())&&(title.isEmpty())){
			
			Toast.makeText(getApplicationContext(),
						"Check input", Toast.LENGTH_SHORT)
						.show();
		}else{
			
		
		if(extras!=null){
			userid=extras.getString("userid");
		}
		/*try 
		{
		
				rslt="START";	
				CallerUpload c=new CallerUpload();
				c.userid=values;
				c.content=content;
				c.title=title;
				c.category=category;
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
			
 		       	if(rslt.equals("u1")||rslt.equals("u2"))
 		       	{
 		       		
 		       	Toast.makeText(getApplicationContext(),
						"News uploaded. waiting for verification", Toast.LENGTH_LONG)
						.show();
 		       Intent target2 = new Intent(this, Lang.class);
	   			startActivity(target2);
 		       
 	 			
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
 		        	
 		}*/

		dialog = ProgressDialog.show(this, "", 
                "Uploading news ...", true);
		 new Thread(new Runnable() {
			    public void run() {
			    	sign();					      
			    }
			  }).start();	
		 }
	}
	void sign(){
		try{			
			 
			httpclient=new DefaultHttpClient();
			httppost= new HttpPost("http://"+Globaldata.ip+"/News/insert_news.php"); // make sure the url is correct.
			//add your data
			nameValuePairs = new ArrayList<NameValuePair>(4);
			// Always use the same variable name for posting i.e the android side variable name and php side variable name should be similar, 
			nameValuePairs.add(new BasicNameValuePair("userid",userid));  // $Edittext_value = $_POST['Edittext_value'];
			nameValuePairs.add(new BasicNameValuePair("content",content));
			nameValuePairs.add(new BasicNameValuePair("category",category));  // $Edittext_value = $_POST['Edittext_value'];
			nameValuePairs.add(new BasicNameValuePair("title",title)); 
			
			httppost.setEntity(new UrlEncodedFormEntity(nameValuePairs));
			//Execute HTTP Post Request
			// edited by James from coderzheaven.. from here....
			ResponseHandler<String> responseHandler = new BasicResponseHandler();
			final String response = httpclient.execute(httppost, responseHandler);
			System.out.println("Response : " + response); 
			
			runOnUiThread(new Runnable() {
			    public void run() {
			    	Toast.makeText(Uploadnews.this,"Response from PHP : " + response,Toast.LENGTH_LONG).show();
					dialog.dismiss();
			    }
			});
			
		if(response.equalsIgnoreCase("Inserted")){
				runOnUiThread(new Runnable() {
				    public void run() {
				    	Toast.makeText(Uploadnews.this,"Success,Waiting verification", Toast.LENGTH_SHORT).show();
				    }
				});
				
				//startActivity(new Intent(Signup.this, Uploadnews.class));
			}else{
				showAlert();				
			}
			
		}catch(Exception e){
			dialog.dismiss();
			System.out.println("Exception : " + e.getMessage());
		}
	}
	public void showAlert(){
		Uploadnews.this.runOnUiThread(new Runnable() {
		    public void run() {
		    	AlertDialog.Builder builder = new AlertDialog.Builder(Uploadnews.this);
		    	builder.setTitle("Upload Error");
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
