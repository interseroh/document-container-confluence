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
        "id",
        "type",
        "status",
        "title",
        "metadata",
        "extensions",
        "_links",
        "_expandable"
})
public class Result {

    @JsonProperty("id")
    private String id;
    @JsonProperty("type")
    private String type;
    @JsonProperty("status")
    private String status;
    @JsonProperty("title")
    private String title;
    @JsonProperty("metadata")
    private Metadata metadata;
    @JsonProperty("extensions")
    private Extensions extensions;
    @JsonProperty("_links")
    private Links_ links;
    @JsonProperty("_expandable")
    private Expandable_ expandable;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     *
     */
    public Result() {
    }

    /**
     *
     * @param id
     * @param title
     * @param status
     * @param links
     * @param type
     * @param extensions
     * @param expandable
     * @param metadata
     */
    public Result(String id, String type, String status, String title, Metadata metadata, Extensions extensions, Links_ links, Expandable_ expandable) {
        super();
        this.id = id;
        this.type = type;
        this.status = status;
        this.title = title;
        this.metadata = metadata;
        this.extensions = extensions;
        this.links = links;
        this.expandable = expandable;
    }

    @JsonProperty("id")
    public String getId() {
        return id;
    }

    @JsonProperty("id")
    public void setId(String id) {
        this.id = id;
    }

    public Result withId(String id) {
        this.id = id;
        return this;
    }

    @JsonProperty("type")
    public String getType() {
        return type;
    }

    @JsonProperty("type")
    public void setType(String type) {
        this.type = type;
    }

    public Result withType(String type) {
        this.type = type;
        return this;
    }

    @JsonProperty("status")
    public String getStatus() {
        return status;
    }

    @JsonProperty("status")
    public void setStatus(String status) {
        this.status = status;
    }

    public Result withStatus(String status) {
        this.status = status;
        return this;
    }

    @JsonProperty("title")
    public String getTitle() {
        return title;
    }

    @JsonProperty("title")
    public void setTitle(String title) {
        this.title = title;
    }

    public Result withTitle(String title) {
        this.title = title;
        return this;
    }

    @JsonProperty("metadata")
    public Metadata getMetadata() {
        return metadata;
    }

    @JsonProperty("metadata")
    public void setMetadata(Metadata metadata) {
        this.metadata = metadata;
    }

    public Result withMetadata(Metadata metadata) {
        this.metadata = metadata;
        return this;
    }

    @JsonProperty("extensions")
    public Extensions getExtensions() {
        return extensions;
    }

    @JsonProperty("extensions")
    public void setExtensions(Extensions extensions) {
        this.extensions = extensions;
    }

    public Result withExtensions(Extensions extensions) {
        this.extensions = extensions;
        return this;
    }

    @JsonProperty("_links")
    public Links_ getLinks() {
        return links;
    }

    @JsonProperty("_links")
    public void setLinks(Links_ links) {
        this.links = links;
    }

    public Result withLinks(Links_ links) {
        this.links = links;
        return this;
    }

    @JsonProperty("_expandable")
    public Expandable_ getExpandable() {
        return expandable;
    }

    @JsonProperty("_expandable")
    public void setExpandable(Expandable_ expandable) {
        this.expandable = expandable;
    }

    public Result withExpandable(Expandable_ expandable) {
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

    public Result withAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
        return this;
    }

}
