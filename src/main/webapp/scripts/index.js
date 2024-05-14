// Function to fetch events and display them
function fetchAndDisplayEvents(url) {
	fetch(url)
		.then(response => response.json())
		.then(data => {
			const resultList = document.getElementById("events");
			resultList.innerHTML = ""; // Clear previous search results

			if (data.length == 0) {
				resultList.innerHTML = "No Events!";
				return;
			}

			data.forEach(item => {
				const element = document.createElement("div");
				element.className = "card";
				let img = "data:image/jpeg;base64," + item.coverImage;

				element.innerHTML = `
                        <img class='card-img' src=${img} alt=""/>
                        <div class="card-content">
                            <div class='card-stats'>
                                <img class='card-star' src="./images/Star 1.png" alt="rating star"/>
                                <span>${item.ratings}</span>
                                <span class="gray">(${item.reviewCount})</span>
                                <span class="gray">${item.location}</span>
                            </div>
                            <p class='card-title'>${item.title}</p>
                            <p class='card-price'><b>From ${item.price}</b> / person</p>
                        </div>`;
				resultList.appendChild(element);
			});
		})
		.catch(error => console.error('Error:', error));
}

document.addEventListener("DOMContentLoaded", function() {

	document.getElementById("user").addEventListener("click", () => {
		let element = document.getElementById("sign");
		console.log(element.style.visibilty);
		element.style.visibility = element == null || element.style.visibility == "hidden" ? "visible" : "hidden";
	});

	// Initial fetch and display all events
	fetchAndDisplayEvents("/events");

	// Add event listener to the search form
	const searchForm = document.querySelector(".search-bar form");
	searchForm.addEventListener("submit", function(event) {
		event.preventDefault(); // Prevent form submission

		const formData = new FormData(searchForm);

		console.log(formData);
		const searchParams = new URLSearchParams(formData);
		let res = "";

		searchParams.forEach((v, key) => {

			let val = v == "" ? "NULL" : v;

			if (val == "NULL") {
				if (key == "price" || key == "reviewCount") val = "0";
			}
			res = res + key + "=" + val + "&";
		})

		console.log(res);
		console.log(res.slice(0, -1));

		// Fetch and display events based on search parameters
		fetchAndDisplayEvents("/search?" + res.slice(0, -1));
	});
});

function clearSearch() {
	document.getElementById("s-form").reset();
	fetchAndDisplayEvents("/events");
}