package store;



import org.apache.commons.dbcp2.BasicDataSource;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
import java.sql.SQLException;

@WebListener
public class ContextListener implements ServletContextListener, HttpSessionListener {
    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        BasicDataSource basicDataSource = new BasicDataSource();
        basicDataSource.setUrl("jdbc:mysql://localhost:3306/store");
        basicDataSource.setUsername("root");
        basicDataSource.setPassword("rootroot");
        try {
            DAO Db = new DAO(basicDataSource);
            servletContextEvent.getServletContext().setAttribute(DAO.TAG, Db);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {

    }
    @Override
    public void sessionCreated(HttpSessionEvent httpSessionEvent) {
        Cart cart = new Cart();
        httpSessionEvent.getSession().setAttribute(DAO.CART, cart);
    }
    @Override
    public void sessionDestroyed(HttpSessionEvent httpSessionEvent) {
        httpSessionEvent.getSession().removeAttribute(DAO.CART);
    }
}
