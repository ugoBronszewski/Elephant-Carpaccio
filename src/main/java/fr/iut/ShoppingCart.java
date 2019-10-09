package fr.iut;

import java.util.HashMap;
import java.util.Map;

public class ShoppingCart {

    private Map<Item, Integer> cart = new HashMap<Item, Integer>();

    public void addItem(final Item item, final int quantity) {
        cart.put(item, quantity);
    }

    public Map<Item, Integer> getContent() {
        final Map<Item, Integer> copies = new HashMap<Item, Integer>();
        copies.putAll(cart);

        return copies;
    }
}
