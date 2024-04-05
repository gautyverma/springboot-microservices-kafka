package com.matuga.ms3emailservice.service;

import com.matuga.ms4basedomains.model.OrderEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class OrderConsumer {
  private static final Logger LOGGER = LoggerFactory.getLogger(OrderConsumer.class);

  @KafkaListener(
      topics = "${spring.kafka.topic.name}",
      groupId = "${spring.kafka.consumer.group-id}")
  public void consumeOrder(OrderEvent event) {
    LOGGER.info(String.format("Order event received in email service -> %s", event.toString()));

    // Send email tp client/customer
  }
}
