package cn.fantuan.springcloud.controller;

import cn.api.domain.CommonResult;
import cn.api.domain.User;
import cn.fantuan.springcloud.service.OrderFeignService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@Slf4j
@RestController
public class FeignController {

	@Resource
	private OrderFeignService orderFeignService;

	@GetMapping("/feign/payment/get/{id}")
	public CommonResult<User> getPayment(@PathVariable("id") Long id){
		System.out.println("id = " + id);
		return orderFeignService.getPayment(id);
	}

	@GetMapping("/feign/outTime/{id}")
	public CommonResult<User> outTime(@PathVariable("id") Long id){
		System.out.println("id = " + id);
		return orderFeignService.paymentFeignTimeout(id);
	}

}