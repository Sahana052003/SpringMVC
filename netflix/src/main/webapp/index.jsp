<%@ page isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
    <title>Netflix Registration</title>

    <style>
        body {
            background-color: black;
            color: white;
            font-family: Arial, sans-serif;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
        }

        .container {
            background-color: rgba(0,0,0,0.85);
            padding: 30px;
            width: 400px;
            border-radius: 8px;
        }

        h2 {
            text-align: center;
            color: #e50914;
        }

        input, select {
            width: 100%;
            padding: 10px;
            margin-top: 5px;
            margin-bottom: 10px;
            border-radius: 4px;
            border: none;
        }

        .radio-group {
            margin-bottom: 10px;
        }

        button {
            width: 100%;
            padding: 10px;
            background-color: #e50914;
            color: white;
            border: none;
            font-weight: bold;
            cursor: pointer;
        }

        .error {
            color: red;
            font-size: 13px;
        }

        .error-border {
            border: 2px solid red;
        }

        .success-border {
            border: 2px solid green;
        }
    </style>
</head>

<body>

<div class="container">

    <h2>NETFLIX</h2>

   <c:if test="${not empty information}">
       <h3 style="color:${color}; text-align:center;">
           ${information}
       </h3>
   </c:if>

   <form action="login" method="post" onsubmit="return validateForm()">

       <label>Full Name</label>
       <input type="text" id="name" name="name">
       <div id="nameError" class="error"></div>

       <label>Email</label>
       <input type="email" id="email" name="email">
       <div id="emailError" class="error"></div>

       <label>Password</label>
       <input type="password" id="password" name="password">
       <div id="passwordError" class="error"></div>

       <label>Mobile Number</label>
       <input type="text" id="mobile" name="mobile">
       <div id="mobileError" class="error"></div>

       <label>Gender</label>
       <div class="radio-group">
           <input type="radio" name="gender" value="Male"> Male
           <input type="radio" name="gender" value="Female"> Female
           <input type="radio" name="gender" value="Other"> Other
       </div>
       <div id="genderError" class="error"></div>

       <label>Subscription Plan</label>
       <select id="plan" name="plan">
           <option value="">Choose Plan</option>
           <option>Basic</option>
           <option>Standard</option>
           <option>Premium</option>
       </select>
       <div id="planError" class="error"></div>

       <button type="submit">Register</button>

   </form>
   </div>

<script>

function validateForm() {

    let valid = true;

    const name = document.getElementById("name");
    const email = document.getElementById("email");
    const password = document.getElementById("password");
    const mobile = document.getElementById("mobile");
    const plan = document.getElementById("plan");
    const gender = document.querySelector('input[name="gender"]:checked');

    const nameRegex = /^[A-Za-z ]{3,}$/;
    const emailRegex = /^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$/;
    const passwordRegex = /^(?=.*[A-Z])(?=.*\d)(?=.*[@#$%^&+=!]).{6,}$/;
    const mobileRegex = /^[6-9]\d{9}$/;

    // Clear previous errors
    document.querySelectorAll(".error").forEach(e => e.innerText = "");
    document.querySelectorAll("input, select").forEach(e => {
        e.classList.remove("error-border","success-border");
    });

    // Name validation
    if (!nameRegex.test(name.value.trim())) {
        showError(name,"nameError","Enter valid name (min 3 letters)");
        valid = false;
    } else showSuccess(name);

    // Email validation
    if (!emailRegex.test(email.value.trim())) {
        showError(email,"emailError","Enter valid email");
        valid = false;
    } else showSuccess(email);

    // Password validation
    if (!passwordRegex.test(password.value.trim())) {
        showError(password,"passwordError",
        "Password: 1 uppercase, 1 number, 1 special char");
        valid = false;
    } else showSuccess(password);

    // Mobile validation
    if (!mobileRegex.test(mobile.value.trim())) {
        showError(mobile,"mobileError",
        "Mobile must be 10 digits starting 6-9");
        valid = false;
    } else showSuccess(mobile);

    // Gender validation
    if (!gender) {
        document.getElementById("genderError")
        .innerText = "Select gender";
        valid = false;
    }

    // Plan validation
    if (plan.value === "") {
        document.getElementById("planError")
        .innerText = "Select a plan";
        valid = false;
    } else showSuccess(plan);

    return valid;
}

function showError(input,errorId,message){
    input.classList.add("error-border");
    document.getElementById(errorId).innerText = message;
}

function showSuccess(input){
    input.classList.add("success-border");
}

</script>

</body>
</html>