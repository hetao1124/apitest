package com.api.http;

import com.mashape.unirest.http.Headers;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * http请求
 */
public class HttpSampler {

    private String name;
    private String comments;
    private String url;
    private String method;
    private Map<String, String> headers;
    private Map<String, String> parameters;
    private String bodyData;

    public HttpSampler() {

    }

    public HttpSampler(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public Map<String, String> getParameters() {
        return parameters;
    }

    public void setParameters(Map<String, String> parameters) {
        this.parameters = parameters;
    }

    public String getBodyData() {
        return bodyData;
    }

    public void setBodyData(String bodyData) {
        this.bodyData = bodyData;
    }


    public Map<String, String> getHeaders() {
        return headers;
    }

    public void setHeaders(Map<String, String> headers) {
        this.headers = headers;
    }


    public HttpRes get() {
        this.method = HttpConstants.GET;
        HttpRes response = null;
        try {
            HttpResponse<String> res = Unirest.get(this.url)
                    .asString();
            response = toHttpRes(res);
        } catch (UnirestException e) {
            response = new HttpRes();
            response.setError(e.getMessage());
        }
        return response;
    }

    public HttpRes post() {
        this.method = HttpConstants.POST;
        HttpRes response = new HttpRes();
        return response;
    }

    private HttpRes toHttpRes(HttpResponse<String> res) {
        HttpRes response = new HttpRes();
        int code = res.getStatus();
        String body = res.getBody();
        String statusText = res.getStatusText();
        response.setCode(code);
        response.setBody(body);
        response.setMessage(statusText);
        response.setHeaders(headersToString(res.getHeaders()));
        return response;
    }

    private String headersToString(Headers headers) {
        StringBuilder headersStr = new StringBuilder();
        Set<String> headersKeys = headers.keySet();
        for (String key : headersKeys) {
            headersStr.append(key + ":");
            List<String> values = headers.get(key);
            values.forEach(value ->
                    headersStr.append(value)
            );
            headersStr.append("\n");
        }
        return headersKeys.toString();
    }
}
