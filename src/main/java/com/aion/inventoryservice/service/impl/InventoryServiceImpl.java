package com.aion.inventoryservice.service.impl;

import com.aion.inventoryservice.dto.OrderCreatedEvent;
import com.aion.inventoryservice.dto.OrderItemDto;
import com.aion.inventoryservice.entity.Inventory;
import com.aion.inventoryservice.repository.InventoryRepository;
import com.aion.inventoryservice.service.InventoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class InventoryServiceImpl implements InventoryService {

    private final InventoryRepository inventoryRepository;

    @Override
    @Transactional
    public void processOrderCreatedEvent(OrderCreatedEvent event) {
        for (OrderItemDto item : event.getOrderItemDtoList()) {
            Inventory inventory = inventoryRepository.findById(item.getProductId())
                    .orElseThrow(() -> new RuntimeException("Product not found: " + item.getProductId()));

            if (inventory.getQuantity() < item.getQuantity()) {
                throw new RuntimeException("Not enough inventory for product: " + item.getProductId());
            }

            inventory.setQuantity(inventory.getQuantity() - item.getQuantity());
            inventoryRepository.save(inventory);
        }

    }
}

