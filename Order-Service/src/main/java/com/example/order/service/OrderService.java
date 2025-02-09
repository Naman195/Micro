package com.example.order.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.order.entity.Order;
import com.example.order.repository.OrderRepository;

import common.Payment;
import common.TransactionRequest;
import common.TransactionResponse;

@Service
public class OrderService {
	
	 @Autowired
	    private OrderRepository repository;
	 
	 @Autowired
	    @Lazy
	    private RestTemplate template;
	 
	 public TransactionResponse  saveOrder(TransactionRequest request) {
		 	
		 String response = "";
		 	Order order = request.getOrder();
	    	Payment payment = request.getPayment();
	    	payment.setOrderId(order.getId());
	    	payment.setAmount(order.getPrice());
	    	
	    	Payment paymentResponse = template.postForObject("http://PAYMENT-SERVICE/payment/doPayment", payment, Payment.class);
	    	 response = paymentResponse.getPaymentStatus().equals("success") ? "payment processing successful and order placed" : "there is a failure in payment api , order added to cart";
	    	 repository.save(order);
	         return new TransactionResponse(order, paymentResponse.getAmount(), paymentResponse.getTransactionId(), response);
		 
	 }

}
