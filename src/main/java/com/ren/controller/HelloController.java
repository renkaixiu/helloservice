package com.ren.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * Created by dongao on 2018/11/20.
 */
@RestController
public class HelloController {
    Logger logger = LoggerFactory.getLogger(HelloController.class);

    @Autowired
    DiscoveryClient discoveryClient;

    @RequestMapping("/hello")
    public String Hello(){
        ServiceInstance serviceInstance = discoveryClient.getLocalServiceInstance();
        logger.info("-----------------------------"+serviceInstance.getServiceId());
        return "hello,this is hello-server";
    }
}
