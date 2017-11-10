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
        "container",
        "operations",
        "children",
        "history",
        "ancestors",
        "body",
        "version",
        "descendants",
        "space"
})
public class Expandable_ {

    @JsonProperty("container")
    private String container;
    @JsonProperty("operations")
    private String operations;
    @JsonProperty("children")
    private String children;
    @JsonProperty("history")
    private String history;
    @JsonProperty("ancestors")
    private String ancestors;
    @JsonProperty("body")
    private String body;
    @JsonProperty("version")
    private String version;
    @JsonProperty("descendants")
    private String descendants;
    @JsonProperty("space")
    private String space;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     *
     */
    public Expandable_() {
    }

    /**
     *
     * @param history
     * @param body
     * @param container
     * @param ancestors
     * @param children
     * @param descendants
     * @param operations
     * @param space
     * @param version
     */
    public Expandable_(String container, String operations, String children, String history, String ancestors, String body, String version, String descendants, String space) {
        super();
        this.container = container;
        this.operations = operations;
        this.children = children;
        this.history = history;
        this.ancestors = ancestors;
        this.body = body;
        this.version = version;
        this.descendants = descendants;
        this.space = space;
    }

    @JsonProperty("container")
    public String getContainer() {
        return container;
    }

    @JsonProperty("container")
    public void setContainer(String container) {
        this.container = container;
    }

    public Expandable_ withContainer(String container) {
        this.container = container;
        return this;
    }

    @JsonProperty("operations")
    public String getOperations() {
        return operations;
    }

    @JsonProperty("operations")
    public void setOperations(String operations) {
        this.operations = operations;
    }

    public Expandable_ withOperations(String operations) {
        this.operations = operations;
        return this;
    }

    @JsonProperty("children")
    public String getChildren() {
        return children;
    }

    @JsonProperty("children")
    public void setChildren(String children) {
        this.children = children;
    }

    public Expandable_ withChildren(String children) {
        this.children = children;
        return this;
    }

    @JsonProperty("history")
    public String getHistory() {
        return history;
    }

    @JsonProperty("history")
    public void setHistory(String history) {
        this.history = history;
    }

    public Expandable_ withHistory(String history) {
        this.history = history;
        return this;
    }

    @JsonProperty("ancestors")
    public String getAncestors() {
        return ancestors;
    }

    @JsonProperty("ancestors")
    public void setAncestors(String ancestors) {
        this.ancestors = ancestors;
    }

    public Expandable_ withAncestors(String ancestors) {
        this.ancestors = ancestors;
        return this;
    }

    @JsonProperty("body")
    public String getBody() {
        return body;
    }

    @JsonProperty("body")
    public void setBody(String body) {
        this.body = body;
    }

    public Expandable_ withBody(String body) {
        this.body = body;
        return this;
    }

    @JsonProperty("version")
    public String getVersion() {
        return version;
    }

    @JsonProperty("version")
    public void setVersion(String version) {
        this.version = version;
    }

    public Expandable_ withVersion(String version) {
        this.version = version;
        return this;
    }

    @JsonProperty("descendants")
    public String getDescendants() {
        return descendants;
    }

    @JsonProperty("descendants")
    public void setDescendants(String descendants) {
        this.descendants = descendants;
    }

    public Expandable_ withDescendants(String descendants) {
        this.descendants = descendants;
        return this;
    }

    @JsonProperty("space")
    public String getSpace() {
        return space;
    }

    @JsonProperty("space")
    public void setSpace(String space) {
        this.space = space;
    }

    public Expandable_ withSpace(String space) {
        this.space = space;
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

    public Expandable_ withAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
        return this;
    }

}
