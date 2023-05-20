package com.micro.pmt.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.micro.pmt.entity.Payment;

public interface PaymentRepository extends JpaRepository<Payment,Integer> {
   Payment findByOrderId(int orderId);
}