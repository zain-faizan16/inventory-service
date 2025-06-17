package com.aion.inventoryservice.repository;

import com.aion.inventoryservice.entity.Inventory;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.UUID;

public interface InventoryRepository extends JpaRepository<Inventory, UUID> {

}
