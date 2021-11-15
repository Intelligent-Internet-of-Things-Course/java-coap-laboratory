package it.unimore.fum.iot.client;

import org.eclipse.californium.core.*;
import org.eclipse.californium.core.coap.Request;

/**
 * A simple CoAP Synchronous Client implemented using Californium Java Library
 * The client Observe a target resource for 10 Seconds and then cancel the request and ends the execution
 *
 * @author Marco Picone, Ph.D. - picone.m@gmail.com
 * @project coap-playground
 * @created 20/10/2020 - 21:54
 */
public class CoapObservingClientProcess {

    public static void main(String[] args) {

        String targetCoapResourceURL = "coap://127.0.0.1:5683/coffee";

        CoapClient client = new CoapClient(targetCoapResourceURL);

        Request request = Request.newGet().setURI(targetCoapResourceURL).setObserve();
        request.setConfirmable(true);

        CoapObserveRelation relation = client.observe(request, new CoapHandler() {

            public void onLoad(CoapResponse response) {
                String content = response.getResponseText();
                System.out.println(String.format("\nNotification Response Pretty Print: \n%s", Utils.prettyPrint(response)));
            }

            public void onError() {
                System.err.println("OBSERVING FAILED");
            }
        });

        // Observes the coap resource for 120 seconds then the observing relation is deleted
        try {
            Thread.sleep(120);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        relation.proactiveCancel();
    }

}
