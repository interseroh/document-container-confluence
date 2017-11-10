package com.lofidewanto.demo.server.domain.attachments;

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
public class AllAttachments {

    @JsonProperty("results")
    private List<Result> results = new ArrayList<Result>();
    @JsonProperty("start")
    private int start;
    @JsonProperty("limit")
    private int limit;
    @JsonProperty("size")
    private int size;
    @JsonProperty("_links")
    private Links__ links;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     *
     */
    public AllAttachments() {
    }

    /**
     *
     * @param limit
     * @param results
     * @param start
     * @param links
     * @param size
     */
    public AllAttachments(List<Result> results, int start, int limit, int size, Links__ links) {
        super();
        this.results = results;
        this.start = start;
        this.limit = limit;
        this.size = size;
        this.links = links;
    }

    @JsonProperty("results")
    public List<Result> getResults() {
        return results;
    }

    @JsonProperty("results")
    public void setResults(List<Result> results) {
        this.results = results;
    }

    public AllAttachments withResults(List<Result> results) {
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

    public AllAttachments withStart(int start) {
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

    public AllAttachments withLimit(int limit) {
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

    public AllAttachments withSize(int size) {
        this.size = size;
        return this;
    }

    @JsonProperty("_links")
    public Links__ getLinks() {
        return links;
    }

    @JsonProperty("_links")
    public void setLinks(Links__ links) {
        this.links = links;
    }

    public AllAttachments withLinks(Links__ links) {
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

    public AllAttachments withAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
        return this;
    }

}
