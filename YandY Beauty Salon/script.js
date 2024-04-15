document.addEventListener("DOMContentLoaded", function () {
  // Toggle Login Box Visibility
  document
    .querySelector('nav a[href="#"]')
    .addEventListener("click", function () {
      document.querySelector(".login-box").classList.toggle("visible");
    });

  // Form Submission Validation
  document.querySelector("form").addEventListener("submit", function (event) {
    const username = document.querySelector('input[name="username"]').value;
    const password = document.querySelector('input[name="password"]').value;

    if (!username || !password) {
      event.preventDefault();
      alert("Please fill in both username and password.");
    }
  });

  // Smooth Scrolling to Sections
  document.querySelectorAll("nav a").forEach((anchor) => {
    anchor.addEventListener("click", function (e) {
      e.preventDefault();

      document.querySelector(this.getAttribute("href")).scrollIntoView({
        behavior: "smooth",
      });
    });
  });

  // Fetch and Display Services Dynamically
  document
    .querySelector('nav a[href="#services"]')
    .addEventListener("click", function () {
      // Replace the following with your actual API endpoint or data source
      fetch("services.json")
        .then((response) => response.json())
        .then((data) => {
          console.log(data);
          // Update the DOM with the fetched data if needed
        })
        .catch((error) => console.error("Error fetching services:", error));
    });
});
