package store;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;

@WebServlet("/shopingCart")
public class ShopingCartServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Product item;
        try {
            item = ((DAO)request.getServletContext().getAttribute(DAO.TAG)).get(request.getParameter("id"));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        if(null == request.getSession().getAttribute(DAO.CART)){
            request.getSession().setAttribute(DAO.CART, new Cart());
        }
        ((Cart) request.getSession().getAttribute(DAO.CART)).addItem(item);
        request.getRequestDispatcher("cartPage.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Cart cart = ((Cart)request.getSession().getAttribute(DAO.CART));
        DAO db = (DAO)request.getServletContext().getAttribute(DAO.TAG);

        for(String id : cart.getCart().keySet()){
            try {
                if(request.getParameter(id) != null){
                    cart.replaceItemAmount(db.get(id), Integer.parseInt(request.getParameter(id)));
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        request.getRequestDispatcher("cartPage.jsp").forward(request,response);
    }
}
