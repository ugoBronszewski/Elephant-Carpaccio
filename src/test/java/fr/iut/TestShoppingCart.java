package fr.iut;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;

public class TestShoppingCart {

    @Test
    public void addItem() {
        final ShoppingCart shoppingCart = new ShoppingCart();
        final Item carrot = new Item("Carrot", 2.5);
        shoppingCart.addItem(carrot, 1);

        Assert.assertEquals(shoppingCart.getContent(), new HashMap<Item, Integer>() {{
            put(carrot, 1);
        }});
    }

    @Test
    public void computePriceWithoutTaxes() {
        final ShoppingCart shoppingCart = new ShoppingCart();
        final Item carrot = new Item("Carrot", 2.5);
        shoppingCart.addItem(carrot, 1);

        Assert.assertEquals(shoppingCart.getPriceWithoutTaxes(), 2.5, 0.0001);
    }
}
