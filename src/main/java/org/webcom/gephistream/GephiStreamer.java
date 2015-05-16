package org.webcom.gephistream;

import java.net.URI;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.UriBuilder;

import org.webcom.gephistream.action.StreamAction;

public abstract class GephiStreamer {

	protected String targetedWorkspace = "workspace0";
	protected String host = "localhost";
	protected int port = 8080;

	private URI endpoint;
	private Client clientEndpoint;

	@Override
	public String toString() {
		return endpoint.toASCIIString();
	}

	public GephiStreamer() {
		this("localhost", 8080, "workspace0");
	}

	public GephiStreamer(String host, int port, String targetedWorkspace) {
		this.host = host;
		this.port = port;
		this.targetedWorkspace = targetedWorkspace;

      endpoint = UriBuilder.fromPath(targetedWorkspace)
                              .host(host)
                              .scheme("http").port(8080)
                              .queryParam("operation", "updateGraph")
                              .build();

		clientEndpoint = ClientBuilder.newClient();
	}

	public void sendAction(String a) {
		clientEndpoint.target(endpoint).request().post(Entity.json(a));
	}

	public void sendAction(StreamAction a) {
		sendAction(a.toString());
	}

}
