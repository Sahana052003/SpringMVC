function validatePassportForm() {

    let name = document.getElementById("name").value.trim();
    let email = document.getElementById("email").value.trim();
    let password = document.getElementById("password").value.trim();
    let phoneNumber = document.getElementById("phoneNumber").value.trim();
    let gender = document.getElementById("gender").value.trim();
    let nationality = document.getElementById("nationality").value.trim();
    let address = document.getElementById("address").value.trim();
    let country = document.getElementById("country").value.trim();
    let pincode = document.getElementById("pincode").value.trim();
    let state = document.getElementById("state").value.trim();
    if (name.length <= 3 || name.length > 20) {
        alert("Must have only name length between 3-20  ");
        return false;
    }
    if (!email.includes("@") || !email.includes(".")) {
        alert("Please enter a valid email");
        return false;
    }
    let pwd = parseInt(password);
    if (isNaN(pwd) || pwd < 1000 || pwd > 999999) {
        alert("Password range is  1000 and 999999");
        return false;
    }
    if (phoneNumber.length !== 10 || isNaN(phoneNumber)) {
        alert("Phonenumber must be in 10 digits");
        return false;
    }
    if (gender === "") {
        alert("Gender is required");
        return false;
    }
    if (nationality === "") {
        alert("Nationality is required");
        return false;
    }
    if (address === "") {
        alert("Address is required");
        return false;
    }
    if (country === "") {
        alert("Country is required");
        return false;
    }
    if (pincode.length !== 6 || isNaN(pincode)) {
        alert("Pincode must be 6 digits");
        return false;
    }
    if (state === "") {
        alert("State is required");
        return false;
    }
   alert("Submitted");
    return true;
}
