package com.micro.pmt.services;

import java.util.Random;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.micro.pmt.entity.Payment;
import com.micro.pmt.repository.PaymentRepository;


@Service
public class PaymentService {
	
	@Autowired
    private PaymentRepository repository;
	
	public Payment doPayment(Payment payment) {
	     payment.setPaymentStatus(paymentProcessing());
		payment.setTransactionId(UUID.randomUUID().toString());
		return repository.save(payment);
	}
	public String paymentProcessing(){
        //api should be 3rd party payment gateway (paypal,paytm...)
        return new Random().nextBoolean()?"success":"false";
    }
	
	  public Payment findPaymentHistoryByOrderId(int orderId){
	      
	      //  logger.info("paymentService findPaymentHistoryByOrderId : {}",new ObjectMapper().writeValueAsString(payment));
	        return  repository.findByOrderId(orderId);
	    }
}
