package it.unimore.fum.iot.client;

import org.eclipse.californium.core.CoapClient;
import org.eclipse.californium.core.CoapResponse;
import org.eclipse.californium.core.Utils;
import org.eclipse.californium.core.coap.CoAP.Code;
import org.eclipse.californium.core.coap.Request;
import org.eclipse.californium.elements.exception.ConnectorException;
import java.io.IOException;


/**
 * A simple CoAP Synchronous Client implemented using Californium Java Library
 * The simple client send a POST request to a target CoAP Resource with some custom request parameters
 * and Payload (if necessary)
 *
 * @author Marco Picone, Ph.D. - picone.m@gmail.com
 * @project coap-playground
 * @created 20/10/2020 - 09:19
 */
public class CoapPostClientProcess {

	private static final String COAP_ENDPOINT = "coap://127.0.0.1:5683/coffee";

	public static void main(String[] args) {
		
		//Initialize coapClient
		CoapClient coapClient = new CoapClient(COAP_ENDPOINT);

		//Request Class is a generic CoAP message: in this case we want a GET.
		//"Message ID", "Token" and other header's fields can be set 
		Request request = new Request(Code.POST);

		//Set Request as Confirmable
		request.setConfirmable(true);

		System.out.println(String.format("Request Pretty Print: \n%s", Utils.prettyPrint(request)));

		try {
			CoapResponse coapResp = coapClient.advanced(request);
			System.out.println(String.format("Response Pretty Print: \n%s", Utils.prettyPrint(coapResp)));
		} catch (ConnectorException | IOException e) {
			e.printStackTrace();
		}
	}
}