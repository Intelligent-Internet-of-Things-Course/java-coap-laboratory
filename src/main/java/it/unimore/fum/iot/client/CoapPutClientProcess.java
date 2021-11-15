package it.unimore.fum.iot.client;

import com.google.gson.Gson;
import it.unimore.fum.iot.request.MakeCoffeeRequestDescriptor;
import org.eclipse.californium.core.CoapClient;
import org.eclipse.californium.core.CoapResponse;
import org.eclipse.californium.core.Utils;
import org.eclipse.californium.core.coap.CoAP.Code;
import org.eclipse.californium.core.coap.Request;
import org.eclipse.californium.elements.exception.ConnectorException;
import java.io.IOException;


/**
 * A simple CoAP Synchronous Client implemented using Californium Java Library
 * The simple client send a PUT request to a target CoAP Resource with some custom request parameters
 * and payload
 *
 * @author Marco Picone, Ph.D. - picone.m@gmail.com
 * @project coap-playground
 * @created 20/10/2020 - 09:19
 */
public class CoapPutClientProcess {

	private static final String COAP_ENDPOINT = "coap://127.0.0.1:5683/coffee";

	public static void main(String[] args) {

		try {

			//Initialize coapClient
			CoapClient coapClient = new CoapClient(COAP_ENDPOINT);

			Request request = new Request(Code.PUT);

			Gson gson = new Gson();

			//Set PUT request's payload
			String requestPayload = gson.toJson(new MakeCoffeeRequestDescriptor(MakeCoffeeRequestDescriptor.COFFEE_TYPE_LONG));
			request.setPayload(requestPayload);

			//Set Request as Confirmable
			request.setConfirmable(true);

			System.out.println(String.format("Request Pretty Print: \n%s", Utils.prettyPrint(request)));

			CoapResponse coapResp = coapClient.advanced(request);

			System.out.println(String.format("Response Pretty Print: \n%s", Utils.prettyPrint(coapResp)));

		} catch (ConnectorException | IOException e) {
			e.printStackTrace();
		}
	}
}