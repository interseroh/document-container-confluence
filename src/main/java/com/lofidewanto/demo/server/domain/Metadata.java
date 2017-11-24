package com.lofidewanto.demo.server.domain;

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
        "mediaType",
        "labels",
        "_expandable"
})
public class Metadata {

    @JsonProperty("mediaType")
    private String mediaType;
    @JsonProperty("labels")
    private Labels labels;
    @JsonProperty("_expandable")
    private Expandable expandable;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     *
     */
    public Metadata() {
    }

    /**
     *
     * @param labels
     * @param mediaType
     * @param expandable
     */
    public Metadata(String mediaType, Labels labels, Expandable expandable) {
        super();
        this.mediaType = mediaType;
        this.labels = labels;
        this.expandable = expandable;
    }

    @JsonProperty("mediaType")
    public String getMediaType() {
        return mediaType;
    }

    @JsonProperty("mediaType")
    public void setMediaType(String mediaType) {
        this.mediaType = mediaType;
    }

    public Metadata withMediaType(String mediaType) {
        this.mediaType = mediaType;
        return this;
    }

    @JsonProperty("labels")
    public Labels getLabels() {
        return labels;
    }

    @JsonProperty("labels")
    public void setLabels(Labels labels) {
        this.labels = labels;
    }

    public Metadata withLabels(Labels labels) {
        this.labels = labels;
        return this;
    }

    @JsonProperty("_expandable")
    public Expandable getExpandable() {
        return expandable;
    }

    @JsonProperty("_expandable")
    public void setExpandable(Expandable expandable) {
        this.expandable = expandable;
    }

    public Metadata withExpandable(Expandable expandable) {
        this.expandable = expandable;
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

    public Metadata withAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
        return this;
    }

}
