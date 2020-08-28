package com.qa.project.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Shop {
    @Id
    @GeneratedValue
    private long id;
    @Column
    private String shopName;
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler", "shops"})
    @OneToMany(mappedBy = "shops", fetch = FetchType.EAGER)
    private List<ShopItem> shops = new ArrayList<>();

    public Shop() {

    }

    public Shop(String shopName) {
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

    public List<ShopItem> getShops() {
        return shops;
    }

    public void setShops(List<ShopItem> shops) {
        this.shops = shops;
    }


}

