package com.Micro.Odr.proxyservice;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.Micro.Odr.common.Payment;

@FeignClient(name = "PAYMENT-MICROSERVICES")
public interface PaymentFeingnClient {

	
 @PostMapping(path="/payment/doPayment")
  Payment doPayment(@RequestBody Payment payment);
}
