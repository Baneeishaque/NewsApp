package newsapp.ui;
import org.ksoap2.SoapEnvelope;
import org.ksoap2.serialization.PropertyInfo;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapSerializationEnvelope;
import org.ksoap2.transport.HttpTransportSE;






public class CallSoapview2 
{
	//Connect c=new Connect();
	public final String SOAP_ACTION ="http://tempuri.org/view_news";
	 
	public  final String OPERATION_NAME = "view_news";
	 
	public  final String WSDL_TARGET_NAMESPACE = "http://tempuri.org/";
	 
	//public  final String SOAP_ADDRESS = "http://10.0.2.2/administrator/WebService.asmx";
	//public  final String SOAP_ADDRESS = "http://192.168.173.1/newsApp/Service.asmx";
	public  final String SOAP_ADDRESS = "http://"+Globaldata.ip+"/newspedia/Service.asmx";
	
	public CallSoapview2()
	{
		
	}
	
	public String Call(String cate)
	{
		
		SoapObject request = new SoapObject(WSDL_TARGET_NAMESPACE,OPERATION_NAME);
		PropertyInfo pi=new PropertyInfo();
		pi.setName("cate");
        pi.setValue(cate);
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

