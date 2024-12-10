package com.geffry.inventory_service.controller;

import com.geffry.inventory_service.service.InventoryService;
import jakarta.websocket.server.PathParam;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/inventory")
@RequiredArgsConstructor
public class InventoryController {

    private final InventoryService inventoryService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public boolean isInStock(
            @PathParam("sku-code") String skuCode){
        return inventoryService.isInStock(skuCode);
    }
}
