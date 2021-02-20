package cn.fantuan.springcloud.controller;

import cn.api.domain.CommonResult;
import cn.api.domain.User;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

@RestController
public class PaymentController {
    @Value("${server.port}")
    private String port;

    @GetMapping("/Payment/getUser")
    public Object getUser() {
        return new CommonResult<User>(1, port, new User(20, "李四", "女"));
    }

    @GetMapping("/Payment/getId/{id}")
    public Object getId(@PathVariable("id") Long id) {
        return new CommonResult<User>(1, port+":"+id, new User(20, "张三", "男"));
    }

    @GetMapping("/Payment/outTime/{id}")
    public Object outTime(@PathVariable("id") Long id) {
        return new CommonResult<User>(1, "端口号："+port+"  "+"获取的值"+id, new User(20, "张三", "男"));
    }
}