/**
 * 
 */
package com.clc.springboot.restservice;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.clc.springboot.kafka.Publisher;

/**
 * @author pnichols
 *
 */
@RestController
public class KafkaRestService {
  private static final Logger LOG=LoggerFactory.getLogger(KafkaRestService.class.getName());

  @Autowired
  private Publisher publisher;
  @Value("${spring.app.topic.test-example}")
  private String topic;
  
  @RequestMapping(value="/publish/{message}", method=RequestMethod.GET)
  public @ResponseBody String publishMessage(@PathVariable("message") String message) {
	  String result=String.format("Message Sent to Topic: %s",topic);
	  if( (message !=null) && (message.length()>0)) {
		  LOG.debug("Sending message to Kafka Queue");
		  publisher.send(topic, message);
	  }
	  
	  return result;
  }
}
