package org.throwable.http.repository.entity;



/**
 * @author zhangjinci
 * @version 2017/1/6 12:08
 * @function
 */
public class DefaultHttpRequest implements Request {

    private Headers headers;
    private Parameters parameters;

    public DefaultHttpRequest(Headers headers, Parameters parameters) {
        this.headers = headers;
        this.parameters = parameters;
    }

    @Override
    public Headers getRequestHeaders() {
        return headers;
    }

    @Override
    public Parameters getRequestParameters() {
        return parameters;
    }

    public void setHeaders(Headers headers) {
        this.headers = headers;
    }

    public void setParameters(Parameters parameters) {
        this.parameters = parameters;
    }
}
