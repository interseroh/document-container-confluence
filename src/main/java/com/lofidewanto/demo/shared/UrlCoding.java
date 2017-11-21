package com.lofidewanto.demo.shared;

/**
 * UrlCoding
 * Klasse zum Codieren von URLs als String, ohne das Parameter verwendet werden
 */
public class UrlCoding {

    private String url;

    public UrlCoding() {
    }

    public UrlCoding(String url) {
        this.url = url;
    }

    public String encode() {
        String url;
        url = this.url.replace("?", "__-__").replace("&", "--_--");
        return url;
    }

    public String encode(String url) {
        this.url = url;
        return encode();
    }

    public String decode() {
        String url;
        url = this.url.replace("__-__", "?").replace("--_--", "&");
        return url;
    }

    public String decode(String url) {
        this.url = url;
        return decode();
    }
}
