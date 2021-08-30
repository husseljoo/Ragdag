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
<style>
    table, th, td {
        border: 1px solid black;
        border-collapse: collapse;
    }
</style>
<body>

<h3> This is the list of all the cars: </h3>

<form action="Home.jsp" method="get">
    <input type="submit" value="Home" name="home">
</form>
<form action="AddCar.jsp" method="get">
    <input type="submit" value="Add" name="add">
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
            <td name="id" value="<%=car.getId()%>"><a href="ViewCarServlet"> <%=car.getId()%> </a></td>
            <td name="brand" value="<%=car.getBrand()%>"><a href="ViewCarServlet"> <%=car.getBrand()%> </a></td>
            <td name="model" value="<%=car.getModel()%>"><%=car.getModel()%></td>
            <td name="year" value="<%=car.getYear()%>"><%=car.getYear()%></td>
            <td name="color" value="<%=car.getColor()%>"><%=car.getColor()%></td>
            <td name="country" value="<%=car.getCountry()%>"><%=car.getCountry()%></td>
            <td>
                <form action="RemoveServlet" method="post">
                    <input type="hidden" name="remove_car" value="<%= car.getId() %>" />
                    <input type="submit" value="Remove" name="remove">
                </form>
            </td>
            <td>
                <form action="EditCar.jsp" method="post">
                    <input type="hidden" name="edit_car" value="<%= car.getId() %>" />
                    <input type="hidden" name="brand" value="<%= car.getBrand() %>" href="CarDetails.jsp"/>
                    <input type="hidden" name="model" value="<%= car.getModel() %>" />
                    <input type="hidden" name="year" value="<%= car.getYear() %>" />
                    <input type="hidden" name="color" value="<%= car.getColor() %>" />
                    <input type="hidden" name="country" value="<%= car.getCountry() %>" />
                    <input type="hidden" name="countryCode" value="<%= car.getCountryCode() %>" />

                    <input type="submit" value="Edit" name="remove">
                </form>
            <td>
                <form action="ViewCar.jsp" method="post">
                    <input type="hidden" name="car_id" value="<%= car.getId() %>" />
                    <input type="hidden" name="brand" value="<%= car.getBrand() %>" href="CarDetails.jsp"/>
                    <input type="hidden" name="model" value="<%= car.getModel() %>" />
                    <input type="hidden" name="year" value="<%= car.getYear() %>" />
                    <input type="hidden" name="color" value="<%= car.getColor() %>" />
                    <input type="hidden" name="country" value="<%= car.getCountry() %>" />

                    <input type="submit" value="View Details" name="details">
                </form>
            </td>
            </td>
        <%
                }
            }
        %>
    </table>

</body>
</html>