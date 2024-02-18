package com.demo.transaction.service;

import com.demo.transaction.dto.OrderRequest;
import com.demo.transaction.dto.OrderResponse;
import com.demo.transaction.entity.Order;

import java.util.List;

public interface OrderService {
    OrderResponse placeOrder(OrderRequest orderRequest);
    List<Order> getAllOrders();
    String updateOrderStatus(Long id);

    Order findById(Long id);
}
