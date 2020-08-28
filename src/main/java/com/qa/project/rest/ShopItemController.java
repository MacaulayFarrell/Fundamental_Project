package com.qa.project.rest;

import com.qa.project.domain.ShopItem;
import com.qa.project.dto.ShopItemDTO;
import com.qa.project.service.ShopItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ShopItemController {
    private final ShopItemService shopItemService;

    @Autowired
    public ShopItemController(ShopItemService shopItemService) {
        this.shopItemService = shopItemService;
    }

    @GetMapping("/")
    public ResponseEntity<List<ShopItemDTO>> getShopItems(){
        return ResponseEntity.ok(this.shopItemService.getShopItems());
    }

    @PostMapping("/createItem")
    public ResponseEntity<ShopItemDTO> createShopItem(@RequestBody ShopItem shopItem){
        return new ResponseEntity<ShopItemDTO>(this.shopItemService.createShopItem(shopItem), HttpStatus.CREATED);
    }
    @PutMapping("/updateItem/{id}")
    public ResponseEntity<ShopItemDTO> updateShopItem(@PathVariable Long id, @RequestBody ShopItem shopItem){
        return ResponseEntity.ok(this.shopItemService.updateShopItem(id, shopItem));
    }

    @DeleteMapping("/deleteItem/{id}")
    public ResponseEntity<?> deleteShopItem(@PathVariable Long id){
        return this.shopItemService.deleteShopItem(id)
                ? ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build()
                : ResponseEntity.noContent().build();
    }

    @GetMapping("/getItemById/{id}")
    public ResponseEntity<ShopItemDTO> getShopItemById(@PathVariable Long id){
        return ResponseEntity.ok(this.shopItemService.findShopItemById(id));

    }


}
