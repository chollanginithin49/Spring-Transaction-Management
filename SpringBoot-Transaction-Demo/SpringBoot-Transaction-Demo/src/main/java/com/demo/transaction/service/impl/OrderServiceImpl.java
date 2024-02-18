package com.demo.transaction.service.impl;

import com.demo.transaction.dto.OrderRequest;
import com.demo.transaction.dto.OrderResponse;
import com.demo.transaction.entity.Order;
import com.demo.transaction.entity.Payment;
import com.demo.transaction.exception.OrderIdNotFoundException;
import com.demo.transaction.exception.PaymentException;
import com.demo.transaction.repository.OrderRepository;
import com.demo.transaction.repository.PaymentRepository;
import com.demo.transaction.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class OrderServiceImpl implements OrderService {


    private OrderRepository orderRepository;

    private PaymentRepository paymentRepository;

    public OrderServiceImpl(OrderRepository orderRepository, PaymentRepository paymentRepository)
    {
        this.orderRepository = orderRepository;
        this.paymentRepository = paymentRepository;
    }

    @Override
    //@Transactional(propagation = Propagation.REQUIRES_NEW,rollbackFor = IllegalStateException.class)
    public OrderResponse placeOrder(OrderRequest orderRequest) {
        Order order = orderRequest.getOrder();
        order.setStatus("INPROGRESS");
        order.setOrderTrackingNumber(UUID.randomUUID().toString());
        orderRepository.save(order);

        Payment payment = orderRequest.getPayment();

        if(!payment.getType().equals("DEBIT")) {
            throw new PaymentException("Payment card type do not support");
        }

        payment.setOrderId(order.getId());
        paymentRepository.save(payment);


        OrderResponse orderResponse = new OrderResponse();
        orderResponse.setOrderTrackingNumber(order.getOrderTrackingNumber());
        orderResponse.setStatus(order.getStatus());
        orderResponse.setMessage("SUCCESS");

        return orderResponse;
    }



    @Override
    //@Transactional
    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }




    @Override
    public String updateOrderStatus(Long id) {

         Order order = findById(id);
         System.out.println(order);
         if(order.getStatus()=="INPROGRESS") {
             order.setStatus("SUCCESS");
             orderRepository.save(order);
         }


        return "Order Updated Successful";
    }

    @Override
    @Transactional(propagation = Propagation.MANDATORY)
    public Order findById(Long id) {
        System.out.println("From Find By Id method");
        Optional<Order> orderOptional = orderRepository.findById(id);
        if(orderOptional.isEmpty())
            throw new OrderIdNotFoundException("Order with the given "+id+" is not found");

        return orderOptional.get();
    }
}
