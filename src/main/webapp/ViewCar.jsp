<%--
  Created by IntelliJ IDEA.
  User: husseljo
  Date: 8/24/21
  Time: 3:31 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.io.File"%>
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

<%
      String imagePath = "/home/husseljo/IdeaProjects/demo/Ragdag/src/main/webapp/images/"+request.getParameter("car_id")+".jpg";
      System.out.println(imagePath);
      File tmpDir = new File(imagePath);
      boolean fileExists = tmpDir.exists();
%>
    <% if (fileExists) { %>
        <img src="<%=request.getContextPath()%>/images/<%=request.getParameter("car_id")%>.jpg" width="400" height="300">
    <% } else { %>
        <div>No image exists yet for this car!</div>
    <% } %>

</body>
</html>

