package store;




import org.apache.commons.dbcp2.BasicDataSource;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DAO {
    public static final String TAG = "dataBase";
    public static final String CART = "cart";

    BasicDataSource bds;
    public DAO(BasicDataSource con) throws SQLException {
        bds = con;
    }
    public Product get(String id) throws SQLException {
        Connection connection = bds.getConnection();
        Product prod = null;
        PreparedStatement query = connection.prepareStatement("select * from products where productid = ?");
        query.setString(1, id);

        ResultSet rs = query.executeQuery();
        while(rs.next()){
            prod = new Product(
                    rs.getString("productid"),
                    rs.getString("name"),
                    rs.getString("imagefile"),
                    rs.getDouble("price")
            );}
        connection.close();
        return prod;
    }
    public ArrayList<Product> selectAll() throws SQLException {
        Connection connection = bds.getConnection();
        ArrayList<Product> store = new ArrayList<>();
        try {
            PreparedStatement query = connection.prepareStatement("select * from products");
            query.executeQuery();
            ResultSet resultSet = query.getResultSet();
            while (resultSet.next()){
                Product prod = new Product(
                        resultSet.getString("productid"),
                        resultSet.getString("name"),
                        resultSet.getString("imagefile"),
                        resultSet.getDouble("price")
                );
                store.add(prod);
            }
        } catch (SQLException e) {throw new RuntimeException(e);}
        connection.close();
        return store;
    }
}
