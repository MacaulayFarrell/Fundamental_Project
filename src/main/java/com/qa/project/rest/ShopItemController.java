package com.qa.project.rest;

import com.qa.project.domain.ShopItem;
import com.qa.project.service.ShopItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ShopItemController {
    private final ShopItemService shopItemService;

    @Autowired
    public ShopItemController(ShopItemService shopItemService) {
        this.shopItemService = shopItemService;
    }

    @PostMapping("/createItem")
    public ShopItem createShopItem(@RequestBody ShopItem shopItem) {

        return this.shopItemService.create(shopItem);
    }

    @GetMapping("/readAll")
    public List<ShopItem> getItems() {
        //returns all items
        return this.shopItemService.viewShopItems();
    }

    @PutMapping("/updateItem/{id}")
    public ShopItem updateShopItem(@PathVariable Long id, @RequestBody ShopItem shopItem) {
        return this.shopItemService.update(id, shopItem);
    }

    @DeleteMapping("/deleteItem/{id}")
    public Boolean deleteItem(@PathVariable Long id) {
        return this.shopItemService.delete(id);
    }

    @GetMapping("/GetItemById/{id}")
    public ShopItem getShopItemById(@PathVariable Long id) {
        return this.shopItemService.findShopItemById(id);

    }


}
