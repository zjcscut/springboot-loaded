package org.throwable.http.repository.entity;

/**
 * @author zhangjinci
 * @version 2017/1/6 12:02
 * @function
 */
public interface Request {

    Headers getRequestHeaders();

    Parameters getRequestParameters();
}
