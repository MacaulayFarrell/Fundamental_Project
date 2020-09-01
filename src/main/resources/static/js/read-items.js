window.addEventListener("load", function() {
    const req = new XMLHttpRequest();
    req.onreadystatechange = () => {
        // Example handle logic
        if (req.status === 200 && req.readyState === 4) {
            if (req.getResponseHeader("Content-Type") === "application/json") {

                let stuff = JSON.parse(req.response);
                stuff.forEach(el => {

                    let main = document.getElementById('content');
                    let header = document.createElement('h3');
                    header.textContent = "Shop name: " + el.shopName;
                    main.appendChild(header);
                    let table = document.createElement('table');
                    table.innerHTML =
                        '<thead>' +
                          '<tr>' +
                            '<th>Item ID</th>' +
                            '<th>Item Name</th>' +
                            '<th>Item Category</th>' +
                            '<th>Item Quantity</th>' +
                         '</tr>' +
                        '</thead>' +
                        '<tbody>';

                    el.shops.forEach(shop => {

                          table.innerHTML += '<tr><td>' + shop.id + '</td><td>' + shop.itemName + '</td><td>' + shop.itemCategory + '</td><td>' + shop.itemQuantity + '</td></tr>';
                          main.appendChild(table);
                    })

                })
            } else {
                console.log(
                    "Looks like its not JSON but lets see what it is... " + req.responseText
                );
            }
        } else {
            console.log("Oh no... handle error");
        }
    };
    req.open("GET", "http://localhost:8080/getShops");
    req.send();
})