package com.hareen.orderservice.client;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.service.annotation.GetExchange;

//@FeignClient(name = "inventory", url = "${inventory.url}")
//public interface InventoryClient {
//
//    @RequestMapping(method = RequestMethod.GET, value = "/api/inventory")
//    Boolean isInStock(@RequestParam String skuCode, @RequestParam Integer quantity);
//}


public interface InventoryClient {

    @GetExchange("/api/inventory")
    Boolean isInStock(@RequestParam String skuCode, @RequestParam Integer quantity);
}
