package com.icss.etc.service.impl;

import com.icss.etc.dao.PaymentDao;
import com.icss.etc.pojo.Payment;
import com.icss.etc.service.PaymentService;

import javax.annotation.Resource;

public class PaymentServiceImpl implements PaymentService {

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
