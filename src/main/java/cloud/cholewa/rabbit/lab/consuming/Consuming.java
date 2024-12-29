package cloud.cholewa.rabbit.lab.consuming;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class Consuming {

    @RabbitListener(queues = "${rabbitmq.queue.notification}")
    public void consume(String message) {
        log.info("Consumed message from queue: [{}]", message);
    }
}
