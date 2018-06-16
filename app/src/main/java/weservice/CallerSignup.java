package weservice;

import android.widget.Toast;
import newsapp.ui.Login;
import newsapp.ui.Signup;



public class CallerSignup  extends Thread 
{

	
	public CallSoapSignup cs;
	public String userid,password,email,name,security,answer;
	
	public void run()
	{
		try
		{
			cs=new CallSoapSignup();	
			String resp=cs.Call(userid,password,email,name,security,answer);
			Signup.rslt=resp;
		}
		catch(Exception ex)
		{
			Signup.rslt=ex.toString();	
		}

	
    }
}
