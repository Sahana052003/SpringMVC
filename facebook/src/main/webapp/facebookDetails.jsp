<%@ page isELIgnored="false" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>FaceBook Details</title>
</head>
<body>
    <form action="update" method="post" >



        <label>ID</label>
        <input type="number" class="form-control" id="id" name="id" value="${info.id}" readonly>
    
        <!-- Name -->
        <div class="mb-3">
            <label>Name</label>
            <input type="text" class="form-control" id="name" name="name" value="${info.name}">
            <div id="nameError" class="error"></div>
        </div>
    
        <!-- Email -->
        <div class="mb-3">
            <label>Email</label>
            <input type="email" class="form-control" id="email" name="email" value="${info.email}" readonly>
            <div id="emailError" class="error"></div>
        </div>
    
        <!-- Password -->
        <div class="mb-3">
            <label>Password</label>
            <input type="password" class="form-control" id="password" name="password" value="${info.password}">
            <div id="passwordError" class="error"></div>
        </div>
    
        <!-- Phone -->
        <div class="mb-3">
            <label>Mobile Number</label>
            <input type="text" class="form-control" id="phoneNumber" name="phoneNumber" value="${info.phoneNumber}" readonly>
            <div id="phoneError" class="error"></div>
        </div>
    
        <!-- Gender -->
        <div class="mb-3">
            <label>Gender</label><br>
            <input type="radio" name="gender" value="Male" > Male
            <input type="radio" name="gender" value="Female" >Female
            <input type="radio" name="gender" value="Other" > Other
            <div id="genderError" class="error"></div>
        </div>
    
        <!-- Country -->
        <div class="mb-3">
            <label>Country</label>
            <select class="form-select" id="country" name="country">
                <option>${info.country}</option>
                <option>India</option>
                <option>South Korea</option>
                <option>Japan</option>
                <option>UK</option>
            </select>
            <div id="countryError" class="error"></div>
        </div>

    <button>Edit</button>
    </form>


</script>
</body>
</html>