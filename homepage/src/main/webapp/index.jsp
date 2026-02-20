<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Home-Page</title>
 <style>

 /* body */
        body {
            background-color: white;
            color: white;
            background-image: url("resources/images/pexels-pixabay-459203.jpg");
            background-size: cover;
            background-position: center;
            background-repeat: no-repeat;
            height: 700px;

            display: flex;
            justify-content: center;
            align-items: flex-start;
            padding-top: 50px;

        }

        /* Navbar section */
        .navbar {
            width: 100%;
            background: black;
            padding: 15px 0;
            box-shadow: 0 6px 12px rgba(0,0,0,0.1);
            position: fixed;
            top: 0;
            left: 0;
        }

        /* Navbar container */
        .nav-container {
            width: 90%;
            max-width: 1200px;
            margin: 0 auto;
            display: flex;
            justify-content: flex-end;
            gap: 20px;
        }

        /* Buttons */
        .btn {
            padding: 12px 28px;
            border: none;
            border-radius: 30px;
            font-size: 16px;
            cursor: pointer;
            color: black;
            font-weight: 600;

        }

        /* Signup button */
        .signup {
            background-color:purple;
        }

        /* Signin button */
        .signin {
            background-color:cream;
        }
</style>
</head>
<body>

    <nav class="navbar">
        <div class="nav-container">
            <form action="signup" method="post">
                <button type="submit" class="btn signup">Sign Up</button>
            </form>
            <form action="signin" method="post">
                <button type="submit" class="btn signin">Sign In</button>
            </form>
        </div>
    </nav>
</body>
</html>
