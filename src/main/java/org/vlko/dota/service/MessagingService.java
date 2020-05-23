package org.vlko.dota.service;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.vlko.dota.persistence.entity.Hero;

@Service
public class MessagingService {
  private final String queueName;
  private final RabbitTemplate rabbitTemplate;

  public MessagingService(
      @Value("${broker.queue.name}") String queueName,
      RabbitTemplate rabbitTemplate) {
    this.queueName = queueName;
    this.rabbitTemplate = rabbitTemplate;
  }

  public void sendProfileViewed(Hero hero) {
    rabbitTemplate.convertAndSend(this.queueName, "Hero profile viewed: " + hero.getName());
  }
}
