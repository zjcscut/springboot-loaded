package org.throwable.http.repository;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;

/**
 * @author zhangjinci
 * @version 2017/1/7 17:10
 * @function
 */
public class HttpClientTest {

    @Test
    public void test1() throws Exception {

        for (int i = 0; i < 10; i++) {

            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        System.out.println(dopost1());
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }, "thread1111" + i).start();


            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        System.out.println(dopost2());
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }, "thread22222" + i).start();
        }


        System.in.read();
    }

    private String dopost1() throws Exception {
        Map<String, String> params = new HashMap<String, String>();
        Map<String, String> header = new HashMap<String, String>();
        header.put("key1", "value1");
        String url = "http://localhost:9090/1111";
        params.put("id", "1");
        params.put("name", "zjcscut");
        return HttpClient.getInstance().addParameter("age","11111111").doPost(url, header, params);
    }

    private String dopost2() throws Exception {
        Map<String, String> params = new HashMap<String, String>();
        Map<String, String> headers = new HashMap<String, String>();
        headers.put("key2", "value2");
        String url = "http://localhost:9090/2222";
        params.put("id", "222");
        params.put("name", "zjcscut22");
        return HttpClient.getInstance().addParameter("age","22222222").doPost(url, headers, params);

    }

}