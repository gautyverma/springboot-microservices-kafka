package com.matuga.springboot.service;

import static com.matuga.springboot.util.KafkaConstants.TOPIC_WIKIMEDIA;
import static com.matuga.springboot.util.KafkaConstants.WIKIMEDIA_URL;

import com.launchdarkly.eventsource.EventHandler;
import com.launchdarkly.eventsource.EventSource;
import java.net.URI;
import java.util.concurrent.TimeUnit;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class WikimediaChangesProducer {

  private static final Logger LOGGER = LoggerFactory.getLogger(WikimediaChangesProducer.class);

  @Autowired private KafkaTemplate<String, String> kafkaTemplate;

  public void sendMessage() throws InterruptedException {

    // to read realtime stream data from wikimedia -> we use event source
    EventHandler eventHandler = new WikimediaChangesHandler(kafkaTemplate, TOPIC_WIKIMEDIA);
    EventSource.Builder builder = new EventSource.Builder(eventHandler, URI.create(WIKIMEDIA_URL));
    EventSource eventSource = builder.build();

    // start the producer in another thread
    eventSource.start();

    // we produce for 1 minutes and block the program until then
    TimeUnit.MINUTES.sleep(1);
  }
}
