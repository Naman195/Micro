package com.example.product.service;

import java.util.Random;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.product.entity.Payment;
import com.example.product.repository.PaymentRepository;

@Service
public class PaymentService {
	
	@Autowired
	private PaymentRepository paymentRepository;

	public Payment doPayment(Payment payment) {
		payment.setTransactionId(UUID.randomUUID().toString());
		payment.setPaymentStatus(paymentProcessing());
		return paymentRepository.save(payment);
	}
	
	public String paymentProcessing(){
        
        return new Random().nextBoolean()?"success":"false";
    }
	
	 public Payment findPaymentHistoryByOrderId(int orderId) {
	        Payment payment=paymentRepository.findByOrderId(orderId);
//	        logger.info("paymentService findPaymentHistoryByOrderId : {}",new ObjectMapper().writeValueAsString(payment));
	        return payment ;
	    }
}
