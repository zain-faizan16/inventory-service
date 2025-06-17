package com.aion.inventoryservice.configuration;

import com.aion.inventoryservice.dto.OrderCreatedEvent;
import com.aion.inventoryservice.service.InventoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class OrderEventListener {

    private final InventoryService inventoryService;

    @RabbitListener(queues = "${rabbitmq.queue}")
    public void listen(OrderCreatedEvent event) {
        inventoryService.processOrderCreatedEvent(event);
    }
}
