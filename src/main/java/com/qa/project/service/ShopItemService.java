package com.qa.project.service;

import com.qa.project.domain.ShopItem;
import com.qa.project.dto.ShopItemDTO;
import com.qa.project.exceptions.ShopItemNotFoundException;
import com.qa.project.repo.ShopItemRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ShopItemService {
    private final ShopItemRepository shopItemRepository;
    private final ModelMapper mapper;

    @Autowired
    public ShopItemService(ShopItemRepository shopItemRepository, ModelMapper mapper) {
        this.shopItemRepository = shopItemRepository;
        this.mapper = mapper;
    }
    private ShopItemDTO mapToDTO(ShopItem shopItem){
        return this.mapper.map(shopItem, ShopItemDTO.class);
    }

    public List<ShopItemDTO> getShopItems(){
        return this.shopItemRepository.findAll().stream().map(this::mapToDTO).collect(Collectors.toList());
    }

    public ShopItemDTO createShopItem(ShopItem shopItem){
        return this.mapToDTO(this.shopItemRepository.save(shopItem));
    }

    public ShopItemDTO findShopItemById(Long id){
        return this.mapToDTO(this.shopItemRepository.findById(id)
                .orElseThrow(ShopItemNotFoundException::new));    }

    public ShopItemDTO updateShopItem(Long id, ShopItem shopItem){
        ShopItem update = this.shopItemRepository.findById(id).orElseThrow(ShopItemNotFoundException::new);
        update.setItemName(shopItem.getItemName());
        update.setItemCategory(shopItem.getItemCategory());
        update.setItemQuantity(shopItem.getItemQuantity());
        return this.mapToDTO(this.shopItemRepository.save(shopItem));
    }

    public Boolean deleteShopItem(Long id){
        if(!this.shopItemRepository.existsById(id)){
            throw new ShopItemNotFoundException();
        }
        this.shopItemRepository.deleteById(id);
        return this.shopItemRepository.existsById(id);
    }




}
