package store;

import junit.framework.TestCase;
import org.apache.commons.dbcp2.BasicDataSource;

import java.sql.SQLException;
import java.util.ArrayList;

public class DAOTester extends TestCase {
    DAO db;

    @Override
    protected void setUp() throws Exception {
        BasicDataSource basicDataSource = new BasicDataSource();
        basicDataSource.setUrl("jdbc:mysql://localhost:3306/store");
        basicDataSource.setUsername("root");
        basicDataSource.setPassword("rootroot");
        db = new DAO(basicDataSource);
    }

    public void testGet() throws SQLException {
        Product hd = db.get("HC");
        assertEquals("HC", hd.getID());
        assertEquals("Classic Hoodie", hd.getName());
        assertEquals("Hoodie.jpg", hd.getimage());
        double price= 40;
        assertEquals(price, hd.getPrice());
    }

    public void testSelectAll() throws SQLException {
        ArrayList<Product> lst = db.selectAll();
        double price= 40;
        assertEquals("HC", lst.get(0).getID());
        assertEquals("Classic Hoodie",lst.get(0).getName());
        assertEquals("Hoodie.jpg", lst.get(0).getimage());
        assertEquals(price, lst.get(0).getPrice());
        assertEquals(lst.size(), 14);
    }
}
