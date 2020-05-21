package com.ccssoft.controller;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.ccssoft.entity.CommonResult;
import com.ccssoft.entity.Payment;
import com.netflix.discovery.EurekaClient;

@RestController
class OrderController {
	@Resource
	private RestTemplate restTemplate;
	public static final String PAYMENT_URL="http://CLOUD-PAYMENT-SERVICE";
	
	@GetMapping("/consumer/payment/create")
	public CommonResult<Payment> create(Payment payment){
		return restTemplate.postForObject(PAYMENT_URL + "/payment/create", payment, CommonResult.class);
	}
	@GetMapping("/consumer/payment/get/{id}")
	public CommonResult<Payment> create(@PathVariable Long id){
		return restTemplate.getForObject(PAYMENT_URL + "/payment/get/" + id, CommonResult.class);
	}
}
