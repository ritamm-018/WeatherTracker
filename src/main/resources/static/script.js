document.getElementById('weatherForm').addEventListener('submit', function(event) {
    event.preventDefault(); // Prevent the form from refreshing the page

    const city = document.getElementById('city').value.trim(); // Get the city name from the input

    if (city) {
        // Fetch weather data from the backend
        fetch(`/weather?city=${city}`)
            .then(response => {
                if (!response.ok) {
                    throw new Error('Error fetching weather data');
                }
                return response.json();
            })
            .then(data => {
                // Update the weather details on the page
                document.getElementById('cityName').textContent = data.city;
                document.getElementById('temperature').textContent = data.temperature;
                document.getElementById('condition').textContent = data.condition;
                document.getElementById('windSpeed').textContent = data.windSpeed;

                // Show the weather details section
                document.getElementById('weatherDetails').classList.remove('hidden');
            })
            .catch(error => {
                alert('Error fetching weather data. Please try again.');
                console.error(error);
            });
    } else {
        alert('Please enter a valid city name.');
    }
});

