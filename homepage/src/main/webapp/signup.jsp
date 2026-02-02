<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Sign-Up</title>
<style>
body {
            height: 100vh;
            margin: 0;
            display: flex;
            justify-content: center;
            align-items: center;
    }

        /* Form box */
        form {
            background-color: rgba(255, 255, 255, 0.95);
            padding: 40px 35px;
            border-radius: 12px;
            width: 350px;
            box-shadow: 0 10px 25px rgba(0, 0, 0, 0.6);
            display: flex;
            flex-direction: column;
            gap: 15px;
        }
        /* Inputs */
        input {
            padding: 12px;
            font-size: 14px;
            border-radius: 5px;
            border: 1px solid #ccc;
            outline: none;
            transition: 0.3s;
        }

        input:focus {
            border-color: #4CAF50;
        }

        /* Button */
        button {
            padding: 12px;
            font-size: 16px;
            border: none;
            border-radius: 5px;
            background-color: #4CAF50;
            color: white;
            cursor: pointer;
            transition: 0.3s;
            margin-top: 10px;
        }

        button:hover {
            background-color: #388E3C;
        }

</style>
</head>
<body>
    
<form action="status" method="post" onsubmit="return validateSignup()">

    <input type="text" name="firstName" placeholder="First Name">

    <input type="text" name="lastName" placeholder="Last Name">

    <input type="email" name="email" placeholder="Email">

    <input type="password" name="password" placeholder="Password">

    <input type="password" name="confirmpassword" placeholder="Confirm Password">

    <button type="submit">Sign Up</button>
</form>
<script src="js/script.js"></script>
</body>
</html>