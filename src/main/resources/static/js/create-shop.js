"use strict";
const createShopBtn = document.getElementById("createShopBtn");

createShopBtn.addEventListener("click", function() {
    const shopName = document.getElementById("createShopName").value;

    const req = new XMLHttpRequest();
    req.open("POST", "../createShop");

    req.setRequestHeader("Content-Type", "application/json;charset=UTF-8");

    let data = {shopName: shopName};
    req.send(JSON.stringify(data));
    location.reload();



})