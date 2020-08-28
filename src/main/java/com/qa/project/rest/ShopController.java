package com.qa.project.rest;

import com.qa.project.domain.Shop;
import com.qa.project.service.ShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ShopController {

    private final ShopService shopService;

    @Autowired
    public ShopController(ShopService shopService) {
        this.shopService = shopService;
    }
    @PostMapping("/createShop")
    public Shop createShop(@RequestBody Shop shop) {

        return this.shopService.create(shop);
    }

    @GetMapping("/getShops")
    public List<Shop> getShops() {
        return this.shopService.viewShops();
    }

    @PutMapping("/updateShop/{id}")
    public Shop updateShop(@PathVariable Long id, @RequestBody Shop shop) {
        return this.shopService.update(id, shop);
    }

    @DeleteMapping("/deleteShop/{id}")
    public Boolean deleteShop(@PathVariable Long id) {
        return this.shopService.delete(id);
    }

    @GetMapping("/GetShopById/{id}")
    public Shop getShopItemById(@PathVariable Long id) {
        return this.shopService.findShopById(id);

    }



}
