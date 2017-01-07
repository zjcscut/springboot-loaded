package org.throwable.http.repository;

import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicHeader;
import org.apache.http.util.EntityUtils;
import org.throwable.http.repository.entity.DefaultHeaders;
import org.throwable.http.repository.entity.DefaultParameters;
import org.throwable.http.repository.entity.Headers;
import org.throwable.http.repository.entity.Parameters;

import java.util.Map;

/**
 * @author zhangjinci
 * @version 2017/1/7 11:46
 * @function
 */
public class HttpClient {

    private Headers headers;
    private Parameters parameters;

    HttpClient() {
        headers = new DefaultHeaders();
        parameters = new DefaultParameters();
    }

    public static HttpClient getInstance() {
        return new HttpClient();
    }

    public HttpClient addHeader(String key,String value){
        headers.addHeader(key, value);
        return this;
    }

    public HttpClient addParameter(String key,String value){
        parameters.addParameter(key, value);
        return this;
    }


    public String doPost(String uri, Map<String, String> headerMap, Map<String, String> paramMap) throws Exception {
        headers.addHeaders(headerMap);
        parameters.addParameters(paramMap);
        CloseableHttpClient client = HttpClients.createDefault();
        HttpPost request = new HttpPost(uri);
        request.setHeaders(headers.getHeaders().toArray(new BasicHeader[headers.getHeaders().size()]));
        request.setEntity(new UrlEncodedFormEntity(parameters.getParameters(), "UTF-8"));
        CloseableHttpResponse response = client.execute(request);
        return EntityUtils.toString(response.getEntity());
    }


}
