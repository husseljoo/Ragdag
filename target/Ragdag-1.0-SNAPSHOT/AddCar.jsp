<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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

<form action="AddCarServlet" method="post">
    <div id="login-box">
        <div class="left">
            <h1>Add new Car</h1>
            <input type="text" name="brand" placeholder="Brand" id="brand" required>
            <input type="text" name="model" placeholder="Model" id="model" required>
            <input type="text" name="year" placeholder="Year" id="year" required>
            <input type="text" name="country" placeholder="Country" id="country" required>
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
