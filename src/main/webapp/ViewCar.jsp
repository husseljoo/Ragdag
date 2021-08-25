<%--
  Created by IntelliJ IDEA.
  User: husseljo
  Date: 8/24/21
  Time: 3:31 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>Car Details</title>
  </head>
  <body>

  <div> <%= request.getParameter("brand") %> </div>
  <div> <%= request.getParameter("model") %> </div>
  <div> <%= request.getParameter("year") %> </div>
  <div> <%= request.getParameter("color") %> </div>
  <div> <%= request.getParameter("country") %> </div>

  </body>
</html>
