package com.qa.project.domain;

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

    @OneToMany(mappedBy = "shops", fetch = FetchType.LAZY)
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

