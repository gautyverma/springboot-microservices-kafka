package com.matuga.ms1orderservice.controller;

import com.matuga.ms1orderservice.service.OrderProducer;
import com.matuga.ms4basedomains.model.Order;
import com.matuga.ms4basedomains.model.OrderEvent;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class OrderController {
  @Autowired private OrderProducer orderProducer;

  @PostMapping("/orders")
  public String placeOrder(@RequestBody Order order) {

    order.setOrderId(UUID.randomUUID().toString());

    OrderEvent orderEvent = new OrderEvent();
    orderEvent.setStatus("PENDING");
    orderEvent.setMessage("order status is in pending state");
    orderEvent.setOrder(order);

    orderProducer.sendMessage(orderEvent);
    return "Order placed successfully ...!";
  }
}
