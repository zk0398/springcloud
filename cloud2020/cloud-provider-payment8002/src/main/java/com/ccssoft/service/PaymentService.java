package com.ccssoft.service;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import com.ccssoft.entity.Payment;

public interface PaymentService {
	public int create(Payment payment);
	public Payment getPaymentById(@Param("id") Long id);
}
