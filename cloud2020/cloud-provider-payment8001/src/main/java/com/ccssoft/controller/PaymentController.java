package com.ccssoft.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ccssoft.entity.CommonResult;
import com.ccssoft.entity.Payment;
import com.ccssoft.service.PaymentService;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class PaymentController {
	@Resource
	private PaymentService paymentService;
	@Resource
	private DiscoveryClient discoveryClient;
	@Value("${server.port}")
	private String serverPort;
	
	@PostMapping(value="/payment/create")
	@ResponseBody
	public CommonResult create(@RequestBody Payment payment){
		int result = paymentService.create(payment);
		if(result > 0) {
			return new CommonResult(200, "插入数据操作成功", result);
		}else {
			return new CommonResult(444, "插入数据操作失败", result);
		}
	}
	
	@GetMapping("/payment/get/{id}")
	@ResponseBody
	public CommonResult getPaymentById(@PathVariable("id") Long id) {
		Payment payment = paymentService.getPaymentById(id);
		
		if(payment != null) { 
			return new CommonResult(200, "查询成功" +serverPort, payment); 
		}else { return
			new CommonResult(444, "没有符合条件数据" +serverPort, payment); 
		}
		
	}
	
	@GetMapping(value="/payment/discovery")
	@ResponseBody
	public Object discovery() {
		List<String> services = discoveryClient.getServices();
		for(String s : services) {
			log.info(s);
		}
		List<ServiceInstance> list = discoveryClient.getInstances("cloud-payment-service");
		for(ServiceInstance si : list) {
			log.info(si.getHost() + "\t" + si.getInstanceId() + "\t" + si.getUri());
		}
		return this.discoveryClient;
	}
}
