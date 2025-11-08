package com.hareen.inventoryservice.controller;

import com.hareen.inventoryservice.service.InventoryService;
import lombok.Data;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/inventory")
@Data
public class InventoryController {

    private final InventoryService inventoryService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public boolean isInStock(@RequestParam String skuCode, Integer quantity) {
        return inventoryService.isInStock(skuCode, quantity);
    }
}
