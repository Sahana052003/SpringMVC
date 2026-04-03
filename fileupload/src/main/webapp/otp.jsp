<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head><title>OTP</title></head>
<body>
    <p>Debug filePath: ${filePath}</p>

    <c:if test="${not empty error}">
        <p style="color:red;">${error}</p>
    </c:if>

    <form action="verifyOtp" method="post">
        <input type="hidden" name="filePath" value="${filePath}">
        Enter OTP: <input type="text" name="otp">
        <input type="submit" value="Verify">
    </form>
</body>
</html>