# 🏬 Inventory Service

The **Inventory Service** is responsible for managing product stock levels in real-time within the eCommerce microservices ecosystem.

---

## ✨ Features

- 📦 **List Inventory**: View all product inventory.
- 🔍 **Check Inventory**: Check if a product is in stock.
- ✏️ **Update Inventory**: Modify stock levels manually or programmatically.
- 📥 **Consume Order Events**: Listens to RabbitMQ events when orders are placed.
- 📉 **Auto-Decrease Stock**: Reduces stock levels when a new order is created.
- 📤 **Publish Inventory Status**: (Optional) Sends inventory update events to other services.

---

## 🛠 Tech Stack

- **Java 17**
- **Spring Boot**
- **Spring Data JPA** with **SQL Server**
- **RabbitMQ** for asynchronous event handling

---

## 📦 RabbitMQ Integration

- **Consumes**:  
  `order.created` — Decreases inventory based on the ordered products.

- *(Optional)* **Publishes**:  
  `inventory.updated` — Notifies other services when stock is updated.

---

## 📁 Project Structure (Simplified)

```plaintext
inventory-service/
├── controller/
├── dto/
├── entity/
├── repository/
├── service/
│   ├── InventoryService.java
│   └── impl/InventoryServiceImpl.java
├── config/
├── listener/
├── application.yml
└── InventoryServiceApplication.java
