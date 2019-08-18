package newsapp.ui;

import java.util.Vector;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class Android extends Fragment {
	private Vector ls;
	private Vector lscon;
	public static String rslt="";

	@Override
	    public View onCreateView(LayoutInflater inflater, ViewGroup container,
	            Bundle savedInstanceState) {
	 
	        //View android = inflater.inflate(R.layout.android_frag, container, false);
		View android = inflater.inflate(R.layout.swipe_tab, container, false);
	        //((TextView)android.findViewById(R.id.textView)).setText("Android");
		 ls=new Vector();
			lscon=new Vector();
			//lscat=new Vector();
			//ls.add("test");
			//lscon.add("test");
			test();
	        ArrayAdapter adapter=new ArrayAdapter<String>(getActivity().getBaseContext(),R.layout.activity_listview,ls);
			final ListView listview=(ListView)android.findViewById(R.id.list);
			
			listview.setAdapter(adapter);
			
			listview.setClickable(true);
	        return android;
}
	
	private void test() {
		
		try 
		{
			//Toast.makeText(getActivity().getApplicationContext(),MainActivity.category, Toast.LENGTH_SHORT).show();
		      
			
				rslt="START";	
				Callerview2 c=new Callerview2();
				c.cate="Kerala";
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
				Toast.makeText(getActivity().getApplicationContext(),rslt, Toast.LENGTH_SHORT).show();
			      
				
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
