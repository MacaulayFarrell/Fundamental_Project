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
    @OneToMany(mappedBy = "shop", fetch = FetchType.LAZY)
    private List<ShopItem> notes = new ArrayList<>();

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

    public List<ShopItem> getNotes() {
        return notes;
    }

    public void setNotes(List<ShopItem> notes) {
        this.notes = notes;
    }



}

