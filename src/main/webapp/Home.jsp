<%--
  Created by IntelliJ IDEA.
  User: husseljo
  Date: 8/18/21
  Time: 11:12 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Login</title>
</head>
<body>

<h2>Welcome <%= session.getAttribute("first_name") %></h2>
<h2>Role is <%= session.getAttribute("role") %></h2>
<h2>Id is <%= session.getAttribute("id") %></h2>

<div> This is supposed to be the Home page </div>

<form action="CarsServlet" method="get">
    <button type="submit" name="cars" value="OK">view cars</button>
</form>

</body>
</html>
