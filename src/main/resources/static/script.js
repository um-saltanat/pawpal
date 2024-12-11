// Get the form element
const registerForm = document.getElementById("registerForm");

// Handle form submission
registerForm.addEventListener("submit", function(event) {
    event.preventDefault(); // Prevent the form from reloading the page

    // Get the form data
    const username = document.getElementById("username").value;
    const password = document.getElementById("password").value;

    // Create the user object to send to the backend
    const user = {
        username: username,
        password: password
    };

    // Send the POST request to the backend's /register endpoint
    axios.post('http://localhost:8080/register', user)
        .then(response => {
            alert("Registration successful!");
            // Optionally, redirect to login page or another page
        })
        .catch(error => {
            console.error("There was an error registering the user!", error);
            alert("Registration failed.");
        });
});
// Get the login form element
const loginForm = document.getElementById("loginForm");

// Handle form submission
loginForm.addEventListener("submit", function(event) {
    event.preventDefault(); // Prevent the form from reloading the page

    // Get the form data
    const username = document.getElementById("loginUsername").value;
    const password = document.getElementById("loginPassword").value;

    // Create the user object to send to the backend
    const user = {
        username: username,
        password: password
    };

    // Send the POST request to the backend's /login endpoint
    axios.post('http://localhost:8080/login', user)
        .then(response => {
            // Store the JWT token in localStorage
            localStorage.setItem('token', response.data.token);
            alert("Login successful!");

            // Redirect to a new page or update UI for authenticated user
            window.location.href = "home.html"; // Or update UI for logged-in state
        })
        .catch(error => {
            console.error("There was an error logging in!", error);
            alert("Login failed.");
        });
});
// Get the token from localStorage
const token = localStorage.getItem('token');

// Function to fetch and display data
function fetchData(endpoint) {
    axios.get(`http://localhost:8080/${endpoint}`, {
        headers: {
            Authorization: `Bearer ${token}`
        }
    })
        .then(response => {
            const contentDiv = document.getElementById("content");
            contentDiv.innerHTML = JSON.stringify(response.data, null, 2);
        })
        .catch(error => {
            console.error("Error fetching data", error);
            alert("You are not authorized to access this data.");
        });
}

// Set up event listeners for the tabs
document.getElementById("petsTab").addEventListener("click", function() {
    fetchData("pets");
});

document.getElementById("missingPetsTab").addEventListener("click", function() {
    fetchData("missingPets");
});

document.getElementById("articlesTab").addEventListener("click", function() {
    fetchData("articles");
});
