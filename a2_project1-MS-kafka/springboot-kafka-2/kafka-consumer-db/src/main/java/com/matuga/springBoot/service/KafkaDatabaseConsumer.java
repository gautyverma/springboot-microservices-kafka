package com.matuga.springBoot.service;

import static com.matuga.springBoot.util.KafkaConstants.GROUP_ID;
import static com.matuga.springBoot.util.KafkaConstants.TOPIC_WIKIMEDIA;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaDatabaseConsumer {
  private static final Logger LOGGER = LoggerFactory.getLogger(KafkaDatabaseConsumer.class);

  @KafkaListener(topics = TOPIC_WIKIMEDIA, groupId = GROUP_ID)
  public void consume(String eventMessage) {
    LOGGER.info(String.format("Event message received -> %s", eventMessage));
  }
}
