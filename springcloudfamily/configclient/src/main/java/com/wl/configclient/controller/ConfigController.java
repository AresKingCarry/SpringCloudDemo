package com.wl.configclient.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Ares on 2018/4/18.
 */
@RestController
@RefreshScope
public class ConfigController {
    @Value("${shoujin}")
    private String shoujin;

    @GetMapping("/getInfo")
    public String getInfo(){
        return  shoujin;
    }
}
