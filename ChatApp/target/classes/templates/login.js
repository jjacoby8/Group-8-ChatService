function redirect() {
    var value = document.getElementById("usernameBox").value;

    if (value == "admin1" || value == "admin2" || value == "admin3" || value == "admin4" || value == "admin5") {
        document.getElementById("loginButton").setAttribute("href", "landingPageAdmin.html");
    }
    else if (value === "john") {
        document.getElementById("loginButton").setAttribute("href", "landingPageUser.html");
    }
    else return alert("Information is incorrect.");
}