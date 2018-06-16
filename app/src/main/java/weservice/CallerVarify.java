package weservice;

import android.widget.Toast;
import newsapp.ui.AdminNews;
import newsapp.ui.Login;
import newsapp.ui.Signup;



public class CallerVarify  extends Thread 
{

	
	public CallSoapVarify cs;
	public String newsid;
	
	public void run()
	{
		try
		{
			cs=new CallSoapVarify();	
			String resp=cs.Call(newsid);
			AdminNews.rslt=resp;
		}
		catch(Exception ex)
		{
			AdminNews.rslt=ex.toString();	
		}

	
    }
}
