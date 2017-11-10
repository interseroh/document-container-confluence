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
        "webui",
        "download",
        "self"
})
public class Links_ {

    @JsonProperty("webui")
    private String webui;
    @JsonProperty("download")
    private String download;
    @JsonProperty("self")
    private String self;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     *
     */
    public Links_() {
    }

    /**
     *
     * @param self
     * @param download
     * @param webui
     */
    public Links_(String webui, String download, String self) {
        super();
        this.webui = webui;
        this.download = download;
        this.self = self;
    }

    @JsonProperty("webui")
    public String getWebui() {
        return webui;
    }

    @JsonProperty("webui")
    public void setWebui(String webui) {
        this.webui = webui;
    }

    public Links_ withWebui(String webui) {
        this.webui = webui;
        return this;
    }

    @JsonProperty("download")
    public String getDownload() {
        return download;
    }

    @JsonProperty("download")
    public void setDownload(String download) {
        this.download = download;
    }

    public Links_ withDownload(String download) {
        this.download = download;
        return this;
    }

    @JsonProperty("self")
    public String getSelf() {
        return self;
    }

    @JsonProperty("self")
    public void setSelf(String self) {
        this.self = self;
    }

    public Links_ withSelf(String self) {
        this.self = self;
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

    public Links_ withAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
        return this;
    }

}
