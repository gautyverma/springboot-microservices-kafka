package com.matuga.springboot.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

import static com.matuga.springboot.util.KafkaConstants.TOPIC_WIKIMEDIA;

@Configuration
public class KafkaTopicConfig {

  public NewTopic topic() {
    return TopicBuilder.name(TOPIC_WIKIMEDIA).build();
  }
}
