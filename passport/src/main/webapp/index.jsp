<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Passport-Registeration</title>
</head>
<body>
    <form action="login" method="post" onsubmit="return validatePassportForm()">
<input type="text" id="name" name="name" placeholder="Enter your name">
<input type="email" id="email" name="email" placeholder="Enter your email">
<input type="password" id="password" name="password" placeholder="Enter your password">
<input type="number" id="phoneNumber" name="phoneNumber" placeholder="Enter mobile number">
<input type="text" id="gender" name="gender" placeholder="Enter your gender">
<input type="text" id="nationality" name="nationality" placeholder="Nationality">
<input type="text" id="address" name="address" placeholder="Address">
<input type="text" id="country" name="country" placeholder="Country">
<input type="number" id="pincode" name="pincode" placeholder="Pin-code">
<input type="text" id="state" name="state" placeholder="State">

        <button type="submit">Submit</button>
    </form>
    <script src="script.js"></script>
</body>
</html>
