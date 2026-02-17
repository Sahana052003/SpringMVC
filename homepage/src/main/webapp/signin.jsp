<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Sign-In</title>
<style>
body {
    height: 100vh;
    display: flex;
    justify-content: center;
    align-items: center;
    background-image: url("resources/images/pexels-felix-mittermeier-956981.jpg");
    background-size: cover;
    background-position: center;
    font-family: Arial, sans-serif;
}

form {
    background-color: rgba(255,255,255,0.95);
    padding: 40px 35px;
    border-radius: 12px;
    width: 350px;
    box-shadow: 0 10px 25px rgba(0,0,0,0.6);
    display: flex;
    flex-direction: column;
    gap: 10px;
}

input[type="email"],
input[type="password"] {
    padding: 12px;
    font-size: 14px;
    border-radius: 5px;
    border: 1px solid #ccc;
    outline: none;
}

input:focus {
    border-color: #4CAF50;
}

button {
    padding: 12px;
    font-size: 16px;
    border: none;
    border-radius: 5px;
    background-color: #4CAF50;
    color: white;
    cursor: pointer;
}

button:hover {
    background-color: #388E3C;
}

#errorMessage {
    color: red;
    font-size: 14px;
    text-align: center;
    display: none; /* hide initially */
}
</style>
</head>
<body>

<form action="login" method="post" >
    <h2 style="text-align:center;">Sign In</h2>

    <!-- Error message -->
    <div id="errorMessage">Invalid Email or Password</div>

    <input type="email" name="email" placeholder="Email" required>
    <input type="password" name="password" placeholder="Password" required>

    <button type="submit">Sign In</button>
</form>

<script>

</script>

</body>
</html>
