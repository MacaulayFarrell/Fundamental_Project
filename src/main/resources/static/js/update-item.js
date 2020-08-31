"use strict";

const updateBtn = document.getElementById("updateItemBtn");

updateBtn.addEventListener("click", function () {

    const id = document.getElementById("updateItemId").value;
    const itemName = document.getElementById("updateItemName").value;
    const itemCategory = document.getElementById("updateItemCategory").value;
    const itemQuantity = document.getElementById("updateItemQuantity").value;


    const req = new XMLHttpRequest();
    const url = "../updateItem/" + id;
    req.open("PUT", url);

    req.setRequestHeader("Content-Type", "application/json;charset=UTF-8");
    let data = { itemName: itemName, itemCategory: itemCategory, itemQuantity: itemQuantity };
    req.send(JSON.stringify(data));



    })