package com.wl.client.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Ares on 2018/4/11.
 */
@RestController
public class User {

    @GetMapping("/user/findById")
    public String findById(@RequestParam("id")String id){
        return "这个是springcloud的客户端"+id;
    }


}
