package org.webcom.gephistream.entity;

import java.math.BigDecimal;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

public abstract class GraphEntity {
    private ObjectMapper mapper = new ObjectMapper();

    private ObjectNode node = mapper.createObjectNode();
    protected ObjectNode data = mapper.createObjectNode();

    public GraphEntity(String id) {
        node.putPOJO(id, data);
    }

    public String getId() {
        return node.fields().next().getKey();
    }

    @Override
    public String toString() {
        return node.toString();
    }

    public ObjectNode toJson() {
        return node;
    }

    public void setLabel(String label) {
        data.put("label", label);
    }

    public void setColor(double r, double g, double b) {
        data.put("g", g);
        data.put("b", b);
        data.put("r", r);
    }

    public void setColorHexa(double r, double g, double b) {
        data.put("g", g / (double) 0xFF);
        data.put("b", b / (double) 0xFF);
        data.put("r", r / (double) 0xFF);
    }

    public void addParam(String key, String value) {
        data.put(key, value);
    }

    public void addParam(String key, BigDecimal value) {
        data.put(key, value);
    }

    public void addParam(String key, Boolean value) {
        data.put(key, value);
    }

    public void addParam(String key, byte[] value) {
        data.put(key, value);
    }

    public void addParam(String key, Double value) {
        data.put(key, value);
    }

    public void addParam(String key, Float value) {
        data.put(key, value);
    }

    public void addParam(String key, Integer value) {
        data.put(key, value);
    }

    public void addParam(String key, Long value) {
        data.put(key, value);
    }

    public void addParam(String key, Short value) {
        data.put(key, value);
    }

}
