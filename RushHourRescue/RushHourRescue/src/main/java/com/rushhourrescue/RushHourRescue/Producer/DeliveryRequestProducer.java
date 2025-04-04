package com.rushhourrescue.RushHourRescue.Producer;

import com.rushhourrescue.RushHourRescue.Entity.UserRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class DeliveryRequestProducer {
    @Autowired
    private KafkaTemplate<String, UserRequest> kafkaTemplate;

    public void sendRequest (UserRequest request) {
        Message<UserRequest> message = MessageBuilder.withPayload(request)
                                .setHeader(KafkaHeaders.TOPIC, "delivery-request")
                                .build();
        log.info("Sending message to delivery-request topic:: {}", request);
        kafkaTemplate.send("delivery-request", request);
    }
}
