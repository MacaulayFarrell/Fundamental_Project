package com.qa.project.dto;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ShopDTOTest {
    @Test
    public void testShopDTO() {
        ShopDTO test1 = new ShopDTO();
        ShopDTO test2 = new ShopDTO("KFC");

        test1.setId(1);
        test2.setId(2);
        assertEquals(test1.getId(), 1);
        test1.setShopName("shop");
        assertEquals(test1.getShopName(), "shop");


    }

}
