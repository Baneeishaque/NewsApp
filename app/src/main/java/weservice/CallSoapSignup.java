package weservice;

import newsapp.data.Globaldata;
import newsapp.ui.Connect;

import org.ksoap2.SoapEnvelope;
import org.ksoap2.serialization.PropertyInfo;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapSerializationEnvelope;
import org.ksoap2.transport.HttpTransportSE;

import android.widget.Toast;



public class CallSoapSignup 
{
	//Connect c=new Connect();
	public final String SOAP_ACTION ="http://tempuri.org/signup";
	 
	public  final String OPERATION_NAME = "signup";
	 
	public  final String WSDL_TARGET_NAMESPACE = "http://tempuri.org/";
	 
	//public  final String SOAP_ADDRESS = "http://10.0.2.2/administrator/WebService.asmx";
	//public  final String SOAP_ADDRESS = "http://192.168.173.1/newsApp/Service.asmx";
	public  final String SOAP_ADDRESS = "http://"+Globaldata.ip+"/newspedia/Service.asmx";
	
	public CallSoapSignup()
	{
		
	}
	
	public String Call(String userid, String password,String email, String name,String security, String answer)
	{
		
		SoapObject request = new SoapObject(WSDL_TARGET_NAMESPACE,OPERATION_NAME);
		PropertyInfo pi=new PropertyInfo();
		pi.setName("userid");
        pi.setValue(userid);
        pi.setType(String.class);
        request.addProperty(pi);

		pi=new PropertyInfo();
		pi.setName("password");
        pi.setValue(password);
        pi.setType(String.class);
        request.addProperty(pi);
        
		pi=new PropertyInfo();
		pi.setName("email");
        pi.setValue(email);
        pi.setType(String.class);
        request.addProperty(pi);

		pi=new PropertyInfo();
		pi.setName("name");
        pi.setValue(name);
        pi.setType(String.class);
        request.addProperty(pi);

		pi=new PropertyInfo();
		pi.setName("security");
        pi.setValue(security);
        pi.setType(String.class);
        request.addProperty(pi);

		pi=new PropertyInfo();
		pi.setName("answer");
        pi.setValue(answer);
        pi.setType(String.class);
        request.addProperty(pi);


		
		
		
				 
		SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(
		SoapEnvelope.VER11);
		envelope.dotNet = true;
				 
		envelope.setOutputSoapObject(request);
				 
		HttpTransportSE httpTransport = new HttpTransportSE(SOAP_ADDRESS);
		Object response=null;
		try
				 
		{
				 
				httpTransport.call(SOAP_ACTION, envelope);
				 
				response = envelope.getResponse();
				 
		
				 
		}
				 
		catch (Exception exception)
				 
		{
				 
			response=exception.toString()+" transport error";
				 
		}
		
		
		return response.toString();
	}

	

}

