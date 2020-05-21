package com.ccssoft.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.ccssoft.dao.PaymentDao;
import com.ccssoft.entity.Payment;
import com.ccssoft.service.PaymentService;
@Service
public class PaymentServiceImpl implements PaymentService{
	@Resource
    private PaymentDao paymentDao;
	@Override
	public int create(Payment payment) {
		return paymentDao.create(payment);
	}

	@Override
	public Payment getPaymentById(Long id) {
		return paymentDao.getPaymentById(id);
	}

}
