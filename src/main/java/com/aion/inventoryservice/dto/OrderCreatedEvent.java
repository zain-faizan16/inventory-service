package com.aion.inventoryservice.dto;

import lombok.Data;

import java.util.List;
import java.util.UUID;

@Data
public class OrderCreatedEvent {
    private UUID orderId;
    private String userEmail;
    private List<OrderItemDto> orderItemDtoList;
}
