/* 
   Lakeland Reeds Bed and Breakfast menu toggle script 
   Filename: script.js
   HTML5 and CSS3 Illustrated Unit I, Lessons
 */

var navButton = document.querySelector(".navigation-menu-button img");
if (navButton.addEventListener) {
   navButton.addEventListener("click", function() {
      var nav = document.querySelector(".sitenavigation ul");
      if (nav.style.display === "block") {
         nav.style.display = "";
      } else {
         nav.style.display = "block";
      }
   }, false);
}