<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>
<body>

<form action="verifyOtp" method="post">
    <input type="hidden" name="filePath" value="${filePath}">

    Enter OTP:
    <input type="text" name="otp">

    <input type="submit" value="Verify">
</form>

</body>
</html>