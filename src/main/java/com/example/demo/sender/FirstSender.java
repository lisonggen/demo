package com.example.demo.sender;

import com.example.demo.config.RabbitMqConfig;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class FirstSender {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    /**
     * 发送消息
     * @param uuid
     * @param message  消息
     */
    public void send(String uuid,Object message) {
        CorrelationData correlationId = new CorrelationData(uuid);
        /**
         * RabbitMqConfig.EXCHANGE  指定消息交换机
         * RabbitMqConfig.ROUTINGKEY2  指定队列key2
         */
        rabbitTemplate.convertAndSend(RabbitMqConfig.EXCHANGE, RabbitMqConfig.ROUTINGKEY1,
                message, correlationId);

        //rabbitTemplate.convertAndSend(RabbitMqConfig.ROUTINGKEY1, message);

    }

}
