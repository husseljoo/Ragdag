<%--
  Created by IntelliJ IDEA.
  User: husseljo
  Date: 8/19/21
  Time: 5:36 PM
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="css/register.css">
    <title>Add Car</title>
</head>
<body>

<form action="AddCarServlet" method="post">
    <div id="login-box">
        <div class="left">
            <h1>Add new Car</h1>
            <input type="text" name="brand" placeholder="Brand" id="brand"/>
            <input type="text" name="model" placeholder="Model" id="model"/>
            <input type="text" name="year" placeholder="Year" id="year"/>
            <input type="text" name="country" placeholder="Country" id="country"/>
            <input type="submit" name="signup_submit" value="Add the car" />
        </div>
        <div class="right">
            <h1></h1>
            <input type="text" name="color" placeholder="Color" id="color"/>


        </div>
    </div>
</form>


</body>
</html>
