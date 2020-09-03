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

            document.getElementById("deleteItemId").innerHTML = content;

        }

    }



})

const deleteBtn = document.getElementById("deleteBtn");

deleteBtn.addEventListener("click", function () {
    const id = document.getElementById("deleteItemId").value;
    const req = new XMLHttpRequest();
    const url = "../deleteItem/" + id;
    req.open("DELETE", url);
    req.setRequestHeader("Content-Type", "application/json;charset=UTF-8");
    req.send();

    window.location.reload(true);



})