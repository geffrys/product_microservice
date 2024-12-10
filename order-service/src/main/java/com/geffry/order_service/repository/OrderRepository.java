package com.geffry.order_service.repository;

import com.geffry.order_service.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;


public interface OrderRepository extends JpaRepository<Order, Long> {
}