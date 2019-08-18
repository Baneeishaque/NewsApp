package newsapp.ui;





public class Callerview2  extends Thread 
{

	public String cate;
	public CallSoapview2 cs;
	
	public void run()
	{
		try
		{
			cs=new CallSoapview2();	
			String resp=cs.Call(cate);
			Android.rslt=resp;
		}
		catch(Exception ex)
		{
			Android.rslt=ex.toString();	
		}

	
    }
}
