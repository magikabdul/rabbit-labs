package cloud.cholewa.rabbit.lab.sending;

import cloud.cholewa.rabbit.lab.notification.NotificationConfig;
import cloud.cholewa.rabbit.lab.producer.MessageProducer;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@RequiredArgsConstructor
@Configuration
public class Sender {

    @Bean
    CommandLineRunner runner(
        NotificationConfig config,
        MessageProducer producer
    ) {
        return args ->
            producer.publish(
                "foo",
                config.getInternalExchanges(),
                config.getInternalNotificationRoutingKey()
            );
    }
}
