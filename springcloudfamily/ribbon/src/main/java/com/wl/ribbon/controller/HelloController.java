package com.wl.ribbon.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * Created by Ares on 2018/4/18.
 */
@RestController
public class HelloController {

    @Autowired
    RestTemplate restTemplate;

    @RequestMapping(value = "/hi")
    public String hi(@RequestParam("id") String id){
        return  restTemplate.getForObject("http://localhost:9001/user/findById?id="+id,String.class);

    }
}
