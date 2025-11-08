package com.hareen.inventoryservice.service;

import com.hareen.inventoryservice.repository.InventoryRepository;
import lombok.Data;
import org.springframework.stereotype.Service;

@Service
@Data
public class InventoryService {

    private final InventoryRepository inventoryRepository;

    public boolean isInStock(String skuCode, Integer quantity) {
        // Find an inventory for a given skuCode where quantity >= 0
        return inventoryRepository.existsBySkuCodeAndQuantityIsGreaterThanEqual(skuCode, quantity);
    }

}
