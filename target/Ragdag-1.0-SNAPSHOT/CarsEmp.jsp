<%--
  Created by IntelliJ IDEA.
  User: husseljo
  Date: 8/18/21
  Time: 1:09 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List"%>
<%@page import="java.util.Iterator"%>
<%@ page import="Helpers.Car" %>


<% List<Car> carsList = (List<Car>) request.getAttribute("cars_list"); %>

<html>
<head>
    <title>Car Page</title>
</head>
<body>

<h3> This is the list of all the cars: </h3>

<form action="AddCar.jsp" method="post">
    <input type="submit" value="Add" name="remove">
</form>

<table cellspacing="4" cellpadding="4">
    <tr>
        <th>ID</th>
            <th>Brand</th>
            <th>Model</th>
            <th>Year</th>
            <th>Color</th>
            <th>Country</th>
            </th>

        </tr>
        <%
            // Iterating through subjectList

            if(request.getAttribute("cars_list") != null)
            {
                Iterator<Car> iterator = carsList.iterator();
                while(iterator.hasNext()){
                    Car car = iterator.next();
        %>
        <tr>
            <td><%=car.getId()%></td>
            <td><%=car.getBrand()%></td>
            <td><%=car.getModel()%></td>
            <td><%=car.getYear()%></td>
            <td><%=car.getColor()%></td>
            <td><%=car.getCountry()%></td>
            <td>
                <form action="RemoveServlet" method="post">
                    <input type="hidden" name="remove_car" value="<%= car.getId() %>" />
                    <input type="submit" value="Remove" name="remove">
                </form>
            </td>
            <td>
                <form action="EditCar.jsp" method="post">
                    <input type="hidden" name="edit_car" value="<%= car.getId() %>" />
                    <input type="hidden" name="brand" value="<%= car.getBrand() %>" />
                    <input type="hidden" name="model" value="<%= car.getModel() %>" />
                    <input type="hidden" name="year" value="<%= car.getYear() %>" />
                    <input type="hidden" name="color" value="<%= car.getColor() %>" />
                    <input type="hidden" name="country" value="<%= car.getCountry() %>" />

                    <input type="submit" value="Edit" name="remove">
                </form>
            </td>
        <%
                }
            }
        %>
    </table>

</body>
</html>