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
        "fileSize",
        "comment"
})
public class Extensions {

    @JsonProperty("mediaType")
    private String mediaType;
    @JsonProperty("fileSize")
    private int fileSize;
    @JsonProperty("comment")
    private String comment;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     *
     */
    public Extensions() {
    }

    /**
     *
     * @param fileSize
     * @param comment
     * @param mediaType
     */
    public Extensions(String mediaType, int fileSize, String comment) {
        super();
        this.mediaType = mediaType;
        this.fileSize = fileSize;
        this.comment = comment;
    }

    @JsonProperty("mediaType")
    public String getMediaType() {
        return mediaType;
    }

    @JsonProperty("mediaType")
    public void setMediaType(String mediaType) {
        this.mediaType = mediaType;
    }

    public Extensions withMediaType(String mediaType) {
        this.mediaType = mediaType;
        return this;
    }

    @JsonProperty("fileSize")
    public int getFileSize() {
        return fileSize;
    }

    @JsonProperty("fileSize")
    public void setFileSize(int fileSize) {
        this.fileSize = fileSize;
    }

    public Extensions withFileSize(int fileSize) {
        this.fileSize = fileSize;
        return this;
    }

    @JsonProperty("comment")
    public String getComment() {
        return comment;
    }

    @JsonProperty("comment")
    public void setComment(String comment) {
        this.comment = comment;
    }

    public Extensions withComment(String comment) {
        this.comment = comment;
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

    public Extensions withAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
        return this;
    }

}
