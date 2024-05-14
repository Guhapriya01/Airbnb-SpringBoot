document.addEventListener("DOMContentLoaded", loadContent);

function loadContent(){
	
	document.getElementById("admin").addEventListener("click", () => {
		let element = document.getElementById("sign");
		element.style.visibility = element==null || element.style.visibility == "hidden" ? "visible" : "hidden";
	});
	
	// Fetch and display event for updating
	fetch("/events")
		.then(response => response.json())
		.then(data => {
			const resultList = document.getElementById("update-delete");
			resultList.innerHTML="";
			
			if(data.length==0){
				resultList.innerHTML="No Events to show!";
				return;
			}
			data.forEach(item => {
				const element = document.createElement("tr");
				element.className = "ud-element";
				element.innerHTML = `
					
					<td><p>${item.title}</p></td>
					<td><button class="delete-btn" onclick="deleteEvent('${item.id}')">Delete</button></td>
					<td><button class="update-btn" onclick="updateEvent('${item.id}')">Update</button></td>
					
					`;
				resultList.appendChild(element);
			});
		})
		.catch(error => console.error('Error:', error));
}

//  delete and update

function deleteEvent(id){
	fetch('/deleteEvent?id=' + id, {
            method: 'POST', 
        })
        .then(function(response) {
            return response;
        })
        .then(function() {
            loadContent();
        })
        .catch(function(error) {
            console.error('Error deleting event:', error);
        });
}


function updateEvent(id){
	window.location.href = '/update?id='+id;
}