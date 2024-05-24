<%@ page import="store.DAO" %>
<%@ page import="store.Product" %><%--
  Created by IntelliJ IDEA.
  User: urcha
  Date: 5/17/2024
  Time: 6:40 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <% Product item = ((DAO)application.getAttribute(DAO.TAG)).get(request.getParameter("id"));  %>
  <title><%=item.getName()%></title>
</head>
<body>
    <h1><%=item.getName()%></h1>
    <img src="store-images/<%=item.getimage()%>" alt="<%=item.getName()%>">
    <form action="shopingCart" method="get">
        <div class="container" style="margin-bottom: 20px;">
            <label>$<%=item.getPrice()%></label>
            <input name="id" type="hidden" value="<%=item.getID()%>"/>
            <input type="submit" name="buy" value="Add to Cart">
        </div>
    </form>
</body>
</html>
