package controlles;

import java.io.IOException;

import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.junit.Test;

public class AgendaTest {
	
	@Test
	public void levantarServidor(){
		
		CloseableHttpClient httpCliente =  HttpClients.createDefault();
		HttpPost post = new HttpPost("http://localhost:8080/sduc-educacao/agenda");
		try {
			CloseableHttpResponse response = httpCliente.execute(post);
			
			System.out.println(response.getStatusLine());
			
		} catch (ClientProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
