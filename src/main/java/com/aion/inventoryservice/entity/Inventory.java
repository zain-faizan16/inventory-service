package com.aion.inventoryservice.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

import java.util.UUID;

@Entity
@Table(name = "inventory")
@Data
public class Inventory {

    @Id
    private UUID productId;

    private int quantity;
}
