package org.vlko.dota.service;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;
import org.vlko.dota.persistence.entity.Hero;

@Service
public class MessagingService {
  private final Queue queue;
  private final RabbitTemplate rabbitTemplate;

  public MessagingService(RabbitTemplate rabbitTemplate, Queue queue) {
    this.queue = queue;
    this.rabbitTemplate = rabbitTemplate;
  }

  public void sendProfileViewed(Hero hero) {
    rabbitTemplate.convertAndSend(queue.getName(), "Hero profile viewed: " + hero.getName());
  }

}
