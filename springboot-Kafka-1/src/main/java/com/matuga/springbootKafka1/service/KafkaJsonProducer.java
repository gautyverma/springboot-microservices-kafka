package com.matuga.springbootKafka1.service;

import static com.matuga.springbootKafka1.util.KafkaConstants.TOPIC_MATUGA;

import com.matuga.springbootKafka1.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

@Service
public class KafkaJsonProducer {
  private static final Logger LOGGER = LoggerFactory.getLogger(KafkaJsonProducer.class);
  private KafkaTemplate<String, User> kafkaUserTemplate;

  public KafkaJsonProducer(KafkaTemplate<String, User> kafkaUserTemplate) {
    this.kafkaUserTemplate = kafkaUserTemplate;
  }

  public void sendMessage(User data) {

    LOGGER.info(String.format("Message sent %s", data.toString()));
    Message<User> message =
        MessageBuilder.withPayload(data).setHeader(KafkaHeaders.TOPIC, TOPIC_MATUGA).build();
    kafkaUserTemplate.send(message);
  }
}
