package com.qa.project.rest;

import com.qa.project.domain.Shop;
import com.qa.project.dto.ShopDTO;
import com.qa.project.service.ShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
public class ShopController {

    private final ShopService shopService;

    @Autowired
    public ShopController(ShopService shopService) {
        this.shopService = shopService;
    }

    @GetMapping("/getShops")
    public ResponseEntity<List<ShopDTO>> getShops(){
        return ResponseEntity.ok(this.shopService.getShops());
    }

    @PostMapping("/createShop")
    public ResponseEntity<ShopDTO> createShop(@RequestBody Shop shop){
        return new ResponseEntity<ShopDTO>(this.shopService.createShop(shop), HttpStatus.CREATED);
    }

    @PutMapping("/updateShop/{id}")
    public ResponseEntity<ShopDTO> updateShop(@PathVariable Long id, @RequestBody Shop shop){
        return ResponseEntity.ok(this.shopService.updateShop(id, shop));
    }

    @DeleteMapping("/deleteShop/{id}")
    public Boolean deleteShop(@PathVariable Long id){
        return this.shopService.deleteShop(id);
    }

    @GetMapping("/getShopById/{id}")
    public ResponseEntity<ShopDTO> getShopById(@PathVariable Long id){
        return ResponseEntity.ok(this.shopService.findShopById(id));
    }


}
