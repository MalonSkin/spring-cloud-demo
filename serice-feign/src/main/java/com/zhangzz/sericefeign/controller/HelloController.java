package com.zhangzz.sericefeign.controller;

import com.zhangzz.sericefeign.feignService.SchedualServiceHello;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class HelloController {

    @Resource
    SchedualServiceHello schedualServiceHello;

    @RequestMapping(value = "/hello",method = RequestMethod.GET)
    public String sayHi(@RequestParam String name){
        return schedualServiceHello.sayHiFromClientOne(name);
    }
}
