package store;

import junit.framework.TestCase;

import java.util.HashMap;
import java.util.Optional;

public class CartTester extends TestCase{

    public void testAdd(){
        Cart cart = new Cart();
        Product apple = new Product("2", "apple", "null", 3.25);
        Product pear = new Product("1", "pear", "null", 2.5);
        HashMap<String, Integer> c = cart.getCart();
        assertTrue(c.isEmpty());
        cart.addItem(pear);
        c = cart.getCart();
        Integer sup = 1;
        assertEquals(sup, c.get(pear.getID()));
        cart.addItem(pear);
        c = cart.getCart();
        sup = 2;
        assertEquals(sup, c.get(pear.getID()));
        assertEquals(pear.getPrice()*2, cart.getTotalCost());

    }

    public void testReplaceAmount(){
        Cart cart = new Cart();
        Product pear = new Product("1", "pear", "null", 2.5);

        cart.addItem(pear);
        HashMap<String, Integer> c = cart.getCart();
        Integer sup = 1;
        assertEquals(sup, c.get(pear.getID()));
        assertEquals(pear.getPrice(), cart.getTotalCost());

        cart.replaceItemAmount(pear, 8);
        c = cart.getCart();
        sup = 8;
        assertEquals(sup, c.get(pear.getID()));
        assertEquals(pear.getPrice()*8, cart.getTotalCost());

        cart.replaceItemAmount(pear, 0);
        c = cart.getCart();
        sup = 0;
        assertEquals(sup, c.get(pear.getID()));
        double z = 0;
        assertEquals(z, cart.getTotalCost());

    }

}
