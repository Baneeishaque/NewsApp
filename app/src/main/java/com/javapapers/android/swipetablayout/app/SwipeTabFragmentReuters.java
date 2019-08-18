package com.javapapers.android.swipetablayout.app;

import java.util.List;
import java.util.Vector;

import weservice.Callerview2;
import newsapp.ui.Lang2;
import newsapp.ui.ListListener;
import newsapp.ui.ListListener2;
import newsapp.ui.ListListener3;
import newsapp.ui.R;
import newsapp.ui.RssChannelActivity;
import newsapp.ui.RssItem;
import newsapp.ui.RssReader;
import newsapp.ui.RssChannelActivity.GetRSSDataTask;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class SwipeTabFragmentReuters extends Fragment {

    private String tab,news;
    private int color;
    Vector ls;
	Vector lscon;
	Vector lscat;
	public static String rslt="";
	int flag=0;
	
	
	ListView itcItems;
	String rssUrl;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle bundle = getArguments();
        tab = bundle.getString("tab");
        color = bundle.getInt("color");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_rss_channel2, null);
        //view.setBackgroundResource(color);
        /*String[] ls={"hai"};*/
        ls=new Vector();
		lscon=new Vector();
		lscat=new Vector();
		ls.add("test");
		itcItems=(ListView)view.findViewById(R.id.rssChannelListView);
		//Toast.makeText(view.getContext(),Reuters.category,Toast.LENGTH_LONG).show();					
		
		 if(Reuters.category.equals("Arts"))
	        {
	        
	        	rssUrl = "http://feeds.reuters.com/news/artsculture?format=xml";
	        }
	        else
	        {
	        	  if(Reuters.category.equals("Technology"))
	              {
	        		  rssUrl = "http://feeds.reuters.com/reuters/technologyNews?format=xml";
	        		  
	              }
	        	  else
	        	  {
	        		  if(Reuters.category.equals("Sports"))
	                  {
	        	        	rssUrl = "http://feeds.reuters.com/reuters/sportsNews?format=xml";
	        	        	
	                  }
	        		  else
	        		  {
	        			 	rssUrl = "http://feeds.reuters.com/news/artsculture?format=xml";
	        		  }
	        	  }
	        }
	       
		//test();
        //ArrayAdapter adapter=new ArrayAdapter<String>(getActivity().getBaseContext(),R.layout.activity_listview,ls);
		// ArrayAdapter<RssItem> adapter = new ArrayAdapter<RssItem>(getActivity().getBaseContext(),android.R.layout.simple_list_item_1, ls);
         
        //itcItems.setAdapter(adapter);
		
		/*listview.setClickable(true);
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
    	// Set reference to this activity
        // Get a ListView from the RSS Channel view
        /*itcItems = (ListView)view.findViewById(R.id.list);*/
                     
		
        GetRSSDataTask task = new GetRSSDataTask();
         
        // Start process RSS task
        task.execute(rssUrl);

        return view;
    }
    
    
    
    public class GetRSSDataTask extends AsyncTask<String, Void, List<RssItem> > {
        
        
        @Override
        protected void onPostExecute(List<RssItem> result) {
             
        	Reuters.item.setVisible(false);
        	  // Create a list adapter
            ArrayAdapter<RssItem> adapter = new ArrayAdapter<RssItem>(getActivity().getBaseContext(),android.R.layout.simple_list_item_1, result);
            // Set list adapter for the ListView
            itcItems.setAdapter(adapter);
                         
            // Set list view item click listener
            //itcItems.setOnItemClickListener(new ListListener(result, local));
            // Set list view item click listener
            itcItems.setOnItemClickListener(new ListListener3(result,getActivity() ));
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
    private void test() {
		// TODO Auto-generated method stub
		try 
		{
			Toast.makeText(getActivity().getApplicationContext(),MainActivity.category, Toast.LENGTH_SHORT).show();
		      
			
				rslt="START";	
				Callerview2 c=new Callerview2();
				c.cate=MainActivity.category;
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
			
 		        	
 		}
	}

}