package com.api.http;

/**
 * 建造者模式
 */
public class HttpBuilder {

    private HttpSampler httpSampler;

    public HttpBuilder() {
        httpSampler = new HttpSampler();
    }

    public HttpBuilder url(String url) {
        httpSampler.setUrl(url);
        return this;
    }

    public HttpRes get() {
        return httpSampler.get();
    }

    public HttpBuilder name(String name) {
        httpSampler.setName(name);
        return this;
    }
}
