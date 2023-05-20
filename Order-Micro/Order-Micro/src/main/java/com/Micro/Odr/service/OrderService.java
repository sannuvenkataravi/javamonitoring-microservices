package com.Micro.Odr.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.Micro.Odr.common.Payment;
import com.Micro.Odr.common.TransactionRequest;
import com.Micro.Odr.common.TransactionResponse;
import com.Micro.Odr.entity.Order;
import com.Micro.Odr.proxyservice.PaymentFeingnClient;
import com.Micro.Odr.rigistory.OrderRepository;


@Service
public class OrderService {

	@Autowired
	PaymentFeingnClient feingnclient;
	
	public TransactionResponse saveOrder(TransactionRequest request) {
		 String response = "";
		 Order order= request.getOrder();
		 Payment payment = request.getPayment();
		 payment.setOrderId(order.getId());
		 payment.setAmount(order.getPrice());
		   Payment paymentResponse = feingnclient.doPayment(payment);
	        response = paymentResponse.getPaymentStatus().equals("success") ? "payment processing successful and order placed" : "there is a failure in payment api , order added to cart";

	//	return repository.save(order);
        return new TransactionResponse(order, paymentResponse.getAmount(), paymentResponse.getTransactionId(), response);

	}

}
