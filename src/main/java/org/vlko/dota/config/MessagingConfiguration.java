package org.vlko.dota.config;

import org.springframework.amqp.core.Queue;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MessagingConfiguration {

  @Bean
  public Queue queue(@Value("${broker.queue.name}") String queueName) {
    return new Queue(queueName, false);
  }
}
