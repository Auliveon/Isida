

function addLink(event) {
    event.preventDefault();
    let inputLine = document.getElementById("form:inputTextId");
    console.log(event.target);
    inputLine.value = event.target.href;
}