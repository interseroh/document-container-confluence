package com.lofidewanto.demo.server.domain.attachments;

import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "currentuser",
        "properties"
})
public class Expandable {

    @JsonProperty("currentuser")
    private String currentuser;
    @JsonProperty("properties")
    private String properties;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     *
     */
    public Expandable() {
    }

    /**
     *
     * @param currentuser
     * @param properties
     */
    public Expandable(String currentuser, String properties) {
        super();
        this.currentuser = currentuser;
        this.properties = properties;
    }

    @JsonProperty("currentuser")
    public String getCurrentuser() {
        return currentuser;
    }

    @JsonProperty("currentuser")
    public void setCurrentuser(String currentuser) {
        this.currentuser = currentuser;
    }

    public Expandable withCurrentuser(String currentuser) {
        this.currentuser = currentuser;
        return this;
    }

    @JsonProperty("properties")
    public String getProperties() {
        return properties;
    }

    @JsonProperty("properties")
    public void setProperties(String properties) {
        this.properties = properties;
    }

    public Expandable withProperties(String properties) {
        this.properties = properties;
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

    public Expandable withAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
        return this;
    }

}
