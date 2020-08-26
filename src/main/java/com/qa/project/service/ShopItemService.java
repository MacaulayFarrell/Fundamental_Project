package com.qa.project.service;

import com.qa.project.domain.ShopItem;
import com.qa.project.exceptions.ShopItemNotFoundException;
import com.qa.project.repo.ShopItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShopItemService {
    private final ShopItemRepository shopItemRepository;

    @Autowired
    public ShopItemService(ShopItemRepository shopItemRepository) {
        this.shopItemRepository = shopItemRepository;
    }
    public List<ShopItem> viewShopItems() {
        //grabs all notes from table
        return this.shopItemRepository.findAll();
    }
    public ShopItem create(ShopItem shopItem) {
        return this.shopItemRepository.save(shopItem);
    }
    public ShopItem findShopItemById(Long id) {
        return this.shopItemRepository.findById(id).orElseThrow(ShopItemNotFoundException::new);
    }
    public ShopItem update(Long id, ShopItem shopItem) {
        //grab id using method
        ShopItem updateItem = findShopItemById(id);
        //update the values stored
        updateItem.setShopName(shopItem.getShopName());
        updateItem.setItemName(shopItem.getItemName());
        updateItem.setItemCategory(shopItem.getItemCategory());
        updateItem.setQuantity(shopItem.getQuantity());

        // update database with new data
        return this.shopItemRepository.save(updateItem);
    }
    public Boolean deleteNoteById(Long id) {
        //checks if item exists by given id
        if(!this.shopItemRepository.existsById(id)) {
            throw new ShopItemNotFoundException();
        }
        this.shopItemRepository.deleteById(id);
        return this.shopItemRepository.existsById(id);

    }




}
