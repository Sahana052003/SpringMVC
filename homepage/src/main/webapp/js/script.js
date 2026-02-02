
function validateSignup() {

    let password = document.getElementsByName("password")[0].value;
    let confirm = document.getElementsByName("confirmpassword")[0].value;

    if (password !== confirm) {
        alert("Password and Confirm Password must be same");
        return false;
    }

    alert("Signup Successful!");
    return true;
}
