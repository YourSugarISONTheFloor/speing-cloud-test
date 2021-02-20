package cn.fantuan.springcloud.service;

import cn.api.domain.CommonResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Component
@FeignClient("CLOUD-PAYMENT-SERVICE")
public interface OrderFeignService {

	@GetMapping("/Payment/getId/{id}")
	CommonResult getPayment(@PathVariable("id") Long id);

	@GetMapping(value = "/Payment/outTime/{id}")
	CommonResult paymentFeignTimeout(@PathVariable("id") Long id);
}
