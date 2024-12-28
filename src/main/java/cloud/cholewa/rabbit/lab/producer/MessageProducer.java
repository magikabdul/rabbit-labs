package cloud.cholewa.rabbit.lab.producer;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class MessageProducer {

    private final AmqpTemplate amqpTemplate;

    public void publish(Object payload, String exchange, String routingKey) {
        log.info("Publishing message to exchange {} with routingKey {}", exchange, routingKey);
        amqpTemplate.convertAndSend(exchange, routingKey, payload);
    }
}
