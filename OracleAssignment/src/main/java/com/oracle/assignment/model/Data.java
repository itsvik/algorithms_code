package com.oracle.assignment.model;

import com.fasterxml.jackson.annotation.*;

import java.util.HashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Data {

    @JsonProperty("query")
    private String query;
    @JsonProperty("position")
    private Position position;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    public String getQuery() {
        return query;
    }

    public Data setQuery(String query) {
        this.query = query;
        return this;
    }

    public Position getPosition() {
        return position;
    }

    public Data setPosition(Position position) {
        this.position = position;
        return this;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }
    private class Position {
    }
}