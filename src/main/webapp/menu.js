clearInputFields();
loadMenuList();

function loadMenuList() {
    let xhttp = new XMLHttpRequest();
    xhttp.onreadystatechange = function () {
        if (this.readyState == 4 && this.status == 200) {
            let menuDataList = JSON.parse(this.responseText);
            let menuList = ' <ul class="w3-ul w3-card-4"> ';

            menuDataList.reverse();

            for (let index = 0; index < menuDataList.length; index++) {
                menuList +=
                    ' <li class="w3-bar"> ' +

                    ' <button id= ' + menuDataList[index].id + ' onclick="editMenu(this.id)" ' +
                    ' class="w3-bar-item w3-button w3-small w3-right">Edit</button> ' +

                    ' <button id=' + menuDataList[index].id + ' onclick="removeMenu(this.id)" ' +
                    ' class="w3-bar-item w3-button w3-small w3-right">Remove</button> ' +


                    ' <img src="images/icons8-reading-48.png" class="w3-bar-item w3-circle w3-hide-small" style="width:85px"> ' +
                    ' <div class="w3-bar-item"> ' +
                    ' <span class="w3-large"> Title: ' +  menuDataList[index].name  + ' </span><br> ' +
                    ' <span> Author: ' +  menuDataList[index].author  + ' </span> <br>' +

                    ' <span> ISBN: ' +  menuDataList[index].isbn  + ' </span> ' +
                    ' </div> ';
            }
            menuList += "</ul>";
            document.getElementById("menuData").innerHTML = menuList;
        }
    };
    xhttp.open("GET", "http://localhost:8083/KitchenSchedule_war_exploded/api/menu/list", true);
    xhttp.send();
}

function addMenu() {
    let menu = {  "id" : null, "breakfast" : document.getElementById("breakfast").value, "lunch" : document.getElementById("lunch").value, "dinner" : document.getElementById("dinner").value,
        "special_meals" : document.getElementById("special_meals").value, "description" : document.getElementById("description").value}
    var xmlhttp = new XMLHttpRequest();
    xmlhttp.open("POST", "http://localhost:8083/ScheduleKitchenRest_war_exploded/api/menu/add", true);
    xmlhttp.onreadystatechange = function() {
        if (xmlhttp.readyState>3 && xmlhttp.status==200) { loadMenuList(); clearInputFields();}
    };
    xmlhttp.setRequestHeader("Content-Type", "application/json");
    xmlhttp.send(JSON.stringify(menu));
}

function updateMenu()
{
    let menu = {  "id" : null, "breakfast" : document.getElementById("breakfast").value, "lunch" : document.getElementById("lunch").value, "dinner" : document.getElementById("dinner").value,
        "special_meals" : document.getElementById("special_meals").value, "description" : document.getElementById("description").value }
    var xmlhttp = new XMLHttpRequest();
    xmlhttp.open("PUT", "http://localhost:8083/ScheduleKitchenRest_war_exploded/api/menu/update", true);
    xmlhttp.onreadystatechange = function() {
        if (xmlhttp.readyState>3 && xmlhttp.status==200) { loadMenuList(); clearInputFields(); document.getElementById("btnSaveMenu").innerHTML = "Add Menu";}
    };
    xmlhttp.setRequestHeader("Content-Type", "application/json");
    xmlhttp.send(JSON.stringify(menu));
}

function clearInputFields()
{
    document.getElementById("breakfast").value = "";
    document.getElementById("lunch").value = "";
    document.getElementById("dinner").value = "";
    document.getElementById("specials").value = "";
    document.getElementById("description").value = "";
    document.getElementById("btnSaveMenu").innerHTML = "Add Menu";
}

function removeBook(menuId)
{
    if ( confirm("Do you want to delete this Menu?") ) {
        deleteBook(menuId);
    }
}

function deleteBook(menuId)
{
    let menu = {  "id" : null, "breakfast" : document.getElementById("breakfast").value, "lunch" : document.getElementById("lunch").value, "dinner" : document.getElementById("dinner").value,
        "special_meals" : document.getElementById("special_meals").value, "description" : document.getElementById("description").value }
    var xhttp = new XMLHttpRequest();
    xhttp.open("DELETE", "http://localhost:8083/ScheduleKitchenRest_war_exploded/api/menu/remove", true);
    xhttp.onreadystatechange = function() {
        if (xhttp.readyState>3 && xhttp.status==200) { loadMenuList(); }
    };
    xhttp.setRequestHeader("Content-Type", "application/json");
    xhttp.send(JSON.stringify(menu));
}

function getMenu(menuId)
{
    let menu = {  "id" : null, "breakfast" : document.getElementById("breakfast").value, "lunch" : document.getElementById("lunch").value, "dinner" : document.getElementById("dinner").value,
        "special_meals" : document.getElementById("special_meals").value, "description" : document.getElementById("description").value }

    let xhttp = new XMLHttpRequest();
    xhttp.onreadystatechange = function () {
        if (xhttp.readyState>3 && xhttp.status==200) {
            let foundMenu = JSON.parse(this.responseText);

            document.getElementById("menuId").value = foundMenu.id;
            document.getElementById("breakfast").value = foundMenu.breakfast;
            document.getElementById("lunch").value = foundMenu.lunch;
            document.getElementById("dinner").value = foundMenu.dinner;
            document.getElementById("specials").value = foundMenu.special_meals;

            document.getElementById("btnSaveMenu").innerHTML = "Update Menu";
        }
    };
    xhttp.open("POST", "http://localhost:8083/ScheduleKitchenRest_war_exploded/api/menu/getBook", true);
    xhttp.setRequestHeader("Content-Type", "application/json");
    xhttp.send(JSON.stringify(menu));
}

function editMenu(menuId)
{
    getMenu(menuId);
}

function saveMenu()
{
    if(validateForm())
    {
        if(document.getElementById("btnSaveMenu").innerHTML == 'Add Menu')
        {
            addMenu();
        }
        else
        {
            updateMenu();
        }
    }
}

function validateForm()
{
    let pass = true;
    let breakfast = document.getElementById("breakfast").value;
    let lunch = document.getElementById("lunch").value;
    let dinner = document.getElementById("dinner").value;

    if (breakfast == null || breakfast == "", lunch == null || lunch == "", dinner == null || dinner == "")
    {
        alert("Please fill in all the fields.");
        pass = false;
    }

    return pass;
}
