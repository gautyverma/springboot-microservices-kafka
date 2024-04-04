package com.matuga.springbootKafka1.controller;

import static com.matuga.springbootKafka1.util.KafkaConstants.TOPIC_MATUGA;

import com.matuga.springbootKafka1.service.KafkaProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/kafka")
public class MessageController {

  @Autowired private KafkaProducer kafkaProducer;

  public MessageController(KafkaProducer kafkaProducer) {
    this.kafkaProducer = kafkaProducer;
  }

  // http://localhost:8080/api/v1/kafka/publish?message=learning_Kafka
  @GetMapping("/publish")
  public ResponseEntity<String> publishMessage(@RequestParam("message") String message) {
    kafkaProducer.sendMessage(message);
    return ResponseEntity.ok("Message " + message + " sent to topic " + TOPIC_MATUGA);
  }
}
