package com.qa.project.service;

import com.qa.project.domain.Shop;
import com.qa.project.dto.ShopDTO;
import com.qa.project.exceptions.ShopNotFoundException;
import com.qa.project.repo.ShopRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ShopService {
    private final ShopRepository shopRepository;
    private final ModelMapper mapper;

    @Autowired
    public ShopService(ShopRepository shopRepository, ModelMapper mapper) {
        this.shopRepository = shopRepository;
        this.mapper = mapper;
    }

    private ShopDTO mapToDTO(Shop shop){
        return this.mapper.map(shop, ShopDTO.class);
    }

    public List<ShopDTO> getShops(){
        return this.shopRepository.findAll().stream().map(this::mapToDTO).collect(Collectors.toList());
    }

    public ShopDTO createShop(Shop shop){
        return this.mapToDTO(this.shopRepository.save(shop));
    }

    public ShopDTO findShopById(Long id){
        return this.mapToDTO(this.shopRepository.findById(id).orElseThrow(ShopNotFoundException::new));
    }

    public ShopDTO updateShop(Long id, Shop shop){
        Shop update = this.shopRepository.findById(id).orElseThrow(ShopNotFoundException::new);
        update.setShopName(shop.getShopName());
        return this.mapToDTO(this.shopRepository.save(update));
    }

    public Boolean deleteShop(Long id){
        if(!this.shopRepository.existsById(id)){
            throw new ShopNotFoundException();
        }
        this.shopRepository.deleteById(id);
        return this.shopRepository.existsById(id);
    }

}
