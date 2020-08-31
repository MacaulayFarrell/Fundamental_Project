"use strict";

const createBtn = document.getElementById("createItemBtn");

createBtn.addEventListener("click", function () {

    const itemName = document.getElementById("createItemName").value;
    const itemCategory = document.getElementById("createItemCategory").value;
    const itemQuantity = document.getElementById("createItemQuantity").value;

    const req = new XMLHttpRequest();
    req.open("POST", "../createItem");

    req.setRequestHeader("Content-Type", "application/json;charset=UTF-8");
    let data = { itemName: itemName, itemCategory: itemCategory, itemQuantity: itemQuantity };
    req.send(JSON.stringify(data));


})