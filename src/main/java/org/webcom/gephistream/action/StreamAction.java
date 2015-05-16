package org.webcom.gephistream.action;

import org.webcom.gephistream.entity.GraphEntity;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

/**
 * 
 * @author Totetmatt
 *
 */
public class StreamAction {

    /**
     * 
     * Possible Action
     *
     */
    public enum Action {
        ADD_NODE("an"), 
        CHANGE_NODE("cn"), 
        DELETE_NODE("dn"), 
        ADD_EDGE("ae"), 
        CHANGE_EDGE("ce"), 
        DELETE_EDGE("de");

        private String text;

        Action(String text) {
            this.text = text;
        }

        public String getText() {
            return this.text;
        }

        @Override
        public String toString() {
            return this.text;
        }
    }

    /**
     * Json Part
     */
    private ObjectMapper mapper = new ObjectMapper();
    private ObjectNode entities = mapper.createObjectNode();
    private ObjectNode action = mapper.createObjectNode();

    public StreamAction(Action a, GraphEntity e) {
        action.putPOJO(a.toString(), entities);
        if (e != null) {
            entities.setAll(e.toJson());
        }
    }

    public StreamAction(Action a) {
        this(a, null);
    }

    public void addEntity(GraphEntity e) {
        entities.setAll(e.toJson());
    }

    @Override
    public String toString() {
        return action.toString();
    }

    public ObjectNode getJson() {
        return action;
    }

    public void clear() {
        entities.removeAll();
    }
}
