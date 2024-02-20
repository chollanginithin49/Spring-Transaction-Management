package com.demo.transaction.controller;

import com.demo.transaction.dto.OrderRequest;
import com.demo.transaction.dto.OrderResponse;
import com.demo.transaction.entity.Order;
import com.demo.transaction.service.OrderService;
import com.demo.transaction.service.impl.OrderServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/orders")
public class OrderController {
    private OrderService orderService;

    public OrderController(OrderService orderService)
    {
        this.orderService = orderService;
    }

    @PostMapping("/placeOrder")
    public ResponseEntity<OrderResponse> placeOrder(@RequestBody OrderRequest orderRequest)
    {
        return ResponseEntity.ok(orderService.placeOrder(orderRequest));
    }

    @PutMapping("/updateOrder")
    public ResponseEntity<String> updateOrderStatus(@RequestParam("id") Long id)
    {
        return ResponseEntity.ok(orderService.updateOrderStatus(id));
    }


    @GetMapping("/getOrders")
    public ResponseEntity<List<Order>> getOrders()
    {
        return ResponseEntity.ok(orderService.getAllOrders());
    }
}
