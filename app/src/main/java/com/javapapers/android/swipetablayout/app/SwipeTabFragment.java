package com.javapapers.android.swipetablayout.app;

import java.util.Vector;

import weservice.Callerview2;

import newsapp.ui.Lang2;
import newsapp.ui.R;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class SwipeTabFragment extends Fragment {

    private String tab,news;
    private int color;
    Vector ls;
	Vector lscon;
	Vector lscat;
	public static String rslt="";
	int flag=0;

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
        View view = inflater.inflate(R.layout.swipe_tab, container, false);
        //view.setBackgroundResource(color);
        //String[] ls={"hai"};
        ls=new Vector();
		lscon=new Vector();
		//lscat=new Vector();
		ls.add("test");
		lscon.add("test");
		//test();
        ArrayAdapter adapter=new ArrayAdapter<String>(getActivity().getBaseContext(),R.layout.activity_listview,ls);
		final ListView listview=(ListView)view.findViewById(R.id.list);
		
		listview.setAdapter(adapter);
		
		listview.setClickable(true);
		/*listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				Intent t=new Intent(view.getContext(),Lang2.class);
				t.putExtra("title", ls.get(position).toString());
				
				t.putExtra("content", lscon.get(position).toString());
				//t.putExtra("category", lscat.get(position).toString());
				startActivity(t);
				
			//	Toast.makeText(getApplicationContext(),lscon.get(position).toString(),Toast.LENGTH_LONG).show();					
				//Toast.makeText(getApplicationContext(),lscat.get(position).toString(),Toast.LENGTH_LONG).show();					
						}

			
			
		});*/

        return view;
    }
    
    private void test() {
	
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
 		    	  //Toast.makeText(getActivity().getApplicationContext(),rslt, Toast.LENGTH_SHORT).show();
 			      
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
 		    	//lscat.add(cat);
 		    	
 		    	  }
 		    	  
 		    	   
		       	}
		       					 		       
 		      
 		       	
		}
		catch(Exception ex)
 		{
			
 		        	
 		}
	
	}

}