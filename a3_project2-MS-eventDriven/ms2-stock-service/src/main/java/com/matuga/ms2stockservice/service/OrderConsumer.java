package com.matuga.ms2stockservice.service;

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
    LOGGER.info(String.format("Order event received in stock service -> %s", event.toString()));

    // we can save the data in DB , like we did in last section (2).
  }
}
