<%@ page import="java.util.HashMap" %>
<%@ page import="store.DAO" %>
<%@ page import="store.Cart" %>
<%@ page import="store.Product" %>
<%@ page import="java.text.DecimalFormat" %><%--
  Created by IntelliJ IDEA.
  User: urcha
  Date: 5/18/2024
  Time: 3:05 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>Shopping Cart</title>
    </head>
    <body>
        <h1>Shopping Cart</h1>
        <form action="shopingCart" method="post">
            <ul>
                <% HashMap<String,Integer> cart = ((Cart)request.getSession().getAttribute(DAO.CART)).getCart();
                    for(String id: cart.keySet()){%>
                        <%Product item = ((DAO)application.getAttribute(DAO.TAG)).get(id);%>
                        <% if(cart.get(id) > 0){%>
                            <li>

                                <input type="number"  name="<%=item.getID()%>" value="<%=cart.get(id)%>">
                                <label><%=item.getName()%>, <%=item.getPrice()%></label>
                            </li>
                        <%}%>
                <%}%>
            </ul>
            <div>
                <% DecimalFormat numberFormat = new DecimalFormat("#.00");%>
                <label>Total:$<%=numberFormat.format(((Cart)request.getSession().getAttribute(DAO.CART)).getTotalCost())%></label>
                <input type="submit" value="Update Cart" name="update">
            </div>
        </form>
        <a href="shop">Continue Shopping</a>
    </body>
</html>
