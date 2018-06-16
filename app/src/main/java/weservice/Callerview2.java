package weservice;

import com.javapapers.android.swipetablayout.app.SwipeTabFragment;





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
			SwipeTabFragment.rslt=resp;
		}
		catch(Exception ex)
		{
			SwipeTabFragment.rslt=ex.toString();	
		}

	
    }
}
