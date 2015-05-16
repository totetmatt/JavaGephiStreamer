package org.webcom.gephistream.entity;

import org.webcom.gephistream.action.StreamAction;
import org.webcom.gephistream.action.StreamAction.Action;

public class NodeEntity extends GraphEntity {

    public NodeEntity(String id) {
        this(id, id);
    }

    public NodeEntity(String id, String label) {
        this(id, label, 1);
    }

    public NodeEntity(String id, String label, long size) {
        this(id, label, 1, 0, 0, 0);
    }

    public NodeEntity(String id, String label, long size, double x, double y,
            double z) {
        this(id, label, 1, 0, 0, 0, 0.5, 0.5, 0.5);
    }

    public NodeEntity(String id, String label, long size, double x, double y,
            double z, double red, double green, double blue) {
        super(id);

        this.setLabel(label);
        this.setSize(size);

        this.setCoordinates(x, y, z);
        this.setColor(red, green, blue);

    }

    public void setSize(long size) {
        data.put("size", size);
    }

    public void setCoordinates(double x, double y, double z) {
        data.put("x", x);
        data.put("y", y);
        data.put("z", z);
    }

    public StreamAction createAction(Action a) {
        return new StreamAction(a, this);
    }

}
