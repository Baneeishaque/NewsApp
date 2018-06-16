package weservice;

import newsapp.ui.Login;
import newsapp.ui.Uploadnews;



public class CallerUpload  extends Thread 
{

	
	public CallSoapUpload cs;
	public String userid,title,category,content;
	
	public void run()
	{
		try
		{
			cs=new CallSoapUpload();	
			String resp=cs.Call(userid, title,category,content);
			Uploadnews.rslt=resp;
		}
		catch(Exception ex)
		{
			Uploadnews.rslt=ex.toString();	
		}

	
    }
}
