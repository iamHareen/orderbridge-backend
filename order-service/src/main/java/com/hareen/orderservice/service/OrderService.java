package com.hareen.orderservice.service;

import com.hareen.orderservice.client.InventoryClient;
import com.hareen.orderservice.dto.OrderRequest;
import com.hareen.orderservice.model.Order;
import com.hareen.orderservice.repository.OrderRepository;
import lombok.Data;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@Data
public class OrderService {

    private final OrderRepository orderRepository;
    private final InventoryClient inventoryClient;

    public void placeOrder(OrderRequest orderRequest) {

        var isInStock = inventoryClient.isInStock(orderRequest.skuCode(), orderRequest.quantity());
        if (isInStock) {
            // map OrderRequest to Order object
            Order order = new Order();
            order.setOrderNumber(UUID.randomUUID().toString());
            order.setPrice(orderRequest.price());
            order.setSkuCode(orderRequest.skuCode());
            order.setQuantity(orderRequest.quantity());
            // save order to orderRepository
            orderRepository.save(order);
        } else {
            throw new RuntimeException("Product with skuCode " + orderRequest.skuCode() + " is not in stock");
        }

    }
}
