package com.rushhourrescue.RushHourRescue.Consumer;

import com.rushhourrescue.RushHourRescue.Entity.UserRequest;
import com.rushhourrescue.RushHourRescue.Service.DeliveryService;
import com.rushhourrescue.RushHourRescue.Service.UserRequestService;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.converter.StringJsonMessageConverter;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class DeliveryRequestConsumer {
    @Autowired
    private DeliveryService service;
    @Autowired
    private UserRequestService requestService;


    @KafkaListener(topics = "delivery-request", groupId = "dispatcher-group", containerFactory = "kafkaListenerContainerFactory")
    @Transactional
    public void consumeDeliveryRequest(UserRequest request) {
        service.assignNextAvailableRiderToNextRequest(request);
        System.out.println("Processing delivery request: " + request.toString());


    }
    
}
