package org.webcom.gephistream;

public class SimpleGephiStreamer extends GephiStreamer {

    public SimpleGephiStreamer() {
        super();
    }
    public SimpleGephiStreamer(String workspace) {
        targetedWorkspace = workspace;
    }
    public SimpleGephiStreamer(String host, int port, String targetedWorkspace) {
        super(host, port, targetedWorkspace);
    }

}
