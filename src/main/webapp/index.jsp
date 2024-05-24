<%@ page import="java.util.ArrayList" %>
<%@ page import="store.Product" %>
<%@ page import="store.DAO" %>
<html>
    <head>
        <title>
            Student Store
        </title>
    </head>
    <body>
        <h1>Student Store</h1>
        <h5>Items available:</h5>
        <ul>
            <% ArrayList<Product> store = ((DAO)application.getAttribute(DAO.TAG)).selectAll();
                for(Product item : store){%>
                <li>
                    <a href="product?id=<%=item.getID()%>"><%=item.getName()%></a>
                </li>
            <%}%>
        </ul>
    </body>
</html>
