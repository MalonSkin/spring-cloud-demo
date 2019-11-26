package com.zhangzz.hello.controller;

import com.alibaba.fastjson.JSON;
import com.zhangzz.hello.publish.PublishParam;
import com.zhangzz.hello.publish.PublishResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RestController
public class HelloController {

    private static final Logger logger = LoggerFactory.getLogger(HelloController.class);

    @Autowired
    private HttpServletRequest request;

    @Value("${server.port}")
    String port;

    @RequestMapping("/hello")
    public String hello(String name) {
        return "hello " + name + ",I am from port:" + port;
    }

    @RequestMapping(
            value = "/ewm/rest/receive",
            method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public PublishResult receive(@RequestBody PublishParam param) {
        PublishResult result = new PublishResult();
        logger.info("收到推送消息......");
        logger.info(JSON.toJSONString(param));
        PublishParam.Auth auth = param.getAuth();
        if (auth.getChannel_name().equals("zhangzz") && auth.getChannel_password().equals("zhangzz") && auth.getClient_ip().equals("127.0.0.1")) {
            result.setCode(PublishResult.SUCCESS_CODE);
            result.setMessage("成功入缓冲区");
            logger.info("验证成功");
        } else {
            result.setCode("2");
            result.setMessage("验证失败");
            logger.error("验证失败");
        }
        return result;
    }
}
