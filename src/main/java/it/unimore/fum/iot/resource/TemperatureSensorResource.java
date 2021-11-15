package it.unimore.fum.iot.resource;

import com.google.gson.Gson;
import it.unimore.fum.iot.model.TemperatureSensorDescriptor;
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
public class TemperatureSensorResource extends CoapResource {

	private static final String OBJECT_TITLE = "TemperatureSensor";

	private Gson gson;

	private TemperatureSensorDescriptor temperatureSensorDescriptor;

	public TemperatureSensorResource(String name) {
		super(name);
		init();
	}

	private void init(){
		getAttributes().setTitle(OBJECT_TITLE);
        this.gson = new Gson();
		this.temperatureSensorDescriptor = new TemperatureSensorDescriptor();
	}

	@Override
	public void handleGET(CoapExchange exchange) {
		try{
			this.temperatureSensorDescriptor.measureTemperatureValue();
			String responseBody = this.gson.toJson(this.temperatureSensorDescriptor);
			exchange.respond(ResponseCode.CONTENT, responseBody, MediaTypeRegistry.APPLICATION_JSON);
		}catch (Exception e){
			exchange.respond(ResponseCode.INTERNAL_SERVER_ERROR);
		}
	}
}
