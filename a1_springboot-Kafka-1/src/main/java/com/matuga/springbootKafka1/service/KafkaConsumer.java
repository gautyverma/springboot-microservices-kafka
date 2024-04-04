package com.matuga.springbootKafka1.service;

import static com.matuga.springbootKafka1.util.KafkaConstants.TOPIC_MATUGA;
import static com.matuga.springbootKafka1.util.KafkaConstants.TOPIC_MATUGA_JSON;

import com.matuga.springbootKafka1.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumer {

  private static final Logger LOGGER = LoggerFactory.getLogger(KafkaConsumer.class);

  @KafkaListener(topics = TOPIC_MATUGA, groupId = "myGroup")
  public void topicConsumer(String message) {
    LOGGER.info(String.format("Message received -> %s", message));
  }

  @KafkaListener(topics = TOPIC_MATUGA_JSON, groupId = "myGroup")
  public void topicConsumer(User data) {
    LOGGER.info(String.format("User message received -> %s", data.toString()));
  }
}
