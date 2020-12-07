package cn.fantuan.springcloud.controller;

import cn.api.domain.CommonResult;
import cn.api.domain.User;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PaymentController {
    @Value("${server.port}")
    private String port;

    @GetMapping("/Payment/getUser")
    public Object getUser() {
        return new CommonResult<User>(1, port, new User(20, "张三", "男"));
    }
}