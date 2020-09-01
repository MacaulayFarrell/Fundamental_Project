"use strict";

const createBtn = document.getElementById("createItemBtn");
const shop = document.getElementById("shops");

window.addEventListener("load", function () {
    const request = new XMLHttpRequest();
    const url = "../getShops";

    request.onreadystatechange = function() {
        if (this.readyState == 4 && this.status == 200) {
            const myArr = JSON.parse(this.responseText);
            myFunction(myArr);

        }

    };

    request.open("GET", url);
    request.send();

    function myFunction(arr) {

        let content = "";
        let i;
        for(i = 0; i < arr.length; i++) {

            content += '<option value="' + arr[i].id + '">' + arr[i].shopName + '</option>';

            document.getElementById("shops").innerHTML = content;

        }

    }



})


createBtn.addEventListener("click", function () {

    const itemName = document.getElementById("createItemName").value;
    const itemCategory = document.getElementById("createItemCategory").value;
    const itemQuantity = document.getElementById("createItemQuantity").value;
    const shopSelector = document.getElementById("shops").value;


    const req = new XMLHttpRequest();
    req.open("POST", "../createItem");

    req.setRequestHeader("Content-Type", "application/json;charset=UTF-8");
    if(shopSelector != null) {
        let data = {
            itemName: itemName, itemCategory: itemCategory, itemQuantity: itemQuantity, shop: {
                id: shopSelector
            }
        };
        req.send(JSON.stringify(data));
    }
    else {
        let data = {itemName: itemName, itemCategory: itemCategory, itemQuantity: itemQuantity};
        req.send(JSON.stringify(data));
    }


})