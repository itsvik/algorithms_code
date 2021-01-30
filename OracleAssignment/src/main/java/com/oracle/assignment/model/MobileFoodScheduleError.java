package com.oracle.assignment.model;

import com.fasterxml.jackson.annotation.*;

import java.util.HashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class MobileFoodScheduleError {

    @JsonProperty("code")
    private String code;
    @JsonProperty("error")
    private Boolean error;
    @JsonProperty("message")
    private String message;
    @JsonProperty("data")
    private Data data;

    public String getCode() {
        return code;
    }

    public MobileFoodScheduleError setCode(String code) {
        this.code = code;
        return this;
    }

    public Boolean getError() {
        return error;
    }

    public MobileFoodScheduleError setError(Boolean error) {
        this.error = error;
        return this;
    }

    public String getMessage() {
        return message;
    }

    public MobileFoodScheduleError setMessage(String message) {
        this.message = message;
        return this;
    }

    public Data getData() {
        return data;
    }

    public MobileFoodScheduleError setData(Data data) {
        this.data = data;
        return this;
    }

    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();
    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}