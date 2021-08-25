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
    <link rel="stylesheet" href="css/register.css">
    <title>Add Car</title>
</head>

<script>

    // function validateForm() {
    //     var year = document.getElementById("year").value;
    //     if(isNaN(year){
    //         document.getElementById("message").innerHTML = "passwords do not match";
    //         return false;
    //     }
    //     return true;
    }
</script>

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
    <form action="AddCarServlet" method="post">
        <div id="login-box">
            <div class="left">
            <h1>Add new Car</h1>
            <input type="text" name="brand" placeholder="Brand" id="brand" required>
            <input type="text" name="model" placeholder="Model" id="model" required>
            <input type="text" name="year" placeholder="Year" id="year" required>

                <label for="country">Country:</label>
                <select id="country" name="country" required>
                    <option value="" selected disabled hidden>
                        Select Country
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
<%--            <input type="text" name="country" placeholder="Country" id="country" required>--%>
            <input type="submit" name="signup_submit" value="Add the car"  required>
        </div>
        <div class="right">
            <h1></h1>
            <input type="text" name="color" placeholder="Color" id="color"/>


        </div>
    </div>
</form>


</body>
</html>
