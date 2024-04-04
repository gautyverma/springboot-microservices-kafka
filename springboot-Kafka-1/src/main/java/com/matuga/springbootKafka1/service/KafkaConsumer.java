package com.matuga.springbootKafka1.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import static com.matuga.springbootKafka1.util.KafkaConstants.TOPIC_MATUGA;

@Service
public class KafkaConsumer {

  private static final Logger LOGGER = LoggerFactory.getLogger(KafkaConsumer.class);

  @KafkaListener(topics = TOPIC_MATUGA, groupId = "myGroup")
  public void topicConsumer(String message) {
    LOGGER.info(String.format("Message received -> %s", message));
  }
}
