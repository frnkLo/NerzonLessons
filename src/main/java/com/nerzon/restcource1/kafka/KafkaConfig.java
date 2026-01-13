package com.nerzon.restcource1.kafka;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration //для распознавания бинов
public class KafkaConfig {

    @Bean
    public NewTopic newTopic() { //при помощи этого топика консьюмер и продюссер налаживают соединение
        return new NewTopic(
                "course",
                1,  //топик разделен на партиции, кот мб разбросаны по разным брокерам (за это отвеч replication factor).
                                // партиции нужны для сохранности данных и для паралеллизации. Хранят копии сообщений
                (short) 1
        );
    }
}
