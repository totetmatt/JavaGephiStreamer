package org.webcom.gephistream.entity;

import org.webcom.gephistream.action.StreamAction;
import org.webcom.gephistream.action.StreamAction.Action;

public class EdgeEntity extends GraphEntity {

    /*
     * Source & Target as String
     */

    public EdgeEntity(String source, String target) {
        this(source, target, true);
    }

    public EdgeEntity(String source, String target, Boolean directed) {
        this(source, target, true, 1);
    }

    public EdgeEntity(String source, String target, boolean directed,
            long weight) {
        this(source, target, directed, weight, source + "---" + target);
    }

    public EdgeEntity(String source, String target, boolean directed,
            long weight, String id) {
        this(source, target, directed, weight, id, id);
    }

    public EdgeEntity(String source, String target, boolean directed,
            long weight, String id, String label) {
        this(source, target, directed, weight, id, id, 0.5, 0.5, 0.5);
    }

    public EdgeEntity(String source, String target, boolean directed,
            long weight, String id, String label, double red, double green,
            double blue) {
        super(id);
        this.setSource(source);
        this.setTarget(target);
        this.setDirected(directed);
        this.setWeight(weight);
        this.setColor(red, green, blue);
    }

    public EdgeEntity(String id) {
        super(id);
    }

    /*
     * Source & Target as NodeEntity
     */
    public EdgeEntity(NodeEntity source, NodeEntity target) {
        this(source.getId(), target.getId(), true);
    }

    public EdgeEntity(NodeEntity source, NodeEntity target, Boolean directed) {
        this(source.getId(), target.getId(), true, 1);
    }

    public EdgeEntity(NodeEntity source, NodeEntity target, boolean directed,
            long weight) {
        this(source.getId(), target.getId(), directed, weight, source + "---"
                + target);
    }

    public EdgeEntity(NodeEntity source, NodeEntity target, boolean directed,
            long weight, String id) {
        this(source.getId(), target.getId(), directed, weight, id, id);
    }

    public EdgeEntity(NodeEntity source, NodeEntity target, boolean directed,
            long weight, String id, String label) {
        this(source.getId(), target.getId(), directed, weight, id, id, 0.5,
                0.5, 0.5);
    }

    public EdgeEntity(NodeEntity source, NodeEntity target, boolean directed,
            long weight, String id, String label, double red, double green,
            double blue) {
        super(id);
        this.setSource(source.getId());
        this.setTarget(target.getId());
        this.setDirected(directed);
        this.setWeight(weight);
        this.setColor(red, green, blue);
    }

    public void setSource(String source) {
        this.data.put("source", source);
    }

    public void setTarget(String target) {
        this.data.put("target", target);
    }

    public void setDirected(Boolean directed) {
        this.data.put("directed", directed);
    }

    public void setWeight(long weight) {
        this.data.put("weight", weight);
    }

    public StreamAction createAction(Action a) {
        return new StreamAction(a, this);
    }

}
