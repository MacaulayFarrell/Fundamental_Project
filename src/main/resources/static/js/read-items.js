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
          
          content += '<tr><td>' + arr[i].id + '</td><td>' + arr[i].itemName + '</td><td>' + arr[i].itemCategory + '</td><td>' + arr[i].itemQuantity + '</td></tr>';

          document.getElementById("tableBody").innerHTML = content;

      }

  }



})

