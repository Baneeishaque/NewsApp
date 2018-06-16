package weservice;

import newsapp.ui.Login;



public class CallerLogin  extends Thread 
{

	
	public CallSoapLogin cs;
	public String userid,password;
	
	public void run()
	{
		try
		{
			cs=new CallSoapLogin();	
			String resp=cs.Call(userid,password);
			Login.rslt=resp;
		}
		catch(Exception ex)
		{
			Login.rslt=ex.toString();	
		}

	
    }
}
