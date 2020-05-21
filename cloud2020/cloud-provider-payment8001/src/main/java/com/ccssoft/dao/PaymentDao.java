package com.ccssoft.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.ccssoft.entity.Payment;

@Mapper
//@Repository //这个注解有时候插入时会有问题
public interface PaymentDao {
	public int create(Payment payment);
	public Payment getPaymentById(@Param("id") Long id);
}
