package com.Micro.Odr.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Micro.Odr.common.TransactionRequest;
import com.Micro.Odr.common.TransactionResponse;
import com.Micro.Odr.service.OrderService;


/**
 * @author 10714851
 *
 */
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
