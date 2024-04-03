package com.matuga.springbootKafka1.config;

import static com.matuga.springbootKafka1.util.KafkaConstants.TOPIC_MATUGA;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class KafkaTopic {

  @Bean
  public NewTopic matugaTopic() {
    return TopicBuilder.name(TOPIC_MATUGA).build();
  }
}
