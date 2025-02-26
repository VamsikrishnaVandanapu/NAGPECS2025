package com.nagp.ecs.ecomapp.repository;

import com.nagp.ecs.ecomapp.model.*;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderItemsRepository extends JpaRepository<OrderItem,Integer> {
}
