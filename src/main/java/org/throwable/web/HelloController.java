package org.throwable.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * @author zhangjinci
 * @version 2017/1/6 11:30
 * @function
 */
@Controller
public class HelloController {

    @RequestMapping(value = "/hello.html", method = RequestMethod.GET)
    @ResponseBody
    public String hello() {
        System.out.println("Hello zjc222222");
        System.out.println(getName("hello"));
        return "success";
    }

    private String getName(String z) {
        return z + "3423w42424";
    }

    @RequestMapping(value = "/hello2.html", method = RequestMethod.GET)
    @ResponseBody
    public String hello2() {
        System.out.println("Hello zjc222222");
        System.out.println(getName("hello"));
        return "success2";
    }

    @RequestMapping(value = "/1111")
    @ResponseBody
    public String test1(@RequestParam("id") Integer id, @RequestParam("name") String name, @RequestParam("age") String age,
                        @RequestHeader("key1") String header1) {
        System.out.println("id = " + id + ";name = " + name + ";age = " + age + ";header1 = " + header1);
        return "success";
    }

    @RequestMapping(value = "/2222")
    @ResponseBody
    public String test2(@RequestParam("id") Integer id, @RequestParam("name") String name, @RequestParam("age") String age,
                        @RequestHeader("key2") String header2) {
        System.out.println("id = " + id + ";name = " + name + ";age = " + age + ";header2 = " + header2);
        return "success";
    }
}
