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
        if(pw==null || rpw==null){
            document.getElementById("message").innerHTML = "do not leave empty cells";
            console.log("cells fadia yasta")
        }
        if (pw != rpw) {
            document.getElementById("message").innerHTML = "password do not match";
            console.log("passwords ghalat yasta")
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
            <input type="text" name="username" placeholder="Username" />
            <input type="text" name="email" placeholder="E-mail" />
            <input type="password" name="password" placeholder="Password" id="psswd"/>
            <input type="password" name="password2" placeholder="Retype password" id="rpsswd"/>
            <input type="submit" name="signup_submit" value="Sign me up" />
        </div>
        <div class="right">
            <h1></h1>
            <input type="text" name="first" placeholder="First Name" id="first"/>
            <input type="text" name="last" placeholder="Last Name" id="last"/>
            <label for="R1">Employee</label>
            <input type="Radio" name="Role" id="R1" value="Employee">

            <label for="R2">Manager</label>
            <input type="Radio" name="Role" id="R2" value="Manger">

            <span id = "message" style="color:red"> </span> <br><br>
        </div>
    </div>
</form>


</body>
</html>