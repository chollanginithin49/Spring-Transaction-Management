package com.demo.transaction.dto;

import com.demo.transaction.entity.Order;
import com.demo.transaction.entity.Payment;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class OrderRequest {
    private Order order;
    private Payment payment;
}
