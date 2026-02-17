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

button {
    padding: 12px;
    font-size: 16px;
    border: none;
    border-radius: 5px;
    background-color: #4CAF50;
    color: white;
    cursor: pointer;
    margin-top: 10px;
}

button:hover {
    background-color: #388E3C;
}

.error {
    border: 2px solid red !important;
}

.success {
    border: 2px solid green !important;
}

.error-message {
    color: red;
    font-size: 12px;
    display: none;
}
</style>
</head>
<body>

<form action="status" method="post" onsubmit="return validateSignup(event)">

    <label>First Name</label>
    <input type="text" id="firstName" name="firstName" placeholder="First Name">
    <span id="firstNameError" class="error-message"></span>

    <label>Last Name</label>
    <input type="text" id="lastName" name="lastName" placeholder="Last Name">
    <span id="lastNameError" class="error-message"></span>

    <label>Email</label>
    <input type="email" id="email" name="email" placeholder="Email">
    <span id="emailError" class="error-message"></span>

    <label>Password</label>
    <input type="password" id="password" name="password" placeholder="Password">
    <span id="passwordError" class="error-message"></span>

    <label>Confirm Password</label>
    <input type="password" id="confirmPassword" name="confirmpassword" placeholder="Confirm Password">
    <span id="confirmPasswordError" class="error-message"></span>

    <button type="submit">Sign Up</button>
</form>

<script>
function validateField(inputId) {
    const value = document.getElementById(inputId).value.trim();

    switch(inputId) {
        case 'firstName':
        const nameError=/^[A-Za-z]{5,}$/;
            if (!(nameError).value.length < 5 || /\d/.test(value) ) {
                showError('firstName','firstNameError','First Name: min 5 chars,no numbers,symbols,characters,space');
            } else showSuccess('firstName');
            break;

        case 'lastName':
            if (value.length < 1) showError('lastName','lastNameError','Last Name: at least 1 character');
            else showSuccess('lastName');
            break;

        case 'email':
            if (!value.includes('@gmail.com')) showError('email','emailError','Email must contain @gmail.com');
            else showSuccess('email');
            break;

        case 'password':
            const passwordRegex = /^(?=.*[A-Z])(?=.*\d)(?=.*[!@#$%^&*]).{6,}$/;
            if (!passwordRegex.test(value)) showError('password','passwordError','Password: 1 uppercase, 1 number, 1 symbol');
            else showSuccess('password');
            break;

        case 'confirmPassword':
            const password = document.getElementById('password').value;
            if (value !== password) showError('confirmPassword','confirmPasswordError','Passwords do not match');
            else showSuccess('confirmPassword');
            break;
    }
}

function showError(inputId, errorId, message) {
    const input = document.getElementById(inputId);
    input.classList.add('error');
    input.classList.remove('success');
    const errorEl = document.getElementById(errorId);
    errorEl.textContent = message;
    errorEl.style.display = 'block';
}

function showSuccess(inputId) {
    const input = document.getElementById(inputId);
    input.classList.remove('error');
    input.classList.add('success');
    const errorEl = document.getElementById(inputId + 'Error');
    if (errorEl) errorEl.style.display = 'none';
}

function clearErrors() {
    ['firstName','lastName','email','password','confirmPassword'].forEach(id => {
        const input = document.getElementById(id);
        input.classList.remove('error','success');
        const errorEl = document.getElementById(id+'Error');
        if (errorEl) errorEl.style.display = 'none';
    });
}

// Real-time validation on each field individually
document.querySelectorAll('input').forEach(input => {
    input.addEventListener('input', () => validateField(input.id));
});

// Validate all fields on submit
function validateSignup(event) {
    let isValid = true;
    ['firstName','lastName','email','password','confirmPassword'].forEach(id => {
        validateField(id);
        if (document.getElementById(id).classList.contains('error')) isValid = false;
    });
    if (!isValid) event.preventDefault();
    return isValid;
}
</script>

</body>
</html>
