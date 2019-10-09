package fr.iut;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

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

    public double getPriceWithoutTaxes() {
        return cart.entrySet()
                .stream()
                .map(x -> x.getKey().getPrice() * x.getValue())
                .collect(Collectors.summingDouble(Double::doubleValue));
    }

    public Double getPriceWithTaxes(Countries country) {
        return getPriceWithoutTaxes() * country.getTaxToApply();
    }
}
