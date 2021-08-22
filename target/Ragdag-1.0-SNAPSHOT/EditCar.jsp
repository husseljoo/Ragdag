<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%@ page contentType="text/html;charset=UTF-8" language="java" %>
    <html>
    <head>
        <link rel="stylesheet" href="css/register.css">
        <title>Add Car</title>
    </head>
<body>

<form action="EditCarServlet" method="post">
    <div id="login-box">
        <div class="left">
            <h3>Edit Car with id: <%= request.getParameter("edit_car") %> </h3>
            <input type="hidden" name="edit_car" value="<%= request.getParameter("edit_car") %>" />
            <input value="<%= request.getParameter("brand") %>" type="text" name="brand" placeholder="Brand" id="brand" required>
            <input value="<%= request.getParameter("model") %>" type="text" name="model" placeholder="Model" id="model" required>
            <input value="<%= request.getParameter("year") %>" type="text" name="year" placeholder="Year" id="year" required>
            <input value="<%= request.getParameter("country") %>" type="text" name="country" placeholder="Country" id="country" required>
            <input type="submit" name="signup_submit" value="Edit the car" />
        </div>
        <div class="right">
            <h1></h1>
            <input value="<%= request.getParameter("color") %>" type="text" name="color" placeholder="Color" id="color" required>
        </div>
    </div>
</form>


</body>
</html>
