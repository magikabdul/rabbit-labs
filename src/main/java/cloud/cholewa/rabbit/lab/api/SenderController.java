package cloud.cholewa.rabbit.lab.api;

import cloud.cholewa.rabbit.lab.notification.NotificationConfig;
import cloud.cholewa.rabbit.lab.producer.MessageProducer;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@Slf4j
@RestController
@RequiredArgsConstructor
public class SenderController {

    private final MessageProducer producer;
    private final NotificationConfig notificationConfig;

    @GetMapping
    Mono<ResponseEntity<String>> publishMessage(@RequestParam String message) {
        return Mono.fromRunnable(() -> producer.publish(
                message,
                notificationConfig.getInternalExchanges(),
                notificationConfig.getInternalNotificationRoutingKey()
            ))
            .then(Mono.just(ResponseEntity.ok().build()));
    }
}
