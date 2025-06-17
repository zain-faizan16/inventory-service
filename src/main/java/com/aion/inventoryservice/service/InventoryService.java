package com.aion.inventoryservice.service;

import com.aion.inventoryservice.dto.OrderCreatedEvent;

public interface InventoryService {
    void processOrderCreatedEvent(OrderCreatedEvent event);
}