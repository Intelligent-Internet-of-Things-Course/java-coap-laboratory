package it.unimore.fum.iot.resource;

import com.google.gson.Gson;
import it.unimore.fum.iot.model.CapsulePresenceSensorDescriptor;
import org.eclipse.californium.core.CoapResource;
import org.eclipse.californium.core.coap.CoAP.ResponseCode;
import org.eclipse.californium.core.coap.MediaTypeRegistry;
import org.eclipse.californium.core.server.resources.CoapExchange;

/**
 *
 * @author Marco Picone, Ph.D. - picone.m@gmail.com
 * @project coap-playground
 * @created 20/10/2020 - 21:54
 */
public class CapsulePresenceSensorResource extends CoapResource {

	private static final String OBJECT_TITLE = "CapsulePresenceSensor";

	private Gson gson;

	private CapsulePresenceSensorDescriptor capsulePresenceSensorDescriptor;

	public CapsulePresenceSensorResource(String name) {
		super(name);
		init();
	}

	private void init(){
		getAttributes().setTitle(OBJECT_TITLE);
        this.gson = new Gson();
		this.capsulePresenceSensorDescriptor = new CapsulePresenceSensorDescriptor();
	}

	@Override
	public void handleGET(CoapExchange exchange) {
		try{
			this.capsulePresenceSensorDescriptor.checkCapsulePresence();
			String responseBody = this.gson.toJson(this.capsulePresenceSensorDescriptor);
			exchange.respond(ResponseCode.CONTENT, responseBody, MediaTypeRegistry.APPLICATION_JSON);
		}catch (Exception e){
			exchange.respond(ResponseCode.INTERNAL_SERVER_ERROR);
		}
	}
}
