<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Sign-In</title>
<style>

body {

            height: 100px;
            padding-top:223px;
            display: flex;
            justify-content: center;
            align-items: center;
            background-image: url("resources/images/images (5).jpg");
            background-size: cover;
            background-position: center;
            background-repeat: no-repeat;
        }

        /* Form box */
        form {
            background-color: #ffffff;
            padding: 40px 35px;
            border-radius: 10px;
            width: 320px;
            box-shadow: 0 8px 20px rgba(0, 0, 0, 0.6);
            display: flex;
            flex-direction: column;
            gap: 15px;
        }

        /* Input fields */
             input[type="email"],
             input[type="password"] {
                 padding: 12px;
                 font-size: 14px;
                 border-radius: 5px;
                 border: 1px solid black;

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
<form action="login" method="post">

    <input type="email" name="email" placeholder="Email">

    <input type="password" name="password" placeholder="Password">

    <button type="submit">Sign In</button>
</form>
</body>
</html>