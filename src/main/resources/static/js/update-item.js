"use strict";

window.addEventListener("load", function () {
    const request = new XMLHttpRequest();
    const url = "../";

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

            content += '<option value="' + arr[i].id + '">' + "ID: " + arr[i].id + " || Name: " + arr[i].itemName + " || Category: " + arr[i].itemCategory + " || Quantity: " + arr[i].itemQuantity + '</option>';
            document.getElementById("updateItemId").innerHTML = content;

        }

    }



})

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

    window.location.reload(true);




})
