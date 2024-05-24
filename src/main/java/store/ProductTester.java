package store;

import junit.framework.TestCase;

public class ProductTester extends TestCase {

    public void testOverall(){
        double num = 0.999;
        Product prod = new Product("id", "name", "image", num);
        assertEquals("id", prod.getID());
        assertEquals("name", prod.getName());
        assertEquals("image", prod.getimage());
        assertEquals(0.999, prod.getPrice());
    }
}
