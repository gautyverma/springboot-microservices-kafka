package com.matuga.ms1orderservice.service;

import static com.matuga.ms1orderservice.util.KafkaConstants.TOPIC_ORDER;

import com.matuga.ms4basedomains.model.OrderEvent;
import org.apache.kafka.clients.admin.NewTopic;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

@Service
public class OrderProducer {
  private static final Logger LOGGER = LoggerFactory.getLogger(OrderProducer.class);

  @Autowired private KafkaTemplate<String, OrderEvent> kafkaTemplate;

  public void sendMessage(OrderEvent event) {
    LOGGER.info(String.format("Order event -> %s", event.toString()));

    // create message
    Message<OrderEvent> message =
        MessageBuilder.withPayload(event).setHeader(KafkaHeaders.TOPIC, TOPIC_ORDER).build();
    kafkaTemplate.send(message);
  }
}
