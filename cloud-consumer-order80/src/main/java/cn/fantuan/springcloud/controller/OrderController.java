package cn.fantuan.springcloud.controller;

import cn.api.domain.CommonResult;
import cn.api.domain.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
@Slf4j
public class OrderController {
	@Autowired
	private RestTemplate restTemplate;
	//调用远程接口的url
	public static final String PAYMENT_URL = "http://CLOUD-PAYMENT-SERVICE";

	@GetMapping("/order/payment/get")
	public CommonResult<User> create() {
		return restTemplate.getForObject(PAYMENT_URL + "/Payment/getUser", CommonResult.class);
	}

	@GetMapping("/order/payment/zipkin")
	public String get() {
		return restTemplate.getForObject(PAYMENT_URL + "/Payment/zipkin", String.class);
	}
}