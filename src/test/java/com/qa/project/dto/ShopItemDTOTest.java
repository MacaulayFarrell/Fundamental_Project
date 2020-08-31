package com.qa.project.dto;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ShopItemDTOTest {
    @Test
    public void testShopItemDTO() {
        ShopItemDTO one = new ShopItemDTO();
        ShopItemDTO two = new ShopItemDTO("Choc", "Food", 5);

        assertEquals(two.getItemName(), "Choc");
        assertEquals(two.getItemCategory(), "Food");
        assertEquals(two.getItemQuantity(), 5);

        one.setId(1);
        assertEquals(one.getId(), 1);

        one.setItemName("Water");
        one.setItemCategory("drinks");
        one.setItemQuantity(25);
    }
}
