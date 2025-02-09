package com.example.product.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.product.entity.Payment;

public interface PaymentRepository extends JpaRepository<Payment, Integer> {

	 Payment findByOrderId(int orderId);
}
