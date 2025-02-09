package com.example.order.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.order.entity.Order;
import com.example.order.service.OrderService;

import common.Payment;
import common.TransactionRequest;
import common.TransactionResponse;

@RestController
@RequestMapping("/order")
public class OrderController {
	
	@Autowired
    private OrderService service;
    
    @PostMapping("/bookOrder")
    public TransactionResponse bookOrder(@RequestBody TransactionRequest request) {
    	
        return service.saveOrder(request);
        		
    }

}
