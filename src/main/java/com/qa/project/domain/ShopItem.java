package com.qa.project.domain;

import javax.persistence.*;

@Entity
public class ShopItem {
    //table 1
    @Id
    @GeneratedValue
    private long id;
    @Column
    private String itemName;
    @Column
    private String itemCategory;
    @Column
    private long itemQuantity;
    @ManyToOne(targetEntity = Shop.class)
    private Shop shops;

    public ShopItem() {
    }

    public ShopItem(String itemName, String itemCategory, long itemQuantity) {
        this.itemName = itemName;
        this.itemCategory = itemCategory;
        this.itemQuantity = itemQuantity;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getItemCategory() {
        return itemCategory;
    }

    public void setItemCategory(String itemCategory) {
        this.itemCategory = itemCategory;
    }
    public long getItemQuantity() {
        return itemQuantity;
    }

    public void setItemQuantity(long itemQuantity) {
        this.itemQuantity = itemQuantity;
    }
    public Shop getShop() {
        return shops;
    }

    public void setShop(Shop shop) {
        this.shops = shop;
    }


}
