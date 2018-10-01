/**
 * 
 */
package com.clc.springboot.kafka;

import org.apache.kafka.clients.producer.ProducerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

/**
 * @author pnichols
 *
 */
@Component
public class Publisher {
  private static final Logger LOG=LoggerFactory.getLogger(Publisher.class);
  
  public Publisher() {
	  
  }
  @Autowired
  private KafkaTemplate<String, String> template;
   
  public void send(String topic, String payload) {
     LOG.debug("Entering Send.");
     LOG.info(String.format("Payload:\n%s",payload));
       template.send(new ProducerRecord(topic,payload));
      LOG.info(String.format("Message: \n%s\nsent to topic: %s",payload,topic));
  }
}
