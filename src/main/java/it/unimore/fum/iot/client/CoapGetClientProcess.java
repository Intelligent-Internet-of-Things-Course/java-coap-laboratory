package it.unimore.fum.iot.client;

import org.eclipse.californium.core.CoapClient;
import org.eclipse.californium.core.CoapResponse;
import org.eclipse.californium.core.Utils;
import org.eclipse.californium.core.coap.CoAP.Code;
import org.eclipse.californium.core.coap.MediaTypeRegistry;
import org.eclipse.californium.core.coap.OptionSet;
import org.eclipse.californium.core.coap.Request;
import org.eclipse.californium.elements.exception.ConnectorException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;


/**
 * A simple CoAP Synchronous Client implemented using Californium Java Library
 * The simple client send a GET request to a target CoAP Resource with some custom request parameters
 *
 * @author Marco Picone, Ph.D. - picone.m@gmail.com
 * @project coap-playground
 * @created 20/10/2020 - 09:19
 */
public class CoapGetClientProcess {

	private static final String COAP_ENDPOINT = "coap://127.0.0.1:5683/coffee";

	//private static final String COAP_ENDPOINT = "coap://127.0.0.1:5683/temperature";

	//private static final String COAP_ENDPOINT = "coap://127.0.0.1:5683/capsule";

	public static void main(String[] args) {
		
		//Initialize coapClient
		CoapClient coapClient = new CoapClient(COAP_ENDPOINT);

		//Request Class is a generic CoAP message: in this case we want a GET.
		//"Message ID", "Token" and other header's fields can be set 
		Request request = new Request(Code.GET);
		request.setOptions(new OptionSet().setAccept(MediaTypeRegistry.APPLICATION_JSON));

		//Set Request as Confirmable
		request.setConfirmable(true);

		//Synchronously send the GET message (blocking call)
		CoapResponse coapResp = null;

		try {
			coapResp = coapClient.advanced(request);
			//Pretty print for the received response
			System.out.println(String.format("Response Pretty Print: \n%s", Utils.prettyPrint(coapResp)));
		} catch (ConnectorException | IOException e) {
			e.printStackTrace();
		}
	}
}