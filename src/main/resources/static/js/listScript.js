// Find max id of list items
let getMaxId = () => {
    let listItemElements = document.querySelectorAll(".list-item");
    let max = -1;
    for(let element of listItemElements){
        max = +element.dataset.index > max ? +element.dataset.index : max;
    }

    return max;
}

// Function that handles the deletion of an item
function deleteButtonHandler(index){
    let listItemElements = document.querySelectorAll(".list-item");
    for(let element of listItemElements){
        let current = +element.dataset.index;
        if(current < index){
            continue;
        }
        else if(current === index){
            element.remove();
        }
        else if(current > index){
            element.dataset.index = current-1;
            element.querySelector("button").setAttribute("onclick", `deleteButtonHandler(${current - 1})`);
            element.querySelector(`[type="checkbox"]`).setAttribute("value", `${current - 1}`);
            element.querySelector(`[type="hidden"]`).setAttribute("name", `_checkedList`);
            element.querySelector(`[type="text"]`).setAttribute("name", `itemList[${current - 1}]`);
        }
    }
}

// Handler that deals with creating a new item
document.querySelector("#add-item").onclick = (event) => {
    let max = getMaxId();
    let newListItem = document.createElement("div");
    newListItem.dataset.index = max+1;
    newListItem.classList.add("list-item");
    newListItem.innerHTML = `
                    <button onclick="deleteButtonHandler(${max+1})" class="remove-item" type="button">-</button>
                    <input type="checkbox" name="checkedList" value="${max+1}">
                    <input type="hidden" name="_checkedList" value="on">
                    <input type="text" name="itemList[${max+1}]" required>
    `;
    document.querySelector("#list").append(newListItem);
};

// Automatically expand the item
var autoExpand = function (field) {

    field.style.width = "inherit"
	field.style.height = "inherit";

	var computed = window.getComputedStyle(field);

	var width= parseInt(computed.getPropertyValue("border-left-width"), 10)
	             + parseInt(computed.getPropertyValue("padding-left"), 10)
	             + field.scrollWidth
	             + parseInt(computed.getPropertyValue("padding-right"), 10)
	             + parseInt(computed.getPropertyValue("border-right-width"), 10);

	field.style.width = width + "px";

};

document.addEventListener("input", function (event) {
	if (event.target.tagName.toLowerCase() !== "input") return;
	autoExpand(event.target);
}, false);

document.querySelectorAll("input").forEach((element) => {autoExpand(element)});