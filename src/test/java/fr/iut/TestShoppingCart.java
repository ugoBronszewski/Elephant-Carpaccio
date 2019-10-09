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

        Assert.assertEquals(new HashMap<Item, Integer>() {{
            put(carrot, 1);
        }}, shoppingCart.getContent());
    }

    @Test
    public void computePriceWithoutTaxes() {
        final ShoppingCart shoppingCart = new ShoppingCart();
        final Item carrot = new Item("Carrot", 2.5);
        shoppingCart.addItem(carrot, 1);
        shoppingCart.addItem(new Item("Apple", 1), 25);
        shoppingCart.addItem(new Item("Bananas 1kg", 5), 3);

        Assert.assertEquals(42.5, shoppingCart.getPriceWithoutTaxes(), 0.0001);
    }

    @Test
    public void computePriceWithTaxes() {
        final ShoppingCart shoppingCart = new ShoppingCart();
        final Item carrot = new Item("Carrot", 2.5);
        shoppingCart.addItem(carrot, 1);
        shoppingCart.addItem(new Item("Apple", 1), 25);
        shoppingCart.addItem(new Item("Bananas 1kg", 5), 3);

        Assert.assertEquals(51, shoppingCart.getPriceWithTaxes(Countries.France), 0.0001);
    }

    @Test
    public void IslandTaxes() {
        final ShoppingCart shoppingCart = new ShoppingCart();
        final Item carrot = new Item("Carrot", 2.5);
        shoppingCart.addItem(carrot, 1);
        shoppingCart.addItem(new Item("Apple", 1), 25);
        shoppingCart.addItem(new Item("Bananas 1kg", 5), 3);

        Assert.assertEquals(42.5 * Countries.Island.getTaxToApply(), shoppingCart.getPriceWithTaxes(Countries.Island), 0.0001);
    }

    @Test
    public void SuisseTaxes() {
        final ShoppingCart shoppingCart = new ShoppingCart();
        final Item carrot = new Item("Carrot", 2.5);
        shoppingCart.addItem(carrot, 1);
        shoppingCart.addItem(new Item("Apple", 1), 25);
        shoppingCart.addItem(new Item("Bananas 1kg", 5), 3);

        Assert.assertEquals(42.5 * Countries.Suisse.getTaxToApply(), shoppingCart.getPriceWithTaxes(Countries.Suisse), 0.0001);
    }

    @Test
    public void CroatieTaxes() {
        final ShoppingCart shoppingCart = new ShoppingCart();
        final Item carrot = new Item("Carrot", 2.5);
        shoppingCart.addItem(carrot, 1);
        shoppingCart.addItem(new Item("Apple", 1), 25);
        shoppingCart.addItem(new Item("Bananas 1kg", 5), 3);

        Assert.assertEquals(42.5 * Countries.Croatie.getTaxToApply(), shoppingCart.getPriceWithTaxes(Countries.Croatie), 0.0001);
    }

    @Test
    public void DanemarkTaxes() {
        final ShoppingCart shoppingCart = new ShoppingCart();
        final Item carrot = new Item("Carrot", 2.5);
        shoppingCart.addItem(carrot, 1);
        shoppingCart.addItem(new Item("Apple", 1), 25);
        shoppingCart.addItem(new Item("Bananas 1kg", 5), 3);

        Assert.assertEquals(42.5 * Countries.Danemark.getTaxToApply(), shoppingCart.getPriceWithTaxes(Countries.Danemark), 0.0001);
    }

    @Test
    public void AllemagneTaxes() {
        final ShoppingCart shoppingCart = new ShoppingCart();
        final Item carrot = new Item("Carrot", 2.5);
        shoppingCart.addItem(carrot, 1);
        shoppingCart.addItem(new Item("Apple", 1), 25);
        shoppingCart.addItem(new Item("Bananas 1kg", 5), 3);

        Assert.assertEquals(42.5 * Countries.Allemagne.getTaxToApply(), shoppingCart.getPriceWithTaxes(Countries.Allemagne), 0.0001);
    }

    @Test
    public void getPriceWithDiscountForLessThan1000() {
        final ShoppingCart shoppingCart = new ShoppingCart();
        final Item carrot = new Item("Carrot", 2.5);
        shoppingCart.addItem(carrot, 1);
        shoppingCart.addItem(new Item("Apple", 1), 25);
        shoppingCart.addItem(new Item("Bananas 1kg", 5), 3);

        Assert.assertEquals(42.5, shoppingCart.getPriceDiscount(), 0.0001);
    }

    @Test
    public void getPriceWithDiscountForMoreOrEqualThan50000() {
        final ShoppingCart shoppingCart = new ShoppingCart();
        shoppingCart.addItem(new Item("Apple", 1), 51000);

        Assert.assertEquals(51000 * .85, shoppingCart.getPriceDiscount(), 0.0001);
    }

    @Test
    public void getPriceWithDiscountForBetwen10000And50000() {
        final ShoppingCart shoppingCart = new ShoppingCart();
        shoppingCart.addItem(new Item("Apple", 1), 45000);

        Assert.assertEquals(45000 * .9, shoppingCart.getPriceDiscount(), 0.0001);
    }
}
