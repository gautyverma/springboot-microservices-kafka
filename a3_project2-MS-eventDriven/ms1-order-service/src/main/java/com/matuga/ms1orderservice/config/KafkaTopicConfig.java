package com.matuga.ms1orderservice.config;

import static com.matuga.ms1orderservice.util.KafkaConstants.TOPIC_ORDER;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class KafkaTopicConfig {

  // Spring bean for kafka topic
  @Bean
  public NewTopic topic() {
    return TopicBuilder.name(TOPIC_ORDER).build();
  }
}
