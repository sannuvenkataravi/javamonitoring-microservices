package com.Micro.Odr.rigistory;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Micro.Odr.entity.Order;


public interface OrderRepository extends JpaRepository<Order,Integer> {

}
