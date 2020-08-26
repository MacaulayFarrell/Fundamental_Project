package com.qa.project.domain;

import javax.persistence.*;

@Entity
@Table(name="ShopItem")

@SecondaryTable(name="Quantity",
        pkJoinColumns={
                @PrimaryKeyJoinColumn(name="item_id")})

public class ShopItem {
    //table 1
    @Id
    @GeneratedValue
    @Column(name = "item_id")
    private long id;
    @Column(name = "shop_name")
    private String shopName;
    @Column(name = "item_name")
    private String itemName;
    @Column(name = "item_category")
    private String itemCategory;

    //table 2

    @Column(name = "item_quantity", table = "Quantity")
    private long quantity;

    public ShopItem() {
    }

    public ShopItem(String shopName, String itemName, String itemCategory, long quantity) {
        this.shopName = shopName;
        this.itemName = itemName;
        this.itemCategory = itemCategory;
        this.quantity = quantity;
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

    public long getQuantity() {
        return quantity;
    }

    public void setQuantity(long quantity) {
        this.quantity = quantity;
    }
}
