package com.qa.project.dto;

import java.util.ArrayList;
import java.util.List;

public class ShopDTO {

    private long id;
    private String shopName;
    private List<ShopItemDTO> shops = new ArrayList<>();

    public ShopDTO() {

    }
    public ShopDTO(String shopName) {
        super();
        this.shopName = shopName;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }

    public List<ShopItemDTO> getShops() {
        return shops;
    }

    public void setShops(List<ShopItemDTO> shops) {
        this.shops = shops;
    }


}
