<%--
  Created by IntelliJ IDEA.
  User: husseljo
  Date: 8/16/21
  Time: 3:04 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="css/register.css">
    <title>Title</title>
</head>
<script>
    //client side form validation for performance
    function validateForm() {
        var pw = document.getElementById("psswd").value;
        var rpw = document.getElementById("rpsswd").value;

        if(pw != rpw){
            document.getElementById("message").innerHTML = "passwords do not match";
            return false;
        }
        return true;
    }

</script>
<body>

<form onsubmit="return validateForm()" action="RegisterServlet" method="post">
    <div id="login-box">
        <div class="left">
            <h1>Register</h1>
            <input type="text" name="username" placeholder="Username" id="username" required>
            <input type="email" name="email" placeholder="E-mail" id="email" required>
            <input type="password" name="password" placeholder="Password" id="psswd" required>
            <input type="password" name="password2" placeholder="Retype password" id="rpsswd" required>
            <input type="submit" name="signup_submit" value="Sign me up" />
        </div>
        <div class="right">
            <h1></h1>
            <input type="text" name="first" placeholder="First Name" id="first"/>
            <input type="text" name="last" placeholder="Last Name" id="last"/>

            <label for="R1">Employee</label>
            <input type="Radio" name="role" id="R1" value="emp" required>

            <label for="R2" required>Manager</label>
            <input type="Radio" name="role" id="R2" value="man" required>


            <div>
                <span id = "message" style="color:red"> </span> <br><br>
            </div>

        </div>
    </div>
</form>


</body>
</html>