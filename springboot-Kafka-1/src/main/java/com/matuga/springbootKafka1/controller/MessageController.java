package com.matuga.springbootKafka1.controller;

import static com.matuga.springbootKafka1.util.KafkaConstants.TOPIC_MATUGA;

import com.matuga.springbootKafka1.model.User;
import com.matuga.springbootKafka1.service.KafkaProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/kafka")
public class MessageController {

  @Autowired private KafkaProducer kafkaProducer;

  // http://localhost:8080/api/v1/kafka/publish?message=learning_Kafka
  @GetMapping("/publish")
  public ResponseEntity<String> publishMessage(@RequestParam("message") String message) {
    kafkaProducer.sendMessage(message);
    return ResponseEntity.ok("Message " + message + " sent to topic " + TOPIC_MATUGA);
  }

  // http://localhost:8080/api/v1/kafka/publish
  @PostMapping("/publish-user")
  public ResponseEntity<String> publishUser(@RequestBody User user) {
    kafkaProducer.sendMessage(user);
    return ResponseEntity.ok("Message " + user.toString() + " sent to topic " + TOPIC_MATUGA);
  }
}
