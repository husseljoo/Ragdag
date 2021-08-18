<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Login</title>
</head>
<body>
<h2><%= "Welcome to the Car Dealership" %></h2>

<form action="LoginServlet" method="post">
    <div class="container">
        <label>Username : </label>
        <input type="text" placeholder="Enter Username" name="username" required />
        <label>Password : </label>
        <input type="password" placeholder="Enter Password" name="password" required />
        <button type="submit" name="login" value="OK">Login</button>
    </div>
</form>

<p>Don't have an account yet?</p>
<form action="Register.jsp">
    <button type="submit" name="register" value="OK">Register</button>
</form>

</body>
</html>