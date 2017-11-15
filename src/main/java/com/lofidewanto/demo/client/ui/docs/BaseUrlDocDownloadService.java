package com.lofidewanto.demo.client.ui.docs;

import javax.inject.Singleton;

@Singleton
public class BaseUrlDocDownloadService {

    private String baseUrl;

    public String getBaseUrl() {
        return baseUrl;
    }

    public void setBaseUrl(String baseUrl) {
        this.baseUrl = baseUrl;
    }
}
