"use strict";

const deleteBtn = document.getElementById("deleteBtn");

deleteBtn.addEventListener("click", function () {
    const id = document.getElementById("deleteItemId").value;
    const req = new XMLHttpRequest();
    const url = "../deleteItem/" + id;
    req.open("DELETE", url);
    req.setRequestHeader("Content-Type", "application/json;charset=UTF-8");
    req.send();


})