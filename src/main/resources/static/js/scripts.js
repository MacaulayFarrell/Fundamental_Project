"use strict";
//Variable declarations
const menuNav = document.getElementById("menu-main");
const menuToggle = document.getElementById("mobile-button");

//Hamburger navigation
//add event listener to menu
menuToggle.addEventListener("click", toggleMenu);

function toggleMenu() {
  //toggle between showing and hiding the menu
  menuNav.classList.toggle("displayMenu");
  
}