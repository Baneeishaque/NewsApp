package weservice;

import newsapp.ui.Local;
import newsapp.ui.Login;
import newsapp.ui.Uploadnews;



public class Callerview  extends Thread 
{

	
	public CallSoapview cs;
	
	public void run()
	{
		try
		{
			cs=new CallSoapview();	
			String resp=cs.Call();
			Local.rslt=resp;
		}
		catch(Exception ex)
		{
			Local.rslt=ex.toString();	
		}

	
    }
}
