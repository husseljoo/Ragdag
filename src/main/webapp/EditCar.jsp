<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="Helpers.DatabaseConnection" %>
<%@ page import="java.util.List"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="Helpers.QueryProcessor" %>
<%@ page import="Helpers.QueryType" %>
<%@ page import="java.sql.Connection" %>
<%@ page import="java.sql.ResultSet" %>
<html>
<head>
    <%@ page contentType="text/html;charset=UTF-8" language="java" %>
    <html>
    <head>
        <link rel="stylesheet" href="css/register.css">
        <title>Add Car</title>
    </head>
<body>
<%
    Connection connection = null;
    try {
        connection = DatabaseConnection.initializeDatabase();
    } catch (Exception e) {
        e.printStackTrace();
        return;
    }

    String query = "SELECT * FROM Country";
    List<String> parameters = new ArrayList<String>();
    QueryType queryType = QueryType.SELECT;

    QueryProcessor queryProcessor = new QueryProcessor(connection, query, parameters, queryType);
    ResultSet resultSet = queryProcessor.execute();
%>

<form action="EditCarServlet" method="post" enctype="multipart/form-data">
    <div id="login-box">
        <div class="left">
            <h3>Edit Car with id: <%= request.getParameter("edit_car") %> </h3>
            <input type="hidden" name="edit_car" value="<%= request.getParameter("edit_car") %>" />
            <input value="<%= request.getParameter("brand") %>" type="text" name="brand" placeholder="Brand" id="brand" required>
            <input value="<%= request.getParameter("model") %>" type="text" name="model" placeholder="Model" id="model" required>
            <input value="<%= request.getParameter("year") %>" type="text" name="year" placeholder="Year" id="year" required>
            <label for="country">Country:</label>
            <select id="country" name="country" required>
                <option value="<%= request.getParameter("countryCode") %>">
                    <%= request.getParameter("country") %> </option>
                        <%
                        while(resultSet.next()) {
                        String countryName = resultSet.getString("name");
                        String countryCode = resultSet.getString("country_code");
                    %>
                <option value="<%=countryCode %>"><%=countryName %></option>
                <%
                    }
                %>
            </select>

            <%--            <input value="<%= request.getParameter("country") %>" type="text" name="country" placeholder="Country" id="country" required>--%>
            <input type="submit" name="signup_submit" value="Edit the car" />
        </div>
        <div class="right">
            <h1></h1>
            <input value="<%= request.getParameter("color") %>" type="text" name="color" placeholder="Color" id="color" required>
            <label for="upload_image">Upload image</label>
            <input type="file" accept=".jpg" value="Upload image" name="upload_image" id="upload_image">
        </div>
    </div>
</form>


</body>
</html>