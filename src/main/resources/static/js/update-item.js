"use strict";
//populate select dropdown
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

        let content = "<option value=null>Please select an item: </option>";
        let i;
        for(i = 0; i < arr.length; i++) {

            content += '<option value="' + arr[i].id + '">' + "ID: " + arr[i].id + " || Name: " + arr[i].itemName + " || Category: " + arr[i].itemCategory + " || Quantity: " + arr[i].itemQuantity + '</option>';
            document.getElementById("updateItemId").innerHTML = content;

        }

    }

})
//update feature
const updateBtn = document.getElementById("updateItemBtn");

updateBtn.addEventListener("click", function () {

    const id = document.getElementById("updateItemId").value;
    const itemName = document.getElementById("updateItemName").value;
    const itemCategory = document.getElementById("updateItemCategory").value;
    const itemQuantity = document.getElementById("updateItemQuantity").value;
    if(id === "null" || itemName === "" || itemCategory === "null" || itemQuantity === "" ) {
        alert("A field is empty, please complete the form and try again!")
    }
    else {

        const req = new XMLHttpRequest();
        const url = "../updateItem/" + id;
        req.open("PUT", url);

        req.setRequestHeader("Content-Type", "application/json;charset=UTF-8");
        let data = {itemName: itemName, itemCategory: itemCategory, itemQuantity: itemQuantity};
        req.send(JSON.stringify(data));

        window.location.reload(true);
    }
})
//auto populate feature
const selector = document.getElementById("updateItemId");

selector.addEventListener("change", function () {

    const request = new XMLHttpRequest();
    const url = "../getItemById/" + selector.value;

    request.onreadystatechange = function() {
        if (this.readyState == 4 && this.status == 200) {
            const myArr = JSON.parse(this.responseText);
            document.getElementById("updateItemName").value = myArr.itemName
            document.getElementById("updateItemCategory").value= myArr.itemCategory
            document.getElementById("updateItemQuantity").value = myArr.itemQuantity;

        }

    };

    request.open("GET", url);
    request.send();

})
