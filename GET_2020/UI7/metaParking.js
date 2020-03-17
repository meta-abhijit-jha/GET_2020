var empId = document.getElementById("fullName");
empId.addEventListener("keydown", function(e) {
    if (e.keyCode === 13) {
        var regName = /^[a-zA-Z]+ [a-zA-Z]+$/;
        var title = document.getElementById("fullName").value;
        if (regName.test(title)) {
            document.getElementById("nameDiv").style.display = "none";
            document.getElementById("queryText").innerHTML = "Email?"
            document.getElementById("emailDiv").style.display = "block";
        } else {
            document.getElementById("nameSpan").innerHTML = "Please enter Full Name";
        }
    }
});

var emailId = document.getElementById("email");
emailId.addEventListener("keydown", function(e) {
    if (e.keyCode === 13) {
        var regEmail = /^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/;
        var email = document.getElementById("email").value;
        if (regEmail.test(email)) {
            document.getElementById("emailDiv").style.display = "none";
            document.getElementById("queryText").innerHTML = "password?";
            document.getElementById("passwordDiv").style.display = "block";
        } else {
            document.getElementById("emailSpan").innerHTML = "Please enter correct email-id";
        }
    }
});


var passId = document.getElementById("password");
passId.addEventListener("keydown", function(e) {
    if (e.keyCode === 13) {
        var regPassword = /^(?=.*\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[^a-zA-Z0-9])(?!.*\s).{8,15}$/;
        var password = document.getElementById('password').value;
        if (regPassword.test(password)) {
            document.getElementById("queryText").innerHTML = "password again?";
            document.getElementById("passwordDiv").style.display = "none";
            document.getElementById("confirmPassDiv").style.display = "block";
        } else {
            document.getElementById("passSpan").innerHTML = "Please enter Alphanumeric password and also include atleast one symbol, length should be between 8-15 characters";
        }
    }
});

var confirmId = document.getElementById("passwordTwo");
confirmId.addEventListener("keydown", function(e) {
    if (e.keyCode === 13) {
        var password = document.getElementById('password').value;
        var confirmPassword = document.getElementById('passwordTwo').value;
        if (password == confirmPassword) {
            document.getElementById("queryText").innerHTML = "contact number?";
            document.getElementById("confirmPassDiv").style.display = "none";
            document.getElementById("contactNoDiv").style.display = "block";
        } else {
            document.getElementById("passTwoSpan").innerHTML = "Password and Confirm password do not match";
        }
    }
});

var contactId = document.getElementById("contactNo");
contactId.addEventListener("keydown", function(e) {
    if (e.keyCode === 13) {
        var contact = document.getElementById('contactNo').value;
        var regContact = /^[0][1-9]\d{9}$|^[1-9]\d{9}$/;
        if (regContact.test(contact)) {
            document.getElementById("queryText").innerHTML = "gender?";
            document.getElementById("contactNoDiv").style.display = "none";
            document.getElementById("genderDiv").style.display = "block";
        } else {
            document.getElementById("contactSpan").innerHTML = "Please Enter Correct Mobile Number";
        }
    }
});

function submit() {
    document.getElementById("genderDiv").style.display = "none";
    document.getElementById("vehicleTypeDiv").style.display = "block";
    document.getElementById("queryText").innerHTML = "vehicle type?";
}

function selectVehicle(value) {
    var vehicleType = value;
    document.getElementById("queryText").innerHTML = "vehicle model name?";
    document.getElementById("vehicleTypeDiv").style.display = "none";
    document.getElementById("vehicleNameDiv").style.display = "block";

}

var vehicleName = document.getElementById("vehicleName");
vehicleName.addEventListener("keydown", function(e) {
    if (e.keyCode === 13) {
        document.getElementById("queryText").innerHTML = "vehicle number?";
        document.getElementById("vehicleNameDiv").style.display = "none";
        document.getElementById("vehicleNumDiv").style.display = "block";
    }
});

var vehicleNum = document.getElementById("vehicleNum");
vehicleNum.addEventListener("keydown", function(e) {
    if (e.keyCode === 13) {
        document.getElementById("queryText").innerHTML = "employee ID?";
        document.getElementById("vehicleNumDiv").style.display = "none";
        document.getElementById("empIdDiv").style.display = "block";
    }
});

var employeeId = document.getElementById("empId");
employeeId.addEventListener("keydown", function(e) {
    if (e.keyCode === 13) {
        document.getElementById("queryText").innerHTML = "vehicle's identity?";
        document.getElementById("empIdDiv").style.display = "none";
        document.getElementById("identityDiv").style.display = "block";
    }
});

var identity = document.getElementById("identity");
identity.addEventListener("keydown", function(e) {
    if (e.keyCode === 13) {
        document.getElementById("canIKnowText").style.display = "none";
        document.getElementById("queryText").style.display = "none";
        document.getElementById("identityDiv").innerHTML = "Passes Price";
        var vehicleType = document.getElementById("typeSelect").value;
        document.getElementById(vehicleType).style.display = "block";
    }
});

function getPass(value) {
    var vehicleType = document.getElementById("typeSelect").value;
    document.getElementById(vehicleType).style.display = "none";
    document.getElementById("identityDiv").innerHTML = "Choose Currency";
    document.getElementById("moneyTypeDiv").style.display = "block";
}

function convert(currency) {
    var vehicleType = document.getElementById("typeSelect").value;
    if (vehicleType == "car") {
        var amount = document.getElementById("carSelect").value;
    }
    if (vehicleType == "bike") {
        var amount = document.getElementById("bikeSelect").value;
    }
    if (vehicleType == "bus") {
        var amount = document.getElementById("busSelect").value;
    }

    if (currency == "inr") {
        finalAmount = amount;
    }
    if (currency == "usd") {
        finalAmount = amount * 0.013;
    }
    if (currency == "yen") {
        finalAmount = amount * 1.41;
    }
    document.getElementById("ticketPrice").style.display = "none";
    document.getElementById("ticketPrice").innerHTML = "Your Bill is " + finalAmount + currency;
    document.getElementById("btn").style.display = "block";
}

function generatePass() {
    document.getElementById("btn").style.display = "none";
    document.getElementById("ticketPrice").style.display = "block";
}