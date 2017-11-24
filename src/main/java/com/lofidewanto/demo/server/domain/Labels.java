package com.lofidewanto.demo.server.domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "results",
        "start",
        "limit",
        "size",
        "_links"
})
public class Labels {

    @JsonProperty("results")
    private List<Object> results = new ArrayList<Object>();
    @JsonProperty("start")
    private int start;
    @JsonProperty("limit")
    private int limit;
    @JsonProperty("size")
    private int size;
    @JsonProperty("_links")
    private Links links;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     *
     */
    public Labels() {
    }

    /**
     *
     * @param limit
     * @param results
     * @param start
     * @param links
     * @param size
     */
    public Labels(List<Object> results, int start, int limit, int size, Links links) {
        super();
        this.results = results;
        this.start = start;
        this.limit = limit;
        this.size = size;
        this.links = links;
    }

    @JsonProperty("results")
    public List<Object> getResults() {
        return results;
    }

    @JsonProperty("results")
    public void setResults(List<Object> results) {
        this.results = results;
    }

    public Labels withResults(List<Object> results) {
        this.results = results;
        return this;
    }

    @JsonProperty("start")
    public int getStart() {
        return start;
    }

    @JsonProperty("start")
    public void setStart(int start) {
        this.start = start;
    }

    public Labels withStart(int start) {
        this.start = start;
        return this;
    }

    @JsonProperty("limit")
    public int getLimit() {
        return limit;
    }

    @JsonProperty("limit")
    public void setLimit(int limit) {
        this.limit = limit;
    }

    public Labels withLimit(int limit) {
        this.limit = limit;
        return this;
    }

    @JsonProperty("size")
    public int getSize() {
        return size;
    }

    @JsonProperty("size")
    public void setSize(int size) {
        this.size = size;
    }

    public Labels withSize(int size) {
        this.size = size;
        return this;
    }

    @JsonProperty("_links")
    public Links getLinks() {
        return links;
    }

    @JsonProperty("_links")
    public void setLinks(Links links) {
        this.links = links;
    }

    public Labels withLinks(Links links) {
        this.links = links;
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

    public Labels withAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
        return this;
    }

}
