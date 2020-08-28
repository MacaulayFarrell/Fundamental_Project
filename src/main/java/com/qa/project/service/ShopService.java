package com.qa.project.service;

import com.qa.project.domain.Shop;
import com.qa.project.exceptions.ShopNotFoundException;
import com.qa.project.repo.ShopRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ShopService {
    private final ShopRepository shopRepository;
    @Autowired
    public ShopService(ShopRepository shopRepository) {
        this.shopRepository = shopRepository;
    }

    public List<Shop> viewShops() {
        //grabs all notes from table
        return this.shopRepository.findAll();
    }
    public Shop create(Shop shop) {
        return this.shopRepository.save(shop);
    }
    public Shop findShopById(Long id) {
        return this.shopRepository.findById(id).orElseThrow(ShopNotFoundException::new);
    }
    public Shop update(Long id, Shop shop) {

        Shop updateShop = findShopById(id);
        updateShop.setShopName(shop.getShopName());

        return this.shopRepository.save(updateShop);
    }
    public Boolean delete(Long id) {
        //checks if item exists by given id
        if(!this.shopRepository.existsById(id)) {
            throw new ShopNotFoundException();
        }
        this.shopRepository.deleteById(id);
        return this.shopRepository.existsById(id);

    }

}
