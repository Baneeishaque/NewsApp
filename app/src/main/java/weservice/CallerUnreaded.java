package weservice;

import newsapp.ui.Local;
import newsapp.ui.Login;
import newsapp.ui.Uploadnews;
import newsapp.ui.adminlocal;



public class CallerUnreaded  extends Thread 
{

	
	public CallSoapUnreaded cs;
	
	public void run()
	{
		try
		{
			cs=new CallSoapUnreaded();	
			String resp=cs.Call();
			adminlocal.rslt=resp;
		}
		catch(Exception ex)
		{
			adminlocal.rslt=ex.toString();	
		}

	
    }
}
