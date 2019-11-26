package com.zhangzz.sericefeign.feignService.hystrix;

import com.zhangzz.sericefeign.feignService.SchedualServiceHello;
import org.springframework.stereotype.Component;

@Component
public class SchedualServiceHelloHystrix implements SchedualServiceHello {

    @Override
    public String sayHiFromClientOne(String name) {
        return "sorry " + name + ", there is something error";
    }

}
