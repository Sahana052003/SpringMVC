<!DOCTYPE html>
<html>
<head>
    <title>Facebook Registration</title>

    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css"
          rel="stylesheet">

    <style>
        body {
            background: #f0f2f5;
            height: 100vh;
            display: flex;
            justify-content: center;
            align-items: center;
        }

        .register-box {
            background: white;
            padding: 30px;
            width: 450px;
            border-radius: 10px;
            box-shadow: 0px 4px 20px rgba(0,0,0,0.1);
        }

        .error {
            color: red;
            font-size: 13px;
        }

        .error-border {
            border: 2px solid red !important;
        }

        .success-border {
            border: 2px solid green !important;
        }

        .msg {
            text-align: center;
            font-weight: bold;
        }
    </style>
</head>

<body>

<div class="register-box">

    <h3 class="text-center mb-4 text-primary">Facebook Registration</h3>

    <form action="register" method="post" onsubmit="return validateForm()">

        <!-- Name -->
        <div class="mb-3">
            <label>Name</label>
            <input type="text" class="form-control" id="name" name="name">
            <div id="nameError" class="error"></div>
        </div>

        <!-- Email -->
        <div class="mb-3">
            <label>Email</label>
            <input type="email" class="form-control" id="email" name="email">
            <div id="emailError" class="error"></div>
        </div>

        <!-- Password -->
        <div class="mb-3">
            <label>Password</label>
            <input type="password" class="form-control" id="password" name="password">
            <div id="passwordError" class="error"></div>
        </div>

        <!-- Phone -->
        <div class="mb-3">
            <label>Mobile Number</label>
            <input type="text" class="form-control" id="phoneNumber" name="phoneNumber">
            <div id="phoneError" class="error"></div>
        </div>

        <!-- Gender -->
        <div class="mb-3">
            <label>Gender</label><br>
            <input type="radio" name="gender" value="Male"> Male
            <input type="radio" name="gender" value="Female"> Female
            <input type="radio" name="gender" value="Other"> Other
            <div id="genderError" class="error"></div>
        </div>

        <!-- Country -->
        <div class="mb-3">
            <label>Country</label>
            <select class="form-select" id="country" name="country">
                <option value="">Select Country</option>
                <option>India</option>
                <option>South Korea</option>
                <option>Japan</option>
                <option>UK</option>
            </select>
            <div id="countryError" class="error"></div>
        </div>

        <button type="submit" class="btn btn-primary w-100">
            Register
        </button>

    </form>
</div>

<script>

function validateField(id) {

    const value = document.getElementById(id)?.value.trim();

    switch(id) {

        case 'name':
            const nameRegex = /^[A-Za-z ]{3,}$/;
            if (!nameRegex.test(value))
                showError('name','nameError',
                'Name must be minimum 3 letters');
            else
                showSuccess('name');
            break;

        case 'email':
            const emailRegex =
            /^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$/;
            if (!emailRegex.test(value))
                showError('email','emailError',
                'Enter valid email');
            else
                showSuccess('email');
            break;

        case 'password':
            const passwordRegex =
            /^(?=.*[A-Z])(?=.*\d)(?=.*[@#$%^&+=!]).{6,}$/;
            if (!passwordRegex.test(value))
                showError('password','passwordError',
                'Password: 1 uppercase, 1 number, 1 special char');
            else
                showSuccess('password');
            break;

        case 'phoneNumber':
            const phoneRegex = /^[6-9]\d{9}$/;
            if (!phoneRegex.test(value))
                showError('phoneNumber','phoneError',
                'Mobile must be 10 digits starting 6-9');
            else
                showSuccess('phoneNumber');
            break;

        case 'country':
            if (value === '')
                showError('country','countryError',
                'Select country');
            else
                showSuccess('country');
            break;
    }
}

function validateGender() {
    const gender = document.querySelector(
        'input[name="gender"]:checked');
    if (!gender) {
        document.getElementById("genderError")
        .innerText = "Select gender";
        return false;
    } else {
        document.getElementById("genderError")
        .innerText = "";
        return true;
    }
}

function showError(inputId, errorId, message) {
    const input = document.getElementById(inputId);
    if(input){
        input.classList.add('error-border');
        input.classList.remove('success-border');
    }
    document.getElementById(errorId).innerText = message;
}

function showSuccess(inputId) {
    const input = document.getElementById(inputId);
    if(input){
        input.classList.remove('error-border');
        input.classList.add('success-border');
    }
    const error = document.getElementById(inputId+'Error');
    if(error) error.innerText = "";
}

document.querySelectorAll('input, select')
.forEach(input => {
    input.addEventListener('input', () =>
        validateField(input.id));
});

function validateForm() {

    let valid = true;

    ['name','email','password',
     'phoneNumber','country']
    .forEach(id => {
        validateField(id);
        if(document.getElementById(id)
        .classList.contains('error-border'))
        valid = false;
    });

    if(!validateGender())
        valid = false;

    return valid;
}

</script>

</body>
</html>